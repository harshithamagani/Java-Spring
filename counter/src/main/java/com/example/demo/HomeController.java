package com.example.demo;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("")
	public String home(HttpSession session){
		if(session.getAttribute("counter") == null) {
			int counter = 0;
			session.setAttribute("counter", counter);
		}
		else {
			System.out.println("here2");
			int counter =(int) session.getAttribute("counter");
			counter = counter + 1;
			session.setAttribute("counter", counter);
		}
		
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String showCounter(HttpSession session, Model model) {
		if(session.getAttribute("counter") != null) {
			model.addAttribute("counter", session.getAttribute("counter"));
		}
		else {
			System.out.println("Hello");
			model.addAttribute("counter", 0);
		}
		return "showCounter.jsp";
	}

	
}
