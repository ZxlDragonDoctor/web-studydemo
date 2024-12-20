package com.zxl.webspring.webspring.eneity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Passenger {
    private String name;
    private Country country;

    public Passenger(Country country) {
    }
}
