package com.zxl.webspringmvc.webspringmvc.controller;

import com.zxl.webspringmvc.webspringmvc.entity.Customer;
import com.zxl.webspringmvc.webspringmvc.service.CustomerService;
import com.zxl.webspringmvc.webspringmvc.service.CustomerServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
    private static final Log logger = LogFactory.getLog("CustomerController.class");
    private  static final CustomerService cusService = new CustomerServiceImpl();
    @PostMapping(value = "/save-customer")
    public String inputCustomer(HttpServletRequest request, HttpServletResponse response, Model model){
        logger.info("调用inputCustomer方法");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String balance = request.getParameter("balance");
        Customer customer = new Customer();
        customer.setId(Long.parseLong(id));
        customer.setName(name);
        customer.setAddress(address);
        customer.setBalance(Double.parseDouble(balance));
        model.addAttribute("customer",customer);
        cusService.addCustomer(customer);
        return "showCustomer";
    }
}
