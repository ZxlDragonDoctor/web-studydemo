package com.zxl.webspringmvc.webspringmvc.entity;


import jakarta.validation.constraints.DecimalMin;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * 数据验证
 */
public class Person {
    @Length(min=18,max=18)
    private String id;//身份证号
    @Length(min=2,max=20)
    private String name;
    @Range(min=0,max=120)
    private int age;
    @Pattern(regexp = "^1[3-9]\\d{9}$")
    private String phoneNumber;
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
    private String email;
    private String sex;
    private String homepage;
    @DecimalMin(value="2000")
    private Double salary;
    private String creditCardNumber;
}
