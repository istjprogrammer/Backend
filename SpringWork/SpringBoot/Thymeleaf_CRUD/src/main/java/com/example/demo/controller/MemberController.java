package com.example.demo.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemDao;

@Controller
public class MemberController {
	@Autowired
	private MemDao dao;
	
	@GetMapping("list")
	public String list(Model model) {		
		ArrayList<Member> list = (ArrayList<Member>)dao.getDataAll();
		model.addAttribute("members", list);
		return "list";
	}
}