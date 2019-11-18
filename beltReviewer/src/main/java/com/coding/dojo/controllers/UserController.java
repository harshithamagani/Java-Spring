package com.coding.dojo.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.coding.dojo.models.Event;
import com.coding.dojo.models.User;
import com.coding.dojo.services.EventService;
import com.coding.dojo.services.UserService;
import com.coding.dojo.validator.UserValidator;


@Controller
public class UserController {
	
	private final UserService userService;
	private final EventService eventService;
	private final UserValidator userValidator;
	
	public UserController(UserService userService,UserValidator userValidator,EventService eventService) {
		this.userService = userService;
		this.userValidator = userValidator;
		this.eventService = eventService;
	}
	
	@RequestMapping("/")
	public String registerForm(@ModelAttribute("user")User user,HttpSession session) {
		if(session.getAttribute("user") == null) {
			System.out.println(session.getAttribute("user"));
			return "index.jsp";
		}
		else {
			return "redirect:/events";
		}
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
			 return "redirect:/events";
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
	    		return "redirect:/events";
	    	} else {
	    		redirectAttributes.addFlashAttribute("error", "Invalid Credentials. Please try again.");
	    		System.out.println("error during login");
	    		return "redirect:/";
	    	}
	        // else, add error messages and return the login page
	    }
	    
	    @RequestMapping("/events")
	    public String showEvents(HttpSession session, Model model,@ModelAttribute("event")Event event) {
	        // get user from session, save them in the model and return the home page
	    	Long user_id = (Long) session.getAttribute("user");
	    	User user = userService.findUserById(user_id);
	    	model.addAttribute("user", user);
	    	List<Event> userLocationEvnets = getUserLocationEvents(user.getState());
	    	model.addAttribute("userLocationEvnets", userLocationEvnets);
	    	List<Event> notUserLocationEvnets = getAllEventsOtherThanUserLocation(user.getState());
	    	model.addAttribute("notUserLocationEvnets", notUserLocationEvnets);
	    	return "showEvents.jsp";
	    }
	    
	    
	    @RequestMapping("/logout")
	    public String logout(HttpSession session) {
	        // invalidate session
	    	session.invalidate();
	        // redirect to login page
	    	return "redirect:/";
	    }
	    
	    @RequestMapping(value="/post/event", method = RequestMethod.POST)
	    public String postEvent(@Valid @ModelAttribute("event")Event event,BindingResult result,HttpSession session, Model model) {
	        // get user from session, save them in the model and return the home page
	    	if(result.hasErrors()) {
	    		Long user_id = (Long) session.getAttribute("user");
		    	User user = userService.findUserById(user_id);
		    	List sameLocationEvents = getUserLocationEvents(user.getState());
		    	model.addAttribute("user", user);
	    		return "showEvents.jsp";
	    	}
	    	else {
		    	Event newEvent = eventService.createEvent(event);
		    	Long user_id = (Long) session.getAttribute("user");
		    	System.out.println("Here Here"+user_id);
		    	User user = userService.findUserById(user_id);
		    	newEvent.setHost(user);
		    	eventService.updateEvent(newEvent);
		    	return "redirect:/events";
	    	}
	    }
	    
	    List<Event> getUserLocationEvents(String state){
	    	List<Event> sameLocationEvents = eventService.findEventByState(state);
	    	return sameLocationEvents;
	    }
	    
	    List<Event> getAllEventsOtherThanUserLocation(String state){
	    	List<Event> allEvents = eventService.findAllEvents();
	    	List<Event> sameLocationEvents = eventService.findEventByState(state);
	    	allEvents.removeAll(sameLocationEvents);
	    	return allEvents;
	    }
	    
	    
}