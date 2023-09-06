package com.example.demo.Exception;

import javax.naming.NameNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
	
	 @ExceptionHandler(value = {NameNotFoundException.class})
	    public ResponseEntity<String> handle(final NameNotFoundException exception) {
	        return ResponseEntity.badRequest().body("Username not found");
	    }

}
