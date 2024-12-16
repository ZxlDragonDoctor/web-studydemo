package com.zxl.webspringmvc.webspringmvc.service;


import com.zxl.webspringmvc.webspringmvc.entity.Customer;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {
    //非持久化存储，保存在内存
    private Map<Long, Customer> customerMap = new HashMap<>();

    public CustomerServiceImpl() {
    }

    @Override
    public Customer addCustomer(Customer customer) {
        customerMap.put(customer.getId(), customer);
        return customer;
    }

    @Override
    public Customer getCustomer(long id) {
        return customerMap.get(id);
    }
}