package com.example.demo.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.User;
import com.example.demo.services.UserService;
import com.example.demo.validator.UserValidator;

@Controller
public class UserController {
	
	private final UserService userService;
	private final UserValidator userValidator;
	
	public UserController(UserService userService,UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}
	
	@RequestMapping("/registration")
	public String registerForm(@ModelAttribute("user")User user) {
		return "registrationPage.jsp";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "loginPage.jsp";
	}
	
	 @RequestMapping(value="/registration", method=RequestMethod.POST)
	    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
	        // if result has errors, return the registration page (don't worry about validations just now)
		 userValidator.validate(user, result);
		 if(result.hasErrors()) {
			 System.out.println("hi error register");
			 return "registrationPage.jsp";
		 }
		 if(userService.checkIfUserInDataBase(user)) {
			 System.out.println("hi checkIfUserInDataBase");
			 return "loginPage.jsp";
		 }
		 else {
			 userService.registerUser(user);
			 session.setAttribute("user", user.getId());
			 return "redirect:/home";
		 }
	        // else, save the user in the database, save the user id in session, and redirect them to the /home route
	    }
	    
	    @RequestMapping(value="/login", method=RequestMethod.POST)
	    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
	        // if the user is authenticated, save their user id in session
	    	if(userService.authenticateUser(email, password)) {
	    		User user = userService.findByEmail(email);
	    		session.setAttribute("user", user.getId());
	    		System.out.println("logged in");
	    		return "redirect:/home";
	    	} else {
	    		model.addAttribute("error", "Invalid Credentials. Please try again.");
	    		System.out.println("error during login");
	    		return "loginPage.jsp";
	    	}
	        // else, add error messages and return the login page
	    }
	    
	    @RequestMapping("/home")
	    public String home(HttpSession session, Model model) {
	        // get user from session, save them in the model and return the home page
	    	Long user_id = (Long) session.getAttribute("user");
	    	User user = userService.findUserById(user_id);
	    	model.addAttribute("user", user);
	    	return "homePage.jsp";
	    }
	    
	    
	    @RequestMapping("/logout")
	    public String logout(HttpSession session) {
	        // invalidate session
	    	session.invalidate();
	        // redirect to login page
	    	return "redirect:/login";
	    }

}