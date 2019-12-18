package com.coding.dojo.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coding.dojo.models.Category;
import com.coding.dojo.models.Product;
import com.coding.dojo.services.CategoryService;
import com.coding.dojo.services.ProductService;

@Controller
@RequestMapping("/lotus")
public class PLPController {
	
	private final ProductService productService;
	private final CategoryService categoryService;
	
	public PLPController(ProductService productService,CategoryService categoryService) {
		this.productService=productService;
		this.categoryService = categoryService;
	}
	
	@RequestMapping("/products")
	public String displayPLP(Model model,HttpSession session) {
		List<Product> products = productService.findAllProducts();
		List<Category> categories = categoryService.findAllCategories();
		model.addAttribute("products", products);
		model.addAttribute("categories", categories);
		boolean userInSession;
		if(session.getAttribute("user")==null) {
			userInSession = false;
		}
		else {
			userInSession = true;
		}
		model.addAttribute("userInSession", userInSession);
		return "productListingPage.jsp";
	}
	
	@RequestMapping("/category/{id}/products")
	public String displayCategoryPLP(Model model,@PathVariable("id")Long id) {
		Category category = categoryService.findCategoryById(id);
		List<Product> products = category.getProducts();
		model.addAttribute("products", products);
		return "productListingPage.jsp";
	}
	
	//catProdListPage.jsp
	@RequestMapping("/category/products/{id}")
	public String displayCatPLP(Model model,@PathVariable("id")Long id,HttpSession session) {
		Category category = categoryService.findCategoryById(id);
		List<Category> categories = categoryService.findAllCategories();
		model.addAttribute("categories", categories);
		List<Product> products = category.getProducts();
		model.addAttribute("products", products);
		boolean userInSession;
		if(session.getAttribute("user")==null) {
			userInSession = false;
		}
		else {
			userInSession = true;
		}
		model.addAttribute("userInSession", userInSession);
		return "productListingPage.jsp";
	}
	

}
