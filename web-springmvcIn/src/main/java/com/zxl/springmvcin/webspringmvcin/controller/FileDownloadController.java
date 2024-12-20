package com.zxl.springmvcin.webspringmvcin.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class FileDownloadController {
    @Autowired
    private ResourceLoader resourceLoader;
    private static final Log logger = LogFactory.getLog(FileDownloadController.class);
    private static final String FILE_DIRECTORY = "D:\\javaWebTestDownload\\";

//    @GetMapping(value = "/yu-download")
//    public String yudownLoad(Model model, HttpServletRequest request) {
//        String path = request.getServletContext().getRealPath("/");
//        model.addAttribute("path", path);
//        return "download";
//    }
    @GetMapping("/office-download")
    public void officeDownload(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String doctype = request.getParameter("doctype");
        if (doctype.equals("word")) {
            doctype = "application/msword;charset=gb2312";
            response.setContentType(doctype);
            response.setHeader("Content-Disposition", "attachment;filename=data.doc");
        } else {
            doctype = "application/vnd.ms-excel;charset=gb2312";
            response.setContentType(doctype);
            response.setHeader("Content-Disposition", "attachment;filename=excel.xls");
        }
        PrintWriter out = response.getWriter();
        out.println("学号\t姓名\t性别\t年龄\t所在系");
        out.println("95001\t李勇\t男\t20\t信息");
        out.println("95002\t刘晨\t女\t19\t数学");
    }
    @RequestMapping(value = "/file-download")
    public String download(@RequestParam String filename, HttpServletRequest request, HttpServletResponse response, Model model) {
        //WEB-INF下的资源是受保护的，直接请求是拿不到的，可通过请求转发或者视图解析器访问到
        String path = request.getServletContext().getRealPath("/WEB-INF/data");
        Path file = Paths.get(path, filename);
        if (Files.exists(file)) {
            response.setContentType(request.getServletContext().getMimeType(filename));
            response.setHeader("Content-Disposition", "attachment;filename=" + filename);
            try {
                Files.copy(file, response.getOutputStream());
            } catch (IOException ex) {
                // Handle exception
            }
        }
        return null;
    }
    @GetMapping("/aadownload/{filename}")
    public void aadownDownload(@PathVariable String filename, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("adddadddd");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
        OutputStream os = response.getOutputStream();
        ServletContext context = request.getServletContext();
        /**TODO:
         * src/main/resources 的资源属于类路径（classpath）：
         *
         * 在打包时，这些资源会被复制到 WEB-INF/classes 目录中。
         * ServletContext 无法直接访问 WEB-INF/classes 的文件，因为它不暴露类路径的资源。
         * 必须通过 Java 的类加载器来访问类路径资源，例如 getClassLoader().getResourceAsStream()。
         * src/main/webapp 的资源属于 Web 路径：
         *
         * 它们直接被暴露为 Web 资源，因此可以通过 ServletContext 访问。
         */
        //它们直接被暴露为 Web 资源，因此可以通过 ServletContext 访问。
//        InputStream is = getClass().getClassLoader().getResourceAsStream("\\images\\" + filename)  不能获取到main/Resouces的资源
//        InputStream is = getClass().getClassLoader().getResourceAsStream("images/" + filename);
        InputStream is = resourceLoader.getResource("classpath:images/" + filename).getInputStream(); //推荐使用spring的ResourceLoader

        System.out.println("images\\"+filename);
        System.out.println(is);
        byte[] bytearray = new byte[1024];
        int bytesread = 0;
        while ((bytesread = is.read(bytearray)) != -1) {
            os.write(bytearray, 0, bytesread);
            os.flush();
        }
    }
    @GetMapping("/download/{fileName}")
    public void downloadFile(@PathVariable String fileName, HttpServletResponse response) throws IOException {
        File file = new File(FILE_DIRECTORY + fileName);
        logger.info("file is:" + file.length());
        if (file.exists()) {
            // 不清楚文件类型的情况下可以设置ContentType为application/octet-stream，让所有文件都能够下载，而不备游览器解析
            response.setContentType("application/octet-stream"); //

            response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
            response.setContentLength((int) file.length());
            try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
                byte[] buffer = new byte[1024];
                OutputStream os = response.getOutputStream();
                int i = 0;
                while ((i = bis.read(buffer)) != -1) {
                    os.write(buffer, 0, i);
                    os.flush();
                }
            } catch (IOException e) {
                logger.info("error occurs:" + fileName);
            }
        } else {
            logger.info("file not exists:" + file.getAbsolutePath());
        }
    }
}