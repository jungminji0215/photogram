package com.cos.photogramstart.web.dto.auth;

import com.cos.photogramstart.domain.user.User;

import lombok.Data;

// 요청 DTO
// DTO - 통신할 때 필요한 데이터를 담아주는 Object (계층 간에 데이터 교환을 위한 객체)

@Data
public class SignupDto {
	private String username;
	private String password;
	private String email;
	private String name;
	
	// dto를 entity로 변경
	public User toEntity() {
		return User.builder()
				.username(username)
				.password(password)
				.email(email)
				.name(name)
				.build();
	}
}
