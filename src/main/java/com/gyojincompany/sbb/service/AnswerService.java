package com.gyojincompany.sbb.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyojincompany.sbb.entity.Answer;
import com.gyojincompany.sbb.entity.Question;
import com.gyojincompany.sbb.repository.AnswerRepository;

@Service
public class AnswerService {
	
	@Autowired
	private AnswerRepository answerRepository;
	
	//답변 등록 메소드
	public void createAnswer(String content, Question question) {
		
		//답변 저장->save(entity)		
		Answer answer = new Answer();
		answer.setContent(content); //답변의 내용 등록
		answer.setCreateDate(LocalDateTime.now()); //현재 시간 등록
		answer.setQuestion(question); //부모질문글 엔티티 객체 등록
		
		answerRepository.save(answer);
	}
}
