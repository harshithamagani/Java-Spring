package com.coding.dojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coding.dojo.models.Category;
import com.coding.dojo.repositories.CategoryRepository;

@Service
public class CategoryService {
	private final CategoryRepository categoryRepository;
	
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public List<Category> findAllCategories(){
		return (List<Category>) categoryRepository.findAll();
	}
	
	public Category findCategoryById(Long id) {
		Optional<Category> catOp = categoryRepository.findById(id);
		if(catOp.isPresent()) {
			return catOp.get();
		}
		else {
			return null;
		}
	}
	
	public Category createCategory(Category cat) {
		return categoryRepository.save(cat);
	}
	
	public Category editCategory(Category cat) {
		return categoryRepository.save(cat);
	}

	public void deleteCategory(Long catId) {
		categoryRepository.deleteById(catId);
	}
}
