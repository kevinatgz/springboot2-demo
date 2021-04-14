package com.example.springbootdemo.domain;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@Getter
public class CarDto implements Serializable {
    private String manufacturer;

    public Integer getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(Integer seatCount) {
        this.seatCount = seatCount;
    }

    private Integer seatCount;
    private String name;
    private BigDecimal power;
}
