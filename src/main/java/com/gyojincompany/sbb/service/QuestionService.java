package com.gyojincompany.sbb.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	
	//모든 질문 목록을 반환하는 메소드
	public Page<Question> getQuestionList(int page) { 
		//List<Question> questionList = questionRepository.findAllByOrderByCreateDateDesc(); 
		//질문 등록일의 내림차순으로 정렬하여 글목록이 반환
		
		//정렬 방식 설정(최근글이 위로 올라오도록 createDate의 DESC로 정렬)
		List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));
		
		//페이징 처리된 질문목록 글 받아오기
		Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts)); 
		//(유저가 클릭한 페이지 번호, 한 페이지당 보여질 질문의 갯수)
		
		Page<Question> pageList = questionRepository.findAll(pageable);		
		
		return pageList;
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
