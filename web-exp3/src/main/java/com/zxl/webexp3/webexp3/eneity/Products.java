package com.zxl.webexp3.webexp3.eneity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products implements Serializable {
    private Integer id;
    private String pname;
    private Integer category;
    private String image;
    private String brand;
    private Double price;
}