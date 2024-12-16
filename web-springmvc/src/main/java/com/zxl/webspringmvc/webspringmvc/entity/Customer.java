package com.zxl.webspringmvc.webspringmvc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Customer {
    private long id;
    private String name;
    private String address;
    private double balance;
}