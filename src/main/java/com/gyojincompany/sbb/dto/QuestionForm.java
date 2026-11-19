package com.gyojincompany.sbb.dto;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionForm {
	
	@NotBlank(message = "제목은 필수 항목입니다.")
	@Size(min=5, message = "제목은 5자 이상만 가능합니다.")
	private String subject;
	
	@NotEmpty(message = "내용은 필수 항목입니다.")
	private String content;

}
