package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MovementResponseDTO {

    private String month;
    private String year;
    private String productCode;
    private String productDescription;
    private String releaseNumber;
    private String description;
    private String value;

}
