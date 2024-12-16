package com.zxl.springmvcin.webspringmvcin.controller;

import com.zxl.springmvcin.webspringmvcin.pojo.Order;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ThemeResolver;

import java.util.Locale;


@Controller
public class OrderController {

    @Autowired
    private LocalValidatorFactoryBean myValidator;

    @Autowired
    private LocaleResolver localeResolver;

    @Autowired
    private ThemeResolver themeResolver;

    @PostMapping("/addOrder")
    public String order(Order order, BindingResult result) {
        myValidator.validate(order, result);
        if (result.hasErrors()) {
            return "orderForm";
        }
        return "orderOk";
    }
    @GetMapping("/order")
    public String orderIndex(@ModelAttribute("order") Order order ,Model model, Locale locale) {
        model.addAttribute("msg", "嗨嗨嗨");
        model.addAttribute("order", new Order( "12", "预输入",  "email", 12));
        return "orderForm";
    }

    @GetMapping("/language/{lg}")
    public String changeLanguage(@PathVariable("lg") String language,
                                 HttpServletRequest req, HttpServletResponse resp) {
        Locale locale = new Locale(language);
        localeResolver.setLocale(req, resp, locale);
        return "redirect:/order";
    }
}