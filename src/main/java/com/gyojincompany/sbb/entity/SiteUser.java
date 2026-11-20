package com.gyojincompany.sbb.entity;

import com.gyojincompany.sbb.dto.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SiteUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true) //username은 기본키는 아니지만 중복되면 에러
	private String username;
	
	private String password;	
	
	private String email;
	
	@Enumerated(EnumType.STRING) //DB에 저장될 때 숫자들어가지 않고 ADMIN, USER 문자로 저장
	private UserRole role;

}
