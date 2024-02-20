package com.gx.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	@Email(message="invalid email")
	private String email;
	@NotBlank(message="please enter username")
	private String username;
	@NotNull(message="password is required")
	@NotBlank(message="password is required")
	private String password;
	

}
