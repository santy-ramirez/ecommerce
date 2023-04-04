package com.example.appEcomerce.exception;

import com.example.appEcomerce.dto.ResponseExceptionDto;
import com.example.appEcomerce.exception.product.ProductNotFountException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class costumerHandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductNotFountException.class)
    public ResponseEntity<Object> handlerNotFountProduct(RuntimeException ex, WebRequest request){
    ResponseExceptionDto responseExceptionDto = new ResponseExceptionDto();
    responseExceptionDto.setStatus(HttpStatus.NOT_FOUND);
    responseExceptionDto.setMessage(ex.getMessage());
    return new ResponseEntity<>(responseExceptionDto,HttpStatus.NOT_FOUND) ;
    }
}
