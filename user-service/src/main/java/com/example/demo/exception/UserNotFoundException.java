package com.example.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 210649836231358204L;
	private String message;
	

}
