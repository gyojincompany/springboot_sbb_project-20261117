package com.gyojincompany.sbb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyojincompany.sbb.dto.QuestionDto;
import com.gyojincompany.sbb.entity.Question;
import com.gyojincompany.sbb.repository.QuestionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionService {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	public List<QuestionDto> getQuestionList() { //모든 질문 목록을 반환하는 메소드
		List<Question> questionList = questionRepository.findAll();
		
		List<QuestionDto> questionDtoList = new ArrayList<>();
		
		for(Question question : questionList) {
			QuestionDto qDto = new QuestionDto();
			qDto.setId(question.getId());
			qDto.setSubject(question.getSubject());
			qDto.setContent(question.getContent());
			qDto.setCreateDate(question.getCreateDate());
			
			questionDtoList.add(qDto);
		}
		
		
		return questionDtoList;
	}
	
}
