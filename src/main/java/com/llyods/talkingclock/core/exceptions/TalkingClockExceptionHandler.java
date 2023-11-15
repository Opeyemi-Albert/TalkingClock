package com.llyods.talkingclock.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;

@RestControllerAdvice
public class TalkingClockExceptionHandler {

	@ExceptionHandler(value = { BadRequestException.class })
	public ResponseEntity<ErrorResponseDto> handleBadRequestException(
			BadRequestException ex) {
		ErrorResponseDto error = new ErrorResponseDto();
		error.setMessage(ex.getMessage());
		error.setStatus("FAILED");
		error.setStatusCode(HttpStatus.BAD_REQUEST.value());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = { IllegalArgumentException.class })
	public ResponseEntity<ErrorResponseDto> illegalArgumentExceptionHandler(
			IllegalArgumentException ex) {
		ErrorResponseDto error = new ErrorResponseDto();
		error.setStatus("FAILED");
		error.setStatusCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
