package com.zxl.webspringmvc.webspringmvc.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User2 {
    private String username;      // 用户名
    private String password;      // 密码
    private String gender;        // 性别
    private String resume;        // 简历
    private String[] hobby;       // 业余爱好
    private String language;      // 精通的语言
    private String education;     // 学历
    private String[] skills;      // 技能
    private boolean receiveEmail; // 是否订阅邮件
}