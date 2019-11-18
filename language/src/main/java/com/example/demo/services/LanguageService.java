package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Language;

import org.springframework.stereotype.Service;

import com.example.demo.repositories.LanguageRepository;

@Service
public class LanguageService {

	private final LanguageRepository langRepo;
	
	public LanguageService(LanguageRepository langRepo) {
		this.langRepo = langRepo;
	}
	
	public List<Language> allLanguages(){
		return (List<Language>) langRepo.findAll();
	}
	
	public Language findLang(Long id) {
		Optional<Language> lang= langRepo.findById(id);
		if(lang.isPresent()) {
			return lang.get();
		}
		else {
			return null;
		}
	}
	
	public Language created(Language lang) {
		return langRepo.save(lang);
	}
	
	public Language updated(Language lang) {
		return langRepo.save(lang);
	}
	
	public void deleteLang(Long id) {
		langRepo.deleteById(id);
	}
	
	public List<Language> topthree(){
		return langRepo.findTop3ByOrderByIdDesc();
	}
	
}