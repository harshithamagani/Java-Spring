package com.coding.dojo.controllers;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coding.dojo.models.License;
import com.coding.dojo.models.Person;
import com.coding.dojo.services.DLService;

@Controller
public class HomeController {
	
	private final DLService dlService;
	
	public HomeController(DLService dlService) {
		this.dlService=dlService;
	}
	
	@RequestMapping("/")
	public String home(Model model) {
		List<License> licenses = dlService.getAllLicenses();
		System.out.println(licenses.toString());
		model.addAttribute("licenses", licenses);
		return "index.jsp";
	}
	
	@RequestMapping("/persons/new")
	public String newPerson(@ModelAttribute("person")Person person) {
		return "newPersonForm.jsp";
	}
	
	@RequestMapping("/person/license/new")
	public String newLicense(Model model,@ModelAttribute("license")License license) {
		List<Person> persons = dlService.getAllPersons();
		System.out.println(persons.toString());
		model.addAttribute("persons", persons);
		return "newLicense.jsp";
	}
	
	@RequestMapping("license/new/post")
	public String postLicense(@ModelAttribute("license") License license,HttpServletRequest request) {
		if(request.getParameter("person")!=null) {
			Long person_id = Long.parseLong(request.getParameter("person"));
			Person person=dlService.findPerson(person_id);
			license.setPerson(person);
			license.setNumber(dlService.getLicenseNumber());
			dlService.createLicense(license);
		}
		return "redirect:/";
	}
	
	@RequestMapping(value="/persons/post/new",method = RequestMethod.POST)
	public String postPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/persons/new";
		}
		else {
			dlService.createPerson(person);
			return "redirect:/";
		}
	}
	
}
