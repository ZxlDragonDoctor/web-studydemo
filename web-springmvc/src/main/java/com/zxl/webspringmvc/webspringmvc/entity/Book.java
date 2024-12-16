package com.zxl.webspringmvc.webspringmvc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {
    private String isbn;
    private String name;
    private String author;
    @DateTimeFormat(pattern = "yyyy-MM-dd") //格式化日期，非常方便
    private LocalDate pubdate;
    private BigDecimal price;
}