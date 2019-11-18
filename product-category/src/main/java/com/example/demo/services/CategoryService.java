package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Category;
import com.example.demo.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	private final CategoryRepository categoryRepo;
	
	public CategoryService(CategoryRepository categoryRepo) {
		this.categoryRepo=categoryRepo;
	}
	public Category createNewCategory(Category category){
		return categoryRepo.save(category);
	}
	
	public List<Category> findAllCategories(){
		return (List<Category>) categoryRepo.findAll();
	}
	
	public Category findCategory(Long id) {
		Optional<Category> catOp =  categoryRepo.findById(id);
		if(catOp.isPresent()) {
			return catOp.get();
		} else {
			return null;
		}
	}
}
