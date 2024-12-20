package com.zxl.springmvcin.webspringmvcin.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.io.IOException;


@WebServlet(name="FileUpLoadServlet", value={"/file-upload"})
@MultipartConfig(location="D:\\", fileSizeThreshold=1024)
public class FileUploadServlet extends HttpServlet {
    // 返回上传来的文件名
    private static Log log = LogFactory.getLog(FileUploadServlet.class);

    private String getFilename(Part part) {
        String fname = null;
        // 返回上传的文件部分的content-disposition请求头的值
        String header = part.getHeader("content-disposition");
        log.info(header);
        log.info("文件名："+header.lastIndexOf("=") + 2);
        log.info(header.length() - 1);
        // 返回不带路径的文件名
        fname = header.substring(header.lastIndexOf("=") + 2, header.length() - 1);
        return fname;
    }

    /**
     *
     *  * part对象上传方式
     *
     * @param request an {@link HttpServletRequest} object that contains the request the client has made of the servlet
     *
     * @param response an {@link HttpServletResponse} object that contains the response the servlet sends to the client
     *
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = this.getServletContext().getRealPath("/"); // 返回Web应用程序文档根目录
        log.info(path);
        String mnumber = request.getParameter("mnumber");
        Part p = request.getPart("fileName");
        String message = "";
        String fname = "";
        if (p.getSize() > 1024 * 1024) { // 上传的文件不能超过1MB大小
            p.delete();
            message = "文件太大，不能上传！";
        } else {
            path = path + "\\member\\" + mnumber; // 文件存储在文档根目录下member子目录中会员号子目录中
            File f = new File(path);
            if (!f.exists()) { // 若目录不存在，则创建目录
                f.mkdirs();
            }
            fname = getFilename(p); // 得到文件名
            p.write(path + "\\" + fname); // 将上传的文件写入磁盘
            message = "文件上传成功！";
        }
        request.setAttribute("message", message);
        request.setAttribute("mnumber", mnumber);
        request.setAttribute("path", path);
        request.setAttribute("fname", fname);
        String dispatchUrl = "uploadOk.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
        rd.forward(request, response);
    }
}
