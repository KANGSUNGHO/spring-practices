package com.bit2020.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 
 * @RequestMapping
 * class + method mapping
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping(value="/join", method=RequestMethod.GET) // http://127.0.0.1:8080/hellospring03/user/join
	public String join() {
		return "/WEB-INF/views/join.jsp";
	}
	
//	@RequestMapping(value="/join", method=RequestMethod.POST)
//	public String join(String name, String email) {
//		System.out.println("name: " + name);
//		return "redirect:/";
//	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST) // web.xml에 encoding filter를 설정해줬기 때문에 한글 처리도 가능함
	public String join(UserVo vo) {
		System.out.println(vo);
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping(value="/update")
	public String update(@RequestParam("n") String name) { // 파라미터가 n으로 들어옴. http://127.0.0.1:8080/hellospring03/user/update?n=kang	
		System.out.println("name: " + name);
		return "UserController:update";
	}
	@ResponseBody
	@RequestMapping(value="/update2") //http://127.0.0.1:8080/hellospring03/user/update2, http://127.0.0.1:8080/hellospring03/user/update2?n=kang&a=10
	public String update2(
			@RequestParam(value= "n", required=true, defaultValue="") String name,
			@RequestParam(value= "a", required=true, defaultValue="0") int age) {
		System.out.println("name: " + name + ",age: " + age);
		return "UserController:update";
	}

}
