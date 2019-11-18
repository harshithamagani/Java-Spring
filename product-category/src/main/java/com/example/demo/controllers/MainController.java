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

import com.example.demo.models.Category;
import com.example.demo.models.Product;
import com.example.demo.services.CategoryService;
import com.example.demo.services.ProductService;

@Controller
public class MainController {

	private final CategoryService categoryService;
	private final ProductService productService;
	
	public MainController(CategoryService categoryService,ProductService productService) {
		this.categoryService=categoryService;
		this.productService=productService;
	}
	
	@RequestMapping("/new/product")
	public String newProduct(@ModelAttribute("product")Product product){
		return "newProduct.jsp";	
	}
	
	@RequestMapping("/new/category")
	public String newCategory(@ModelAttribute("category")Category category){
		return "newCategory.jsp";
	}
	
	@RequestMapping("/products/{id}")
	public String showProduct(@PathVariable("id")Long id, Model model) {
		Product product = productService.findProdById(id);
		List<Category> categories = categoryService.findAllCategories();
		List<Category> prodsCat = product.getCategories();
		categories.removeAll(prodsCat);
		model.addAttribute("product", product);
		model.addAttribute("categories", categories);
		return "showProduct.jsp";
	}
	
	@RequestMapping("/post/new/product")
	public String postProduct(@ModelAttribute("product")Product product,BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/new/product";
		}
		else {
			Product newProduct = productService.createProduct(product);
			return "redirect:/products/"+newProduct.getId();
		}
	}
	
	@RequestMapping("/categories/{id}")
	public String showCategory(@PathVariable("id")Long id,Model model) {
		Category category = categoryService.findCategory(id);
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
			Category newCategory = categoryService.createNewCategory(category);
			return "redirect:/categories/"+newCategory.getId();
		}
	}
	
	@RequestMapping(value = "/add/product2/category" , method = RequestMethod.POST)
	public String addProdToCategory(HttpServletRequest request) {
		Long category_id = Long.parseLong(request.getParameter("category"));
		Long product_id = Long.parseLong(request.getParameter("product"));
		Category category= categoryService.findCategory(category_id);
		Product prod = productService.findProdById(product_id);
		List<Product> prods = category.getProducts();
		prods.add(prod);
		category.setProducts(prods);
		categoryService.createNewCategory(category);
		return "redirect:/categories/"+category.getId(); 
	}
	
	@RequestMapping(value = "/add/category2/product" , method = RequestMethod.POST)
	public String addCategoryToProduct(HttpServletRequest request) {
		Long prod_id = Long.parseLong(request.getParameter("product"));
		Product prod = productService.findProdById(prod_id);
		Category addCategory = categoryService.findCategory(Long.parseLong(request.getParameter("category")));
		List<Category> categories = prod.getCategories();
		categories.add(addCategory);
		prod.setCategories(categories);
		productService.createProduct(prod);
		return "redirect:/products/"+prod_id;
	}
	
}