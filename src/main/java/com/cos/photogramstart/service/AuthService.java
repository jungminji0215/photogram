package com.cos.photogramstart.service;

import org.springframework.stereotype.Service;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthService {
	
	private final UserRepository userRepository;
	
	public User 회원가입(User user) {
		User userEntity = userRepository.save(user); // save 한 다음, DB에 저장하고, 응답 받음 
		
		// user - 외부에서 통신을 통해서 받은 데이터를 user 객체에 담은 것
		// userEntity - 데이터베이스에 담은 데이터를 user 객체에 담은 것
		return userEntity;
	}
}
