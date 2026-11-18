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
public class AnswerDto {
	
	private Integer id; //기본키 답변글 번호	
	private String content; //답변글 내용
	private LocalDateTime createDate; //답변글 작성일시
	private Integer question_id; //부모질문글 번호
	
}
