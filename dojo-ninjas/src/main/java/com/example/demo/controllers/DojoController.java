package com.example.demo.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.models.Dojo;
import com.example.demo.models.Ninja;
import com.example.demo.service.DojoService;
import com.example.demo.service.NinjaService;

@Controller
    public class DojoController {
	
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	DojoController(DojoService dojoService,NinjaService ninjaService){
		this.dojoService=dojoService;
		this.ninjaService = ninjaService;
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		System.out.println("*****************");
		List<Dojo> dojos = dojoService.getAllDojos();
		model.addAttribute("dojos", dojos);
		return "index.jsp"; 
	}

	@RequestMapping("/new/dojo")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	
	
	@RequestMapping(value="/post/new/dojo", method = RequestMethod.POST)
	public String postDojo(@ModelAttribute("dojo")Dojo dojo,BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/new/dojo";
		}
		else {
			dojoService.createDojo(dojo);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/dojo/{id}")
	public String showDojoDetails(@PathVariable("id")Long id,Model model){
		Dojo dojo = dojoService.findDojoById(id);
		model.addAttribute("dojo", dojo);
		model.addAttribute("ninjas", dojo.getNinjas());
		return "show.jsp";
	}
	
	@RequestMapping("/new/ninja")
	public String newNinja(@ModelAttribute("ninja")Ninja ninja,Model model) {
		List<Dojo> dojos = dojoService.getAllDojos();
		System.out.println(dojos.toString());
		model.addAttribute("dojos", dojos);
		return "newNinja.jsp";
	}
	
	@RequestMapping(value="/post/new/ninja",method = RequestMethod.POST)
	public String postNinja(@ModelAttribute("ninja")Ninja ninja,BindingResult result,HttpServletRequest request) {
		if(result.hasErrors()) {
			System.out.println("hi error in form");
			return "redirect:/new/ninja";
		}
		else {
			if(request.getParameter("dojo") != null) {
				Long id =  Long.parseLong(request.getParameter("dojo"));
				Dojo dojo = dojoService.findDojoById(id);
				ninja.setDojo(dojo);
				ninjaService.createNinja(ninja);
				System.out.println("hi created");
				return "redirect:/";
			}
			else {
				System.out.println("hi dojo null");
				return "redirect:/new/ninja";
			}
		}
	}
}
