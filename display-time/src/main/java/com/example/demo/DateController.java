package com.example.demo;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DateController {
	@RequestMapping("")
	public String home(){
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String displayDate(Model model) {
		String pattern = "EEE, MMMM dd yyyy";
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern(pattern);
		 LocalDateTime myDateObj = LocalDateTime.now();
		 model.addAttribute("date", myDateObj.format(myFormatObj));
		return "showDate.jsp";
	}
	
	@RequestMapping("/time") 
	public String dsiplayTime(Model model){
		String pattern = "hh:mm";
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern(pattern);
		LocalTime myObj = LocalTime.now();
	    System.out.println(myObj.format(myFormatObj));
	    model.addAttribute("time", myObj.format(myFormatObj));
		return "showTime.jsp";
	}
}
