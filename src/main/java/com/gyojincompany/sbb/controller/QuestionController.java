package com.gyojincompany.sbb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gyojincompany.sbb.entity.Question;
import com.gyojincompany.sbb.repository.QuestionRepository;

@Controller
public class QuestionController {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@GetMapping("/question/list") //모든 질문 목록 요청
	public String list(Model model) {
		
		//모든 질문 리스트 가져오기
		List<Question> questionList = questionRepository.findAll();
		
		//model 객체에 질문리스트 List 객체 전송해주기
		model.addAttribute("questionList", questionList);
		
		return "question_list"; //.html은 쓰지 않음
	}
	
	@GetMapping("/test")
	public String test(Model model) {
		
		model.addAttribute("name", "홍길동");
		model.addAttribute("age", 25);
		model.addAttribute("loginId", "tiger");
		
		ArrayList<String> strs = new ArrayList<>();
		strs.add("이순신");
		strs.add("김유신");
		strs.add("강감찬");
		
		model.addAttribute("strs", strs);
		
		return "test";
	}
}
