package com.zxl.webspringmvc.webspringmvc.controller;

import com.zxl.webspringmvc.webspringmvc.entity.User2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Spring MVC的数据绑定与表单标签库
 */
@Controller
public class User2Controller {
    //TODO:掌握@ModelAttribute注解的使用
    @RequestMapping(value = "/input-user", method = RequestMethod.GET)
    public ModelAndView inputUser() {
        User2 user = new User2();
        user.setHobby(new String[]{"游泳", "读书", "登山"});
        user.setGender("M");
        //TODO:第一个参数"inputUser"是视图的逻辑名称，它将被视图解析器用来解析为实际的视图（例如JSP页面）。
        // 第二个参数"command"是模型中对象的名称，它将在视图中作为属性的键。在JSP中，
        // 你可以通过${command.hobby}来访问User2对象的hobby属性。
        // 第三个参数user是User2对象本身，它将被添加到模型中，以便在视图中使用。
        ModelAndView modelAndView = new ModelAndView("inputUser", "command", user);
        return modelAndView;
    }

    @RequestMapping(value = "/save-user", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User2 user, ModelMap model) {
        model.addAttribute("username", user.getUsername());
        model.addAttribute("password", user.getPassword());
        model.addAttribute("resume", user.getResume());
        model.addAttribute("receiveEmail", user.isReceiveEmail());
        model.addAttribute("hobbyList", user.getHobby());
        model.addAttribute("gender", user.getGender());
        model.addAttribute("languageList", user.getLanguage());
        model.addAttribute("education", user.getEducation());
        model.addAttribute("skills", user.getSkills());
        return "showUser2";
    }

    @ModelAttribute("hobbyList")
    public List<String> getHobbyList() {
        List<String> hobbyList = new ArrayList<String>();
        hobbyList.add("读书");
        hobbyList.add("游泳");
        hobbyList.add("登山");
        return hobbyList;
    }

    @ModelAttribute("languageList")
    public List<String> getLanguageList() {
        List<String> languageList = new ArrayList<String>();
        languageList.add("C");
        languageList.add("C++");
        languageList.add("Java");
        languageList.add("Python");
        return languageList;
    }

    @ModelAttribute("educationList")
    public Map<String, String> getEducationList() {
        Map<String, String> educationList = new HashMap<String, String>();
        educationList.put("1", "学士");
        educationList.put("2", "硕士");
        educationList.put("3", "博士");
        return educationList;
    }

    @ModelAttribute("skillsList")
    public Map<String, String> getSkillsList() {
        Map<String, String> skillList = new HashMap<String, String>();
        skillList.put("Spring", "Spring");
        skillList.put("Spring MVC", "Spring MVC");
        skillList.put("MyBatis", "MyBatis");
        return skillList;
    }
}