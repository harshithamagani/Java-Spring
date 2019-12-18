package com.coding.dojo.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coding.dojo.models.Category;
import com.coding.dojo.models.Product;
import com.coding.dojo.services.CategoryService;
import com.coding.dojo.services.ProductService;

@Controller
public class CategoryController {
	private final CategoryService categoryService;
	private final ProductService productService;
	
	public CategoryController(CategoryService categoryService,ProductService productService) {
		this.categoryService = categoryService;
		this.productService = productService;
	}
	
	
	@RequestMapping("/new/category")
	public String newCategory(@ModelAttribute("category")Category category){
		return "newCategory.jsp";
	}
	
	@RequestMapping("/categories/{id}")
	public String showCategory(@PathVariable("id")Long id,Model model) {
		Category category = categoryService.findCategoryById(id);
		List<Product> products = productService.findAllProducts();
		List<Product> catsProd = category.getProducts();
		products.removeAll(catsProd);
		model.addAttribute("category", category);
		model.addAttribute("allproducts", products);
		System.out.println(products.toString());
		return "showCategory.jsp";
	}
	
	@RequestMapping("/post/new/category")
	public String postCatgory(@ModelAttribute("category")Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/new/category";
		}
		else{
			Category newCategory = categoryService.createCategory(category);
			return "redirect:/categories/"+newCategory.getId();
		}
	}
	
	@RequestMapping(value = "/add/product2/category" , method = RequestMethod.POST)
	public String addProdToCategory(HttpServletRequest request) {
		Long category_id = Long.parseLong(request.getParameter("category"));
		Long product_id = Long.parseLong(request.getParameter("product"));
		Category category= categoryService.findCategoryById(category_id);
		Product prod = productService.findProductById(product_id);
		List<Product> prods = category.getProducts();
		prods.add(prod);
		category.setProducts(prods);
		categoryService.createCategory(category);
		return "redirect:/categories/"+category.getId(); 
	}
	
}
