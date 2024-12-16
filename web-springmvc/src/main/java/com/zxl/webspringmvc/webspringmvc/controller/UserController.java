package com.zxl.webspringmvc.webspringmvc.controller;

import com.zxl.webspringmvc.webspringmvc.DAO.UserDao;
import com.zxl.webspringmvc.webspringmvc.entity.User;
import com.zxl.webspringmvc.webspringmvc.tools.CaluateTime;
import com.zxl.webspringmvc.webspringmvc.tools.SequenceGenerator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Controller
public class UserController {
    @Autowired
    private UserDao userDao;

    @Autowired
    private User user;

    private static final Log logger = LogFactory.getLog("UserController.class");

    @PostMapping(value = "/regist-user2")
    public String saveCustomer(@RequestParam(value = "username") String username,
                              @RequestParam(value = "password") String password,
                              @RequestParam(value = "sex") String sex,
                              @RequestParam(value = "address") String address,
                              @RequestParam(value = "age") Integer age,
                              @RequestParam(name = "usertype") String usertype,
                              Model model) {
        logger.info("调用saveCustomer()方法");
        user.setId(SequenceGenerator.getNextSequence());
        user.setUsername(username);
        user.setAddress(address);
        user.setSex(sex);
        user.setPassword(password);
        LocalDate localDate = LocalDate.now().minusYears(age);
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(zoneId);
        Date birthday = new Date(zonedDateTime.toInstant().toEpochMilli());
        user.setBirthday(birthday);
        user.setUsertype(usertype);
        model.addAttribute("user", user);
        System.out.println(user);
        userDao.addUser(user);
        return "showUser";
    }

    @RequestMapping(value = "/regist-user3", method = RequestMethod.POST)
    public String loginUser(User user, Model model) {
        logger.info("用户登录");
        System.out.println(user);
        model.addAttribute("user", user);
        return "showUser";
    }

    @PostMapping(value = "/regist-user4")
    public String inputCustomer(String username, String password, String sex, String address, Integer age, String usertype, Model model) {
        logger.info("调用saveCustomer()方法");
        user.setId(SequenceGenerator.getNextSequence());
        user.setUsername(username);
        user.setAddress(address);
        user.setSex(sex);
        user.setPassword(password);
        Date birthday = new Date(567889);
        user.setBirthday(birthday);
        user.setUsertype(usertype);
        model.addAttribute("user", user);
        System.out.println(user);
        userDao.addUser(user);
        return "showUser";
    }

    @PostMapping(value = "/regist-user5")
    public String inputUser(HttpServletRequest request, HttpServletResponse response, Model model) {
        logger.info("调用inputUser()方法");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        String address = request.getParameter("address");
        Integer age = Integer.valueOf(request.getParameter("age"));
        String usertype = request.getParameter("usertype");
        user.setId(SequenceGenerator.getNextSequence());
        user.setUsername(username);
        user.setAddress(address);
        user.setSex(sex);
        user.setPassword(password);
//        Date birthday = new Date(567889);
        Date birthday = CaluateTime.calculateBirthday(age);
        user.setBirthday(birthday);
        user.setUsertype(usertype);
        model.addAttribute("user", user);
        System.out.println(user);
        userDao.addUser(user);
        return "showUser";
    }
}