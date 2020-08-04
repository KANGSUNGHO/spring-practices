package com.bit2020.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String hello() {
		return "/WEB-INF/views/hello.jsp"; // 127.0.0.1:8080/hellospring03/hello
	}
	
	@RequestMapping("/hello2")
	public String hello2(String name) { // 127.0.0.1:8080/hellospring03/hello2?name=kang
		System.out.println(name);
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/hello3")
	public ModelAndView hello3(String name) { // 127.0.0.1:8080/hellospring03/hello3?name=kang
		ModelAndView mav = new ModelAndView();
		mav.addObject("name",name);
		mav.setViewName("/WEB-INF/views/hello3.jsp");
		return mav;
	}
	
	@RequestMapping("/hello4")
	public String hello4(String name, Model model) { // 127.0.0.1:8080/hellospring03/hello4?name=kang
		model.addAttribute("name", name);
		
		return "/WEB-INF/views/hello4.jsp";
	}
}
