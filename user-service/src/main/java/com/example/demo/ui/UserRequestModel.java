package com.example.demo.ui;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRequestModel {

	@NotBlank(message = "first name can not be blank")
	private String firstName;
	@NotBlank(message = "first name can not be blank")
	private String lastName;
	@Email(message = "not a valid email")
	private String email;
	@NotBlank
	private String password;

}
