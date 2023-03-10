package com.email_app.model;

import java.time.LocalDate;
import lombok.Data;

@Data
public class UserUpdateDTO {

	private String firstName;
	private String lastName;
	private String mobileNumber;
	private LocalDate dateOfBirth;
	private String password;
}
