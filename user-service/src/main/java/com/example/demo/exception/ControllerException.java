package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.ui.UserErrorResponse;

@ControllerAdvice
public class ControllerException {

	@ExceptionHandler
	public ResponseEntity<UserErrorResponse> handleUserNotFoundException(UserNotFoundException e )
	{
		UserErrorResponse response=new UserErrorResponse();
		response.setMessage(e.getMessage());
		response.setStatusCode(HttpStatus.NOT_FOUND.value());
		response.setExceptionTime(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

}
