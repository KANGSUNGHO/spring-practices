package com.bit2020.hellospring.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
 	@ResponseBody // 메시지 컨버
	@RequestMapping({"","/main","/a/b/c/e/f"})
	public String main() {
		return "MainController:main()";
	}
 	
//	@ResponseBody // 메시지 컨버
//	@RequestMapping("/test")
//	public String test(HttpServletRequest request) throws UnsupportedEncodingException {
//		request.setCharacterEncoding("UTF-8");
//		return "MainController:main()";
//	} // 이렇게 하면 안됨. 
 	
 	@ResponseBody
	@RequestMapping("/test")
	public String test() {
		return "MainController:main()";
	}
}
