package com.example.demo.Exceptions;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class TheException {

	private final String message;
	private final HttpStatus httpStatus;
	private final ZonedDateTime time;
}
