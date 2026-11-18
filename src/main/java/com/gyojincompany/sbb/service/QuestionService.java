package com.gyojincompany.sbb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyojincompany.sbb.entity.Question;
import com.gyojincompany.sbb.repository.QuestionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionService {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	public List<Question> getQuestionList() { //모든 질문 목록을 반환하는 메소드
		List<Question> questionList = questionRepository.findAll();
		
		
		
		
		return questionList;
	}
	
}
