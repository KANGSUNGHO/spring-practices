package com.bit2020.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @RequsetMapping
 * 메소드 단독 매핑 
 *
 */

@Controller
public class BoardController {
	
	@ResponseBody
	@RequestMapping("/board/write") // http://127.0.0.1:8080/hellospring03/board/write
	public String write() {
		return "BoardController:write";
	}
	
	@ResponseBody
	@RequestMapping("/board/view/{no}") // http://127.0.0.1:8080/hellospring03/board/view/10
	public String view(@PathVariable("no") Long no) {
		return "BoardController:view " + no;
	}
}

