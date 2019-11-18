package com.example.demo;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/index", method=RequestMethod.POST)
	public String postSurvey(HttpSession session,Model model,@RequestParam(value="name")String name,@RequestParam(value="location") String location,@RequestParam(value="lang")String lang,@RequestParam(value="comment",required=false)String comment) {
		model.addAttribute("name", name);
		model.addAttribute("location", location);
		model.addAttribute("lang", lang);
		if(comment!=null) {
			model.addAttribute("comment", comment);
		}
		session.setAttribute("user", model);
		return "redirect:/display";
	}
	
	@RequestMapping("/display")
	public String display(HttpSession session,Model model) {
		if(session.getAttribute("user") != null) {
			model.addAttribute("user", session.getAttribute("user"));
//			model.addAttribute("location", session.getAttribute("location"));
//			model.addAttribute("lang", session.getAttribute("lang"));
//			if(session.getAttribute("comment")!=null) {
//				model.addAttribute("comment", session.getAttribute("comment"));
//			}
//			session.setAttribute("user", model);
			return "showPage.jsp";
		}
		else {
			return "redirect:/";
		}
	}
	
}