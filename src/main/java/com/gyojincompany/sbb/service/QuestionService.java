package com.gyojincompany.sbb.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
	//특정 질문글 번호의 레코드를 가져오는 메소드
	public Question getQuestion(Integer id) {
		 Optional<Question> op = questionRepository.findById(id);
		 
		 if(op.isPresent()) { //참이면 가져올 질문글이 존재
			 return op.get();
		 } else { //거짓이면 가져올 질문글이 존재하지 않음
			 return null;
		 }
	}
	
	//질문글을 등록하는(DB에 저장하는) 메소드
	public void createQuestion(String subject, String content) {
		
		Question question = new Question();
		question.setSubject(subject);
		question.setContent(content);
		question.setCreateDate(LocalDateTime.now());
		
		questionRepository.save(question);
	}
	
	
}
