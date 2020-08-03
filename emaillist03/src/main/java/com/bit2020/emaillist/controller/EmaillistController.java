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
	@Autowired
	private EmaillistRepository emaillistRepository;
	
//	@ResponseBody
	@RequestMapping("")
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
