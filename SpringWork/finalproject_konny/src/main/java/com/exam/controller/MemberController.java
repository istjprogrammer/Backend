package com.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exam.domain.ResisterRequest;
import com.exam.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService memberservice;
	
	@GetMapping("/add")
	public String step1() {
		return "member/step1";
	}
	
	@GetMapping("/step2")
	public String step2(@RequestParam(value="agree", defaultValue="false") boolean agree) {
		if(!agree) {
			return "/member/step1";
		}
		
		return "/member/step2";
	}
	
	@PostMapping("/step3")
	public String step3(@ModelAttribute ResisterRequest dto) throws Exception {
		
		memberservice.resisterMember(dto);
		return null;
	}
	
	@GetMapping("/login")
	public void login() {
		
	}
}
