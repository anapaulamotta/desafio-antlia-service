package com.example.demo.dto;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class MovementRequestDTO {

    private Integer month;
    private Integer year;
    private String productCode;
    private String cosifCode;
    private BigDecimal value;
    private String description;

}
