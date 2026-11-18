package com.gyojincompany.sbb.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto {
	
	private Integer id; //기본키 질문글 번호
	private String subject; //질문글 제목
	private String content; //질문글 내용
	private LocalDateTime createDate; //질문글 작성일시
	
	

}
