package com.zxl.webspringmvc.webspringmvc.controller;



import com.zxl.webspringmvc.webspringmvc.entity.Person;
import jakarta.validation.Valid;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonController {
    private static final Log logger = LogFactory.getLog("PersonController.class");

    @RequestMapping(value = "/input-person")
    public String inputPerson(@ModelAttribute("person") Person person,Model model){
        logger.info("inputPerson called");
        model.addAttribute("person",new Person());
        return "inputPerson";
    }
    @PostMapping(value = "/save-person")
//    数据验证
    public String showPerson(@Valid @ModelAttribute Person person, Model model){
        System.out.println(model.getAttribute("person"));
        return "showPerson";
    }

}
