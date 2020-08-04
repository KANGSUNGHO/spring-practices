package com.bit2020.emaillist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit2020.emaillist.respository.EmaillistRepository;
import com.bit2020.emaillist.vo.EamillistVo;

@Controller
public class EmaillistController {
 	@Autowired //DI를 해줌. Root Application Context에 있는 EmaillistRepository의 emaillistReository를 web Application Context 에 있는 EmaillistController에 넣어줌.  
	private EmaillistRepository emaillistRepository; //EmaillistRepository 생성, 스프링은 new 안함, 컨테이너가 해줌. 
	
//	@ResponseBody
	@RequestMapping("") // 127.0.0.1:8080/emaillist03/
	public String index(Model model) {
		List<EamillistVo> list = emaillistRepository.findAll();
		model.addAttribute("list", list);
		return "/WEB-INF/views/index.jsp";
	}
	
	@RequestMapping("/form")
	public String form() {
		return "/WEB-INF/views/form.jsp";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(EamillistVo vo) {
		emaillistRepository.insert(vo);
		return "redirect:/";
	}
}
