package com.example.springbootdemo.entity;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
//@Getter
//@Setter
public class Car implements Serializable {
    private String makes;

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    private Integer numberOfSeats;
    private String name;
    private BigDecimal power;
}