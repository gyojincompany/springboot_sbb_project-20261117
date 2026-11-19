package com.gyojincompany.sbb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gyojincompany.sbb.dto.QuestionDto;
import com.gyojincompany.sbb.dto.QuestionForm;
import com.gyojincompany.sbb.entity.Question;
import com.gyojincompany.sbb.repository.QuestionRepository;
import com.gyojincompany.sbb.service.QuestionService;

import jakarta.validation.Valid;

@RequestMapping("/question")
@Controller
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/") //root 요청->index.html
	public String root() {
		return "index";
	}
	
	@GetMapping("/list") //모든 질문 목록 요청
	public String list(Model model) {
		
		//모든 질문 리스트 가져오기
		List<QuestionDto> questionList = questionService.getQuestionList();
		
		//model 객체에 질문리스트 List 객체 전송해주기
		model.addAttribute("questionList", questionList);
		
		return "question_list"; //.html은 쓰지 않음
	}
	
	@GetMapping("/detail/{id}")
	//유저가 클릭한 질문글 번호가 들어올 자리에 {변수이름}을 선언
	public String detail(@PathVariable("id") Integer id, Model model) {
		
		//Service에 유저가 클릭한 글의 번호에 해당하는 엔티티를 가져오는 호출
		Question question = questionService.getQuestion(id);
		
		if(question != null) { //해당 글이 존재함			
			model.addAttribute("question", question);			
		} else { //해당 글이 존재하지 않음
			model.addAttribute("errMsg", "선택하신 글이 존재하지 않습니다.");
		}
		
		return "question_detail";
	}
	
	@GetMapping("/create") // /question/create -> 질문등록 폼 페이지를 보여달라는 요청
	public String questionCreate() {
		return "question_form";
	}
	
	@PostMapping("/create") //요청의 이름은 같으나 get, post 방식이 다르므로 같은 요청이름으로 생성 가능
	public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) { //참->에러가 발생, 유효성체크에서 에러가 발생
			return "question_form";
		}
		
		// Service 에서 db에 질문을 저장하는 메소드를 호출
		questionService.createQuestion(questionForm.getSubject(), questionForm.getContent());
		
		return "redirect:/question/list";
		
	}
	
	
}
