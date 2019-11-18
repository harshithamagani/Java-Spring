package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/world")
@RestController
public class HomeController {

	@RequestMapping("")
	//Set required as false to set it as optional
	public String indexRouteMethod(@RequestParam(value="q" , required=false) String searchParam) {
		return " Hello client!How are you doing?"+searchParam;
	}
	
	@RequestMapping(value="/random" , method = RequestMethod.GET)
	public String randomRouteMethod() {
		return "Spring Boot is great! So easy to just respond with Strings!!";
	}
	
	@RequestMapping("/m/{test1}/{test2}/{test3}")
    public String showLesson(@PathVariable("test1") String test1, @PathVariable("test2") String test2, @PathVariable("test3") String test3){
    	return "Track: " + test1 + ", Module: " + test2 + ", Lesson: " + test3;
    }

}