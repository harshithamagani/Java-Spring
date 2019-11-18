package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	
	@RequestMapping("")
	public String home() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/index" , method=RequestMethod.POST)
	public String showResult(@RequestParam(value="code")String code,RedirectAttributes r) {
		if(!code.equals("code")) {
			r.addFlashAttribute("error", "You must train harder!");
			return "redirect:/";
		}
		else {
			return "showPage.jsp";
		}
	}
	

}
