package com.example.demo.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.Getter;

@Controller
@RequestMapping("/basic")
public class BasicController {
	@GetMapping("/text-basic")
	public String textBasic(Model model) {
		model.addAttribute("data", "Hello Spring");
		model.addAttribute("data2", "Hello <b>Spring</b>");
		return "basic/text-basic";
	}
	
	@GetMapping("/variable")
	public String variable(Model model) {
		User userA = new User("userA", 10);
		User userB = new User("userB", 20);
		
		List<User> list = new ArrayList<>(Arrays.asList(userA, userB));
		
		Map<String, User> map = new HashMap<>();
		map.put("userA", userA);
		map.put("userB", userB);
		
		model.addAttribute("user", userA);
		model.addAttribute("users", list);
		model.addAttribute("userMap", map);
		
		return "basic/variable";
	}
	
	@Getter
	static class User{
		private String userName;
		private int age;
		
		public User(String userName, int age) {
			this.userName = userName;
			this.age = age;
		}
	}
}