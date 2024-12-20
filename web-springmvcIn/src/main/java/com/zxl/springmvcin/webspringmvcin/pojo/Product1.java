package com.zxl.springmvcin.webspringmvcin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product1 implements Serializable {
    private Integer id;
    private String name;
    private String brand;
    private BigDecimal price;

    private List<MultipartFile> images; //商品图片

}