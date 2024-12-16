package com.zxl.webspringmvc.webspringmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

/**
 * 1.@RequestMapping 注解修饰的方法中向下一个转发页面传递Request作用域数据的五种方法：
 * 2.@RequestMapping 注解修饰的方法中向下一个重定向页面传递Session作用域数据的三种方法
 */

@SessionAttributes(value = {
        "testModelSessionDomain",
        "testMapSessionDomain",
        "testModelMapSessionDomain",
        "testModelAndViewSessionDomain",
        "test"})
@Controller
public class TestDomainConroller {
    //  TODO:注解修饰的方法中向下一个转发页面传递Request作用域数据的五种方法
//    原生servlet api
    @RequestMapping("/testServletAPIRequestDomain")
    public String testServletAPIRequestDomain(HttpServletRequest request) {
        request.setAttribute("testServletAPIRequestDomain", "This is a test Servlet API Request Domain");
        return "ok";
    }
// model接口
    @RequestMapping("/testModelRequestDomain")
    public String testModelRequestDomain(Model model) {
        model.addAttribute("testModelRequestDomain", "This is a test model request domain");
        return "ok";
    }
    // Map接口
    @RequestMapping("/testMapRequestDomain")
    public String testModelRequestDomain(Map<String, Object> map) {
        map.put("testMapRequestDomain", "This is a test map request domain");
        return "ok";
    }
    // ModelMap类
    @RequestMapping("/testModelMapRequestDomain")
    public String testModelRequestDomain(ModelMap mmap) {
        mmap.addAttribute("testModelMapRequestDomain", "This is a test modelMap request domain");
        return "ok";
    }
    // ModelAndView类
    @RequestMapping("/testModelAndViewRequestDomain")
    public ModelAndView testModelAndViewRequestDomain() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("testModelAndViewRequestDomain", "This is a test ModelAndView request domain");
        mav.setViewName("ok");
        return mav;
    }

    //TODO:注解修饰的方法中向下一个重定向页面传递Session作用域数据的三种方法

    // RedirectAttributes类对象的addFlashAttribute方法：
    @RequestMapping("/testRedirectAttributes")
    public String testServletAPISessionDomain(RedirectAttributes ras) {
        ras.addFlashAttribute("testFlashAttribute", "This is a test Flash Attribute");
        return "redirect:haha";
    }

    @RequestMapping("/haha")
    public String testServletAPISessionDomain() {
        return "ok";
    }

    // 使用Servlet原生API
    @RequestMapping("/testServletAPISessionDomain")
    public String testServletAPISessionDomain(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("testServletAPISessionDomain", "This is a test Servlet API session domain");
        return "redirect:ok.jsp";
    }
    //使用@SessionAttributes注解
    @RequestMapping("/testSessionDomain")
    public String testSessionDomain(Model model, Map<String, Object> map, ModelMap mmp) {
        model.addAttribute("testModelRequestDomain", "This is a test model request domain");
        model.addAttribute("testModelSessionDomain", "This is a test model session domain");
        mmp.addAttribute("testModelMapRequestDomain", "This is a test modelMap request domain");
        mmp.addAttribute("testModelMapSessionDomain", "This is a test modelMap session domain");
        map.put("testMapRequestDomain", "This is a test map request domain");//testMapRequestDomain没有在注解中标识
        map.put("testMapSessionDomain", "This is a test map Session domain");
        return "redirect:ok.jsp";
    }
    // session注解和ModelAndView
    @RequestMapping("/testModelAndViewSessionDomain")
    public ModelAndView testModelAndViewSessionDomain() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("testModelAndViewRequestDomain", "This is a testModelAndView request domain");
        mav.addObject("testModelAndViewSessionDomain", "This is a testModelAndView Session domain");
        mav.setViewName("redirect:ok.jsp");
        return mav;
    }

}
