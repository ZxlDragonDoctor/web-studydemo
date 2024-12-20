package com.example.javawebexptest.eneity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {
    private  Integer id;
    private  String pname;
    private  String brand;
    private  double price;
}
