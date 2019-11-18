package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
	
	//Have an http GET request to 'http://localhost:8080/dojo' display a text that says 'The dojo is awesome!'.
	//Have an http GET request to 'http://localhost:8080/burbank-dojo/' display a text that says 'Burbank Dojo is located in Southern California'.
	//Have an http GET request to 'http://localhost:8080/san-jose/' display a text that says 'SJ dojo is the headquarters'.
	
	@RequestMapping("/{str}")
	public String display(@PathVariable("str") String str){
		if(str.equals("dojo")) {
			return "The dojo is awesome!";
		}
		if(str.equals("burbank-dojo")) {
			return "Burbank Dojo is located in Southern California";
		}
		if(str.equals("san-jose")) {
			return "SJ dojo is the headquarters";
		}
		return "";
	}

}