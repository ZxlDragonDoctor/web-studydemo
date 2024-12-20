package com.example.javawebexptest.eneity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Categories  implements Serializable {
     private Integer cate_id;
     private String cate_name;
}
