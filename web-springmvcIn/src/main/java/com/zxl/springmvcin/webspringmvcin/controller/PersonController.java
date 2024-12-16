package com.zxl.springmvcin.webspringmvcin.controller;

import com.zxl.springmvcin.webspringmvcin.pojo.Person;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonController {

    @GetMapping("/input-person")
    public String inputPerson(@ModelAttribute("user")Person person,Model model) {
        model.addAttribute("user",new Person());
        return "inputPerson";
    }

    @PostMapping("/show-person")
    public String showPerson(@ModelAttribute("user") @Valid Person person, Model model) {
        System.out.println(model.getAttribute("user"));
        return "showPerson";
    }
}