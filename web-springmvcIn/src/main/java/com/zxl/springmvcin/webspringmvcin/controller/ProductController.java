package com.zxl.springmvcin.webspringmvcin.controller;

import com.zxl.springmvcin.webspringmvcin.pojo.Product1;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("commonsFileUpload")
public class ProductController {
    private static final Log logger = LogFactory.getLog(ProductController.class);

    @RequestMapping(value="/input-product")
    public String inputProduct(Model model) {
        model.addAttribute("product", new Product1());
        return "inputProduct";
    }

    /**
     * 使用Spring MVC的MultipartResolver
     * @param request
     * @param product
     * @param model
     * @return
     */
    @RequestMapping(value="/save-product")
    public String saveProduct(HttpServletRequest request, @ModelAttribute Product1 product, Model model) {
        System.out.println("执行save-product");
        List<MultipartFile> files = product.getImages();
        List<String> fileNames = new ArrayList<String>();
        if (null != files && files.size() > 0) {
            for (MultipartFile multipartFile : files) {
                String fileName = multipartFile.getOriginalFilename();
                logger.info(fileName);
                fileNames.add(fileName);
                File imageFile = new File(request.getServletContext().getRealPath("/images"), fileName);
                model.addAttribute("filename", imageFile.getAbsolutePath());
                try {
                    multipartFile.transferTo(imageFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        model.addAttribute("product", product); // 保存商品信息
        return "showProduct";
    }
    @RequestMapping("test")
    public String test(){
        return "showProduct";
    }
}