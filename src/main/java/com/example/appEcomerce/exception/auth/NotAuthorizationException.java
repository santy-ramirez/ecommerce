package com.example.appEcomerce.exception.auth;

public class NotAuthorizationException extends RuntimeException{
    public NotAuthorizationException(String message){
        super(message);
    }
}
