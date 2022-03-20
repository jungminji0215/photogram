package com.cos.photogramstart.domain.user;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

// JPA - Java Persistence API) - 자바로 데이터를 영구적으로 저장할 수 있는 API를 제공

// Model

@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 번호 증가 전략이 데이터베이스를 따라간다.
	private int id;
	
	private String username;
	
	private String password;
	
	private String name;
	
	private String website;
	
	// 자기소개
	private String bio;
	
	private String email;
	
	private String phone;
	
	private String gender;
	
	// 사진
	private String profileImageUrl; 
	
	// 권한
	private String role; 
	
	private LocalDateTime createDate;
	
	// DB에 자동으로 들어가게 할 것
	@PrePersist // DB에 해당 테이블의 insert 연산을 실행할 때 같이 실행
	public void createDate() {
		this.createDate = LocalDateTime.now();
	}
}
