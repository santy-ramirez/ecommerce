package com.example.appEcomerce.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class RequestProductDto extends ProductDto{
    private String name;
    private String category;
    private String Description;
    @JsonIgnore
    private Long user;
}
