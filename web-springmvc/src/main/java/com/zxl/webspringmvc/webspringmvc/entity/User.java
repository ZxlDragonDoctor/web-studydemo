package com.zxl.webspringmvc.webspringmvc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class User {
    private int id;
    private String username;
    private String password;
    private String sex;
    private String usertype;
    private Date birthday;
    private String address;
}