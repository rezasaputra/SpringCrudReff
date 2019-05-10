package com.latihanhr5.latihan5.Exception;

import com.latihanhr5.latihan5.Model.ResponseMessage;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseMessage handleNotFoundException(CustomException ex){
        ResponseMessage message;
        message= new ResponseMessage(ex.getMessage());
        return message;
    }
}
