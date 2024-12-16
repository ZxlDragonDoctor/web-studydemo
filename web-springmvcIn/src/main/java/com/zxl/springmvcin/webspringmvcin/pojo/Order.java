package com.zxl.springmvcin.webspringmvcin.pojo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @NotBlank(message="{err.id}")
    private String id;

    @NotBlank(message="{err.name}")
    private String name;

    @Email(message="{err.email}")
    private String email;

    @Min(value=100, message="{err.price}")
    private float price;
}