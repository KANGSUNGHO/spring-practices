package com.bit2020.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 
 * @RequestMapping
 * class 단독 매핑 
 *
 */
@Controller
@RequestMapping("/guestbook/*")
public class GuestbookController {
	
	@ResponseBody // 디버깅과 브라우저에 매핑이 잘되는지 확인하려고 
	@RequestMapping // http://127.0.0.1:8080/hellospring03/guestbook/list
	public String list() { 
		return "GuestbookController:list";
	}
	
	@ResponseBody
	@RequestMapping // http://127.0.0.1:8080/hellospring03/guestbook/delete
	public String delete() {
		return "GuestbookController:delete";
	}
}
