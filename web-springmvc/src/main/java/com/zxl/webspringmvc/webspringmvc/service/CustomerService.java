package com.zxl.webspringmvc.webspringmvc.service;

import com.zxl.webspringmvc.webspringmvc.entity.Customer;

public interface CustomerService {
    //添加
    public Customer addCustomer(Customer customer);
    //获取
    public Customer getCustomer(long id);
}
