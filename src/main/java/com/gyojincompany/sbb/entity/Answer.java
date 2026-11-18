package com.gyojincompany.sbb.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Answer {
	
	@Id //PK 설정
	@GeneratedValue(strategy = GenerationType.IDENTITY) //자동증가 옵션(AI)
	private Integer id; //int->Integer(null 값을 가질 수 없기때문에)
	//entity 클래스에서는 멤버(필드)를 선언할 때 int, double 같은 기본타입으로 선언하지 않는다
	//->Interger, Double 같은 wrapper 클래스로 선언하여야 한다!
	
	@Column(columnDefinition = "TEXT", nullable = false) //255자 이상의 아주 긴글을 저장할때
	private String content;
	
	private LocalDateTime createDate;
	
	//답변이 달릴 질문(부모)글의 정보가 명시
	@ManyToOne //n:1, 다대일 관계 선언
	private Question question; //답변이 달릴 부모 질문글의 모든 정보가 담긴 질문글 1개 객체가 저장
}
