package com.cos.photogramstart.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.service.AuthService;
import com.cos.photogramstart.web.dto.auth.SignupDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class AuthController {
	
	private static final Logger log = LoggerFactory.getLogger(AuthController.class);
	
	private final AuthService authService;

	// 로그인 페이지 열기
	@GetMapping("/auth/signin")
	public String signinForm() {
		return "auth/signin";
	}
	
	// 회원가입 페이지 열기
	@GetMapping("/auth/signup")
	public String signupForm() {
		return "auth/signup";
	}
	
	// 가입 누르면 -> 회원가입 완료 후, 로그인 페이지로 이동
	@PostMapping("/auth/signup")
	public String signup(SignupDto signupDto) { // form 전송 - key=value (x-www-form-urlencoded)
		
		User user = signupDto.toEntity();
		
		User userEntity = authService.회원가입(user);
		System.out.println(userEntity);
		
		return "auth/signin";
	}
}
