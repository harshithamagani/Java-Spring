package com.coding.dojo.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.coding.dojo.models.Idea;
import com.coding.dojo.models.Like;
import com.coding.dojo.models.User;
import com.coding.dojo.services.IdeaService;
import com.coding.dojo.services.LikeService;
import com.coding.dojo.services.UserService;
import com.coding.dojo.validator.UserValidator;

@Controller
public class MainController {

	private final UserService userService;
	private final UserValidator userValidator;
	private final IdeaService ideaService;
	private final LikeService likeService;
	
	public MainController(UserService userService, UserValidator userValidator,IdeaService ideaService,LikeService likeService) {
		this.userService=userService;
		this.userValidator=userValidator;
		this.ideaService =ideaService;
		this.likeService = likeService;
	}
	
	@RequestMapping("/")
	public String registerForm(@ModelAttribute("user")User user,HttpSession session) {
		if(session.getAttribute("user") == null) {
			System.out.println(session.getAttribute("user"));
			return "index.jsp";
		}
		else {
			return "redirect:/home";
		}
	}
	
	 @RequestMapping("/home")
	    public String home(HttpSession session, Model model) {
	        // get user from session, save them in the model and return the home page
	    	Long user_id = (Long) session.getAttribute("user");
	    	User user = userService.findUserById(user_id);
	    	List<Idea> allIdeas = ideaService.findAllIdeas();
	    	System.out.println(allIdeas.toString());
	    	model.addAttribute("allIdeas", allIdeas);
	    	model.addAttribute("user", user);
	    	return "homePage.jsp";
	    }
	
	
	 @RequestMapping(value="/registration", method=RequestMethod.POST)
	    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session,RedirectAttributes redirectAttributes) {
	        // if result has errors, return the registration page (don't worry about validations just now)
		 userValidator.validate(user, result);
		 if(result.hasErrors()) {
			 System.out.println("hi error register");
			 return "index.jsp";
		 }
		 if(userService.checkIfUserInDataBase(user)) {
			 System.out.println("hi checkIfUserInDataBase");
			 redirectAttributes.addFlashAttribute("error", "Registered user..Please login!!");
			 return "redirect:/";
		 }
		 else {
			 userService.registerUser(user);
			 session.setAttribute("user", user.getId());
			 return "redirect:/home";
		 }
	        // else, save the user in the database, save the user id in session, and redirect them to the /home route
	    }
	    
	    @RequestMapping(value="/login", method=RequestMethod.POST)
	    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session,RedirectAttributes redirectAttributes) {
	        // if the user is authenticated, save their user id in session
	    	if(userService.authenticateUser(email, password)) {
	    		User user = userService.findByEmail(email);
	    		session.setAttribute("user", user.getId());
	    		System.out.println("logged in");
	    		return "redirect:/home";
	    	} else {
	    		redirectAttributes.addFlashAttribute("error", "Invalid Credentials. Please try again.");
	    		System.out.println("error during login");
	    		return "redirect:/";
	    	}
	        // else, add error messages and return the login page
	    }
	    
	    
	    @RequestMapping("/logout")
	    public String logout(HttpSession session) {
	        // invalidate session
	    	session.invalidate();
	        // redirect to login page
	    	return "redirect:/";
	    }
	    
	    //-----------------------------**************** Idea request mapping *************---------------------------------------
	    
	    @RequestMapping("/ideas/new")
	    public String createNewIdea(@ModelAttribute("idea")Idea idea) {
	    	return "newIdea.jsp";
	    }
	    
	    @RequestMapping(value="/post/idea",method = RequestMethod.POST)
	    public String postIdea(@Valid @ModelAttribute("idea")Idea idea, BindingResult result, HttpSession session, Model model) {
	    	if(result.hasErrors()) {
	    		return "newIdea.jsp";
	    	}
	    	else {
	    		Long user_id = (Long) session.getAttribute("user");
		    	User user = userService.findUserById(user_id);
	    		Idea newIdea = ideaService.createIdea(idea);
	    		newIdea.setUser(user);
	    		ideaService.createIdea(newIdea);
		    	model.addAttribute("user", user);
	    		return "redirect:/home"; 
	    	}
	    }
	    
	    @RequestMapping("/ideas/{id}")
	    public String showIdea(@PathVariable("id")Long id,Model model) {
	    	Idea idea = ideaService.findIdeaByIdea(id);
	    	model.addAttribute("idea", idea);
	    	return "showIdea.jsp";
	    }
	    
	    @RequestMapping("/ideas/{id}/edit")
	    public String editIdea(@PathVariable("id")Long id, Model model,HttpSession session) {
	    	Long currUser_id = (Long) session.getAttribute("user");
	    	User currUser = userService.findUserById(currUser_id);
	    	Idea idea = ideaService.findIdeaByIdea(id);
	    	model.addAttribute("idea", idea);
	    	if(currUser.getId() != idea.getUser().getId()) {
	    		return "redirect:/home";
	    	}
	    	return "editIdea.jsp";
	    }
	    
	    @RequestMapping(value = "/edit/idea/{id}", method = RequestMethod.POST)
	    	public String postEditIdea(@Valid @ModelAttribute("idea") Idea idea,@PathVariable("id")Long id,BindingResult result) {
	    	if(result.hasErrors()) {
	    		System.out.println("Here");
	    		return "editIdea.jsp";
	    	}
	    	else {
		    		Idea editIdea = ideaService.findIdeaByIdea(id); 
		    		editIdea.setContent(idea.getContent());
		    		ideaService.createIdea(editIdea);
		    		return "redirect:/home";
	    		}
	    }
	    
	    @RequestMapping(value = "/liked/{id}")
	    public String newLike(@PathVariable("id")Long id,HttpSession session) {
	    	Idea idea = ideaService.findIdeaByIdea(id);
	    	Long user_id = (Long) session.getAttribute("user");
	    	User user = userService.findUserById(user_id);
	    	Like newLike = new Like(true);
	    	newLike.setIdea(idea);
	    	newLike.setUser(user);
	    	likeService.createLike(newLike);
	    	return "redirect:/home";
	    }
	    
	    @RequestMapping("/delete/idea/{id}")
	    public String deleteIdea(@PathVariable("id")Long id) {
	    	ideaService.deleteIdea(id);
	    	return "redirect:/home";
	    }
}