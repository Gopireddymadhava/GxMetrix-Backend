package com.gx.mapper;

import org.springframework.stereotype.Component;


import com.gx.dto.UserDto;
import com.gx.entites.User;

@Component
public class UserMapper {
	public User toUsersEntity(UserDto dtos) {
		User user=new User();
		user.setEmail(dtos.getEmail());
		user.setUsername(dtos.getUsername());
		user.setPassword(dtos.getPassword());
		return user;
		
	}
	public UserDto toUsersDto(User users) {
		UserDto dto=new UserDto();
		dto.setEmail(users.getEmail());
		dto.setUsername(users.getUsername());
		dto.setPassword(users.getPassword());
		return dto;
	}

}
