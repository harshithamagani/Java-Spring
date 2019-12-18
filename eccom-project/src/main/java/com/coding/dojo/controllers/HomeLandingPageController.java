package com.coding.dojo.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeLandingPageController {
	
	@RequestMapping("/lotus")
	public String displayHomeLandingPage(HttpSession session,Model model) {
		boolean userInSession;
		if(session.getAttribute("user")==null) {
			userInSession = false;
		}
		else {
			userInSession = true;
		}
		model.addAttribute("userInSession", userInSession);
		return "homeLandingPage.jsp";
	}
	
	

}
