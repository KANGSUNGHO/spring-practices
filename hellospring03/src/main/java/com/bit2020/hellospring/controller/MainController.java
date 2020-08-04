package com.bit2020.hellospring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
 	@ResponseBody // ResponseBody가 붙으면 메시지 컨버터, 안붙으면 view resolve
	@RequestMapping({"","/main","/a/b/c/e/f"}) // 멀티로 매핑 
	public String main() {
		return "MainController:main()";
	}
 	
//	@ResponseBody // 메시지 컨버터 
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
