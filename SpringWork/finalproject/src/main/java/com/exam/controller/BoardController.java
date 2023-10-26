package com.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/board")
public class BoardController {
	@GetMapping("/list")
	public String list() {
		return "/WEB-INF/views/board/list.jsp";
	}

	@GetMapping("/write")
	public String write() {
		return "/WEB-INF/views/board/write.jsp";
	}

	@GetMapping("/read")
	public String read() {
		return "/WEB-INF/views/board/read.jsp";
	}

	@GetMapping("/delete")
	public String delete() {
		return "/WEB-INF/views/board/delete.jsp";
	}
}
