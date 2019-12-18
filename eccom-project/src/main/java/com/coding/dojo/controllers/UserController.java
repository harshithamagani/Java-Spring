package com.coding.dojo.controllers;

import java.util.ArrayList;
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

import com.coding.dojo.models.Category;
import com.coding.dojo.models.Order;
import com.coding.dojo.models.Product;
import com.coding.dojo.models.User;
import com.coding.dojo.services.CategoryService;
import com.coding.dojo.services.OrderService;
import com.coding.dojo.services.ProductService;
import com.coding.dojo.services.UserService;
import com.coding.dojo.validator.UserValidator;

@Controller
public class UserController {
	private final UserService userService;
	private final UserValidator userValidator;
	private final CategoryService categoryService;
	private final ProductService productService;
	private final OrderService orderService;
	
	public UserController(OrderService orderService,UserService userService,UserValidator userValidator,CategoryService categoryService,ProductService productService) {
		this.userService = userService;
		this.userValidator=userValidator;
		this.categoryService=categoryService;
		this.productService=productService;
		this.orderService =orderService;
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
		if(session.getAttribute("user") != null) {
	    	Long user_id = (Long) session.getAttribute("user");
	    	User user = userService.findUserById(user_id);
	    	if(user.getRole().equals("admin")) {
		    	List<Category> categories = categoryService.findAllCategories();
		    	List<Product> products = productService.findAllProducts();
		    	System.out.println(categories.toString());
		    	model.addAttribute("user", user);
		    	model.addAttribute("categories", categories);
		    	model.addAttribute("products", products);
		    	return "homePage.jsp";
	    }
	    	else {
	    		return "redirect:/lotus";
	    	}
    	}
    	else {
    		return "redirect:/admin";
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
		 user.setRole("user");
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
//	    		List<Order> orders = new ArrayList<Order>();
//	   		 	Order order = new Order();
//	   		 	orderService.createOrder(order);
//	   		 	orders.add(order);
//	   		 	user.setOrders(orders);	   		 
	    		session.setAttribute("user", user.getId());
	    		System.out.println("logged in");
	    		if(user.getRole().equals("admin")) {
	    			return "redirect:/home";
	    		}
	    		return "redirect:/lotus";
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
	    
	    @RequestMapping("/admin")
	    public String displayAdminPage(HttpSession session) {
	    	if(session.getAttribute("user") == null) {
	    		return "adminLogin.jsp";
	    	}
	    	else {
	    		return "redirect:/home";
	    	}
	    }
}
