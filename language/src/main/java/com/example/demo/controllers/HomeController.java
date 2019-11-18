package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.models.Language;
import com.example.demo.services.LanguageService;

@Controller
public class HomeController {
	
	private final LanguageService langService;
	
	HomeController(LanguageService langService){
		this.langService = langService;
	}

	@RequestMapping("/languages")
	public String dashboard(@ModelAttribute("lang")Language lang ,Model model) {
		List<Language> langs = langService.allLanguages();
		model.addAttribute("langs", langs);
		String padded = String.format("%07d" , 7);
		System.out.println("padded"+padded);
		return "index.jsp";
	}
	
	@RequestMapping(value="/languages/post",method=RequestMethod.POST)
	public String createLang(@Valid @ModelAttribute("lang") Language lang, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/languages";
		}
		langService.created(lang);
		return "redirect:/languages";
	}
	
	@RequestMapping("/languages/{id}")
	public String showPage(@PathVariable("id") Long id,Model model) {
		Language lang=langService.findLang(id);
		System.out.println(lang.getName());
		model.addAttribute("lang", lang);
		return "show.jsp";
	}
	
	@RequestMapping("/lanuages/delete/{id}")
	public String delete(@PathVariable("id")Long id) {
		langService.deleteLang(id);
		return "redirect:/languages";
	}
	
	@RequestMapping("/languages/edit/{id}")
	public String edit(@PathVariable("id")Long id,Model model) {
		Language lang=langService.findLang(id);
		model.addAttribute("lang", lang);
		return "edit.jsp";
	}
	
	@RequestMapping("/languages/edit/post")
	public String editPostMethod(@Valid @ModelAttribute("lang")Language lang, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/languages/edit/"+lang.getId();
		}
		else {
			langService.updated(lang);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping("/languages/three")
	public String threeLang() {
		List<Language> listLang = langService.topthree();
		System.out.println(listLang.get(0).getName());
		System.out.println(listLang.get(1).getName());
		System.out.println(listLang.get(2).getName());
		return "redirect:/languages";
	}

}