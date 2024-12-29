package com.zxl.webexp11.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    private Integer studId;
    private String name;
    private String gender;
    private LocalDate birthday;
    private String phone;
}