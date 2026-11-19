package com.gyojincompany.sbb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gyojincompany.sbb.dto.AnswerForm;
import com.gyojincompany.sbb.entity.Question;
import com.gyojincompany.sbb.repository.AnswerRepository;
import com.gyojincompany.sbb.service.AnswerService;
import com.gyojincompany.sbb.service.QuestionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {
	
	private final AnswerService answerService;
	
	private final QuestionService questionService;
	
	@PostMapping("/create/{id}")
	//id->답변이 달릴 부모질문글의 번호
	public String createAnswer(@PathVariable("id") Integer id, 
			@Valid AnswerForm answerForm, BindingResult bindingResult, Model model) {
		
		Question question = questionService.getQuestion(id);
		
		if(bindingResult.hasErrors()) { //답변글 validation 실패 
			model.addAttribute("question", question);
			return "question_detail";
		}
		
		answerService.createAnswer(answerForm.getContent(), question);
		//model에 실어서 보내주기
//		Question question2 = questionService.getQuestion(id);
//		model.addAttribute("question", question2);
		
		return "redirect:/question/detail/"+id; 
	}
	
	
}
