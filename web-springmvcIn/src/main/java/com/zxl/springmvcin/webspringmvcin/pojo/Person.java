package com.zxl.springmvcin.webspringmvcin.pojo;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Length(min=18, max=18, message="身份证号码长度必须是18位")

    private String id;
    @Length(min=2, max=20, message="姓名字段长度需在2-20个字符之间")
    private String name;

    private String sex;

    @Range(min=20, max=60, message="年龄必须在20到60之间")
    private int age;

    @Pattern(regexp="13[1089]\\d{8}", message="电话格式错误，以13开头，第3位为0,1,8,9，长度为11位")
    private String phonenumber;

    @Email
    private String email;
    @URL
    private String homepage;

    @DecimalMin(value="4000")
    private double salary;

    @CreditCardNumber
    private String creditCardNumber;
}