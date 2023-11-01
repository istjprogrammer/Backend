package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class  HelloController {
	@GetMapping("/")
	@ResponseBody
	public String hello() {
		return "Hello Spring Boot";
	}
}
