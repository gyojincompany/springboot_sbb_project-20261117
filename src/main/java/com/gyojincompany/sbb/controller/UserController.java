package com.gyojincompany.sbb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@GetMapping("/signup")
	public String signup() {
		return "signup_form";
	}
	
	@PostMapping("/signup") 
	public String signup() {
		
	}

}
