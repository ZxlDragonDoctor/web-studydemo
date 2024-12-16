package com.zxl.springmvcin.webspringmvcin.controller;

import com.zxl.springmvcin.webspringmvcin.pojo.Product;
import com.zxl.springmvcin.webspringmvcin.pojo.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {
    @RequestMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @RequestMapping("/user-login")
    public String employeeLogin(User user, Model model, HttpSession session) {
        if ("admin".equals(user.getUsername()) && "12345".equals(user.getPassword())) {
            session.setAttribute("user", user); // 登录成功，将用户信息保存到session对象中
            return "forward:toIndex";
        } else {
            return "login";
        }
    }


    @RequestMapping(value = "/toIndex")
    public String toIndex(Model model) {
        List<Product> productList = new ArrayList<Product>();
        productList.add(new Product(101, "Lenovo笔记本电脑", "Lenovo", new BigDecimal("4500.00")));
        productList.add(new Product(102, "华为手机", "华为", new BigDecimal("2500.00")));
        model.addAttribute("productList", productList);
        return "main";
    }
}