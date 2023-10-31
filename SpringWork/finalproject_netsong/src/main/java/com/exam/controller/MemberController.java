package com.exam.controller;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.WebUtils;

import com.exam.domain.Member;
import com.exam.domain.RegisterRequest;
import com.exam.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/add")
	public String step1() {
		return "member/step1";
	}
	
	@PostMapping("/step2")
	public String step2(@RequestParam(value="agree", defaultValue="false") boolean agree) {
		if(!agree) {
			return "/member/step1"; 
		}
		
		return "/member/step2";
	}
	
	@PostMapping("/step3")
	public String step3(@ModelAttribute RegisterRequest dto) throws Exception {
		memberService.registerMember(dto);
		return "member/step3";
	}
	
	@GetMapping("/login")
	public void login() {
		
	}
	
	@PostMapping("/login")
	public String login(String id, String pwd, HttpServletRequest req){
		String msg = null;
		try {
			msg = URLEncoder.encode("id 또는 password가 일치하지 않습니다.");
			Member member = memberService.selectWithPass(id, pwd);
			
			//HttpSession session = req.getSession();
			//session.setAttribute("id", member.getEmail());
			
			WebUtils.setSessionAttribute(req, "id", member.getName());
		} catch (Exception err) {

			return "redirect:/member/login?msg=" + msg;
		}		
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
		
	}
}
