package com.exam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.exam.domain.Board;

@Controller
@RequestMapping("/board")
public class BoardController {
	@GetMapping("/list")
	public String list() {
		return "board/list";
	}
	
	@GetMapping("/write")
	public String write() {
		return "board/write";
	}
	
	@PostMapping("/write")
	public String write(@ModelAttribute Board board) {
		return "null";
	}
	
	@GetMapping("/read")
	public String read() {
		return null;
	}
	
	@GetMapping("/delete")
	public String delete() {
		return null;
	}
}
