package com.example.demo.Exceptions;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;


@ControllerAdvice
public class ExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler(value= {ApiRequestException.class})
	public ResponseEntity<Object> handleException(ApiRequestException e){
		TheException theException = new TheException(
				e.getMessage(),
				HttpStatus.BAD_REQUEST,
				ZonedDateTime.now(ZoneId.of("Z"))
				);
		return new ResponseEntity<Object>(theException,HttpStatus.BAD_REQUEST);
	}

}
