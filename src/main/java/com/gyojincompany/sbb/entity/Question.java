package com.gyojincompany.sbb.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Question {
	
	@Id //PK 설정
	@GeneratedValue(strategy = GenerationType.IDENTITY) //자동증가 옵션(AI)
	private Integer id; //int->Integer(null 값을 가질 수 없기때문에)
	//entity 클래스에서는 멤버(필드)를 선언할 때 int, double 같은 기본타입으로 선언하지 않는다
	//->Interger, Double 같은 wrapper 클래스로 선언하여야 한다!
	
	@Column(length = 200, nullable = false)
	private String subject;
	
	@Column(columnDefinition = "TEXT", nullable = false) //255자 이상의 아주 긴글을 저장할때
	private String content;
	
	//@CreatedDate //자동으로 레코드 생성시 현재날짜시간이 삽입
	private LocalDateTime createDate;
	
	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE) //1:n, 일대다 관계 선언
	//cascade = CascadeType.REMOVE->질문글이 삭제되면 질문글에 달린 답변들도 같이 DB에서 삭제되는 옵션
	//mappedBy = "question"
	private List<Answer> answerList; 
	//질문 1개에 여러개의 답변이 달릴 수 있다
	//->질문 1개 객체에 여러개의 답변이 저장될수 있는 자리를 마련 
}
