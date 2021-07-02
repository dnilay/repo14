package com.example.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomerNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -5656944251326909860L;
	private String message;
	
	

}
