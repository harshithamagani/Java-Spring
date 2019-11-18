package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Language;


public interface LanguageRepository extends CrudRepository<Language,Long> {
	 
	 List <Language>findTop3ByOrderByIdDesc();
}
