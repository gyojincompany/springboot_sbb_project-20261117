package com.gyojincompany.sbb.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerForm {
	
	@NotBlank(message = "답변은 필수 입력사항입니다.")
	@Size(min = 5, max = 100, message = "답변은 5자 이상, 100자 이하입니다.") //답변은 최소 5자 이상 100자 이하	
	private String content; //답변 내용

}
