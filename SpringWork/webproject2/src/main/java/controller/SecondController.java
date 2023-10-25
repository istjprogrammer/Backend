package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import model.user;

@Controller
public class SecondController {
	@RequestMapping("/first")
	public String firstPage() {
		return "/WEB-INF/views/first.jsp";
	}
	
	@RequestMapping("/second")
	public ModelAndView secondPage(HttpServletRequest req) {
		String p1 = req.getParameter("p1");
		String p2 = req.getParameter("p2");
		
		ModelAndView mv = new ModelAndView("/WEB-INF/views/second.jsp");
		
		mv.addObject("param1", p1);
		mv.addObject("param2", p2);		
		
		return mv;
	}
	
	//@RequestMapping(value="/third", method=RequestMethod.POST)
	@PostMapping("/third")
	public String thridPage(
			String name, 
			int age, 
			double point) {
		System.out.println(name+", " + age + ", " + point);
		return "/WEB-INF/views/third.jsp";
	}
	/*
	@GetMapping("/fourth")
	public String fourthPage(String name, int age, double point, Model model) {
		
		user dto = new user();
		dto.setName(name);
		dto.setAge(age);
		dto.setPoint(point);	
		
		model.addAttribute(dto);
		
		return "/WEB-INF/views/fourth.jsp";
	}*/
	/*
	@GetMapping("/fourth")
	public ModelAndView fourthPage(String name, int age, double point) {
		System.out.println(name);
		user dto = new user();
		dto.setName(name);
		dto.setAge(age);
		dto.setPoint(point);	
		
		ModelAndView mv = new ModelAndView("/WEB-INF/views/fourth.jsp");
		mv.addObject("user",dto);
		return mv;
	}
	*/
	
	@RequestMapping("/fourth")
	public ModelAndView fourthPage(@ModelAttribute user dto,
			@RequestParam String chk) {
		
		ModelAndView mv = new ModelAndView("/WEB-INF/views/fourth.jsp");
		mv.addObject("user",dto);
		return mv;
	}
	
	@RequestMapping("/fifth")
	public ModelAndView fifthPage() {
		List list = new ArrayList();
		
		list.add("순자");
		list.add("영자");
		list.add("정숙");
		list.add("옥순");		
		
		Map map = new HashMap<String, String>();
		map.put("f1", "사과");
		map.put("f2", "복숭아");
		map.put("f3", "메론");
		
		List listDay = new ArrayList<String>();
		listDay.add("월요일");
		listDay.add("화요일");
		listDay.add("수요일");
		
		Map mapDay = new HashMap<String, List>();
		mapDay.put("day", listDay);
		
		ModelAndView mv = new ModelAndView("/WEB-INF/views/fifth.jsp");
		mv.addObject("SOLO", list);
		mv.addAllObjects(map);
		mv.addAllObjects(mapDay);
		
		return mv;
	}
}