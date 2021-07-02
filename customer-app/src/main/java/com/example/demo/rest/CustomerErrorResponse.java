package com.example.demo.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CustomerErrorResponse {
	
	private String message;
	private int statusCode;
	private long errorLogTime;

}
