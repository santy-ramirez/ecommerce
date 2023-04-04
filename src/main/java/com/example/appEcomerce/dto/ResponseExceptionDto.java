package com.example.appEcomerce.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ResponseExceptionDto {
   private HttpStatus status ;
   private String message;
}
