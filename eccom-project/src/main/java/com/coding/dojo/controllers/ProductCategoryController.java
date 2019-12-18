package com.coding.dojo.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coding.dojo.models.Category;
import com.coding.dojo.models.Product;
import com.coding.dojo.models.User;
import com.coding.dojo.services.CategoryService;
import com.coding.dojo.services.ProductService;
import com.coding.dojo.services.UserService;

@Controller
public class ProductCategoryController {

	private final ProductService productService;
	private final CategoryService categoryService;
	private final UserService userService;
	public ProductCategoryController(ProductService productService,CategoryService categoryService,UserService userService) {
		this.productService=productService;
		this.categoryService = categoryService;
		this.userService = userService;
	}
	
	@RequestMapping("/new/product")
	public String newProduct(@ModelAttribute("product")Product product,HttpSession session){
		if(session.getAttribute("user") != null) {
			Long user_id = (Long) session.getAttribute("user");
			User user = userService.findUserById(user_id);
			if(user.getRole().equals("admin")) {
				return "newProduct.jsp";
			}
			else {
				return "redirect:/lotus";
			}
		}
		else {
			return "redirect:/admin";
		}
	}
	
	
	@RequestMapping("/products/{id}")
	public String showProduct(@PathVariable("id")Long id, Model model,HttpSession session) {
		if(session.getAttribute("user") != null) {
			Long user_id = (Long) session.getAttribute("user");
			User user = userService.findUserById(user_id);
			if(user.getRole().equals("admin")) {
				Product product = productService.findProductById(id);
				model.addAttribute("product", product);
				List<Category> prod_categories = product.getCategories();
				List<Category> categories = categoryService.findAllCategories();
				categories.removeAll(prod_categories);
				model.addAttribute("categories", categories);
				return "showProduct.jsp";
			}
			else {
				return "redirect:/lotus";
			}
		}
		else {
			return "redirect:/admin";
		}
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
	
	
	@RequestMapping(value = "/add/category2/product" , method = RequestMethod.POST)
	public String addCategoryToProduct(HttpServletRequest request) {
		Long prod_id = Long.parseLong(request.getParameter("product"));
		Product prod = productService.findProductById(prod_id);
		Category addCategory = categoryService.findCategoryById(Long.parseLong(request.getParameter("category")));
		List<Category> categories = prod.getCategories();
		categories.add(addCategory);
		prod.setCategories(categories);
		productService.createProduct(prod);
		return "redirect:/products/"+prod_id;
	}
	
	@RequestMapping("/remove/product/{categoryId}/{productId}")
	public String removeProductFromCat(@PathVariable("categoryId")Long categoryId, @PathVariable("productId")Long productId,Model model) {
		Category category = categoryService.findCategoryById(categoryId);
		Product product = productService.findProductById(productId);
		List<Product> catListProd = category.getProducts();
		catListProd.remove(product);
		category.setProducts(catListProd);
		categoryService.createCategory(category);
		return "redirect:/categories/"+category.getId();
	}
	
	@RequestMapping("/remove/category/{productId}/{categoryId}")
	public String removeCateFromProd(@PathVariable("categoryId")Long categoryId, @PathVariable("productId")Long productId,Model model) {
		Category category = categoryService.findCategoryById(categoryId);
		Product product = productService.findProductById(productId);
		List<Category> prodListCat = product.getCategories();
		prodListCat.remove(category);
		product.setCategories(prodListCat);
		productService.createProduct(product);
		return "redirect:/products/"+product.getId();
	}
	
	@RequestMapping("/product/delete/{prodId}")
	public String deleteProduct(@PathVariable("prodId")Long prodId) {
		productService.deleteProduct(prodId);
		return "redirect:/home";
	}
	
	@RequestMapping("/category/delete/{catId}")
	public String deleteCategory(@PathVariable("catId")Long catId) {
		categoryService.deleteCategory(catId);
		return "redirect:/home";
	}
	
	@RequestMapping("/product/edit/{prodId}")
	public String editProduct(@PathVariable("prodId")Long prodId,Model model) {
		Product product = productService.findProductById(prodId);
		model.addAttribute("product", product);
		return "editProduct.jsp";
	}
	
	@RequestMapping(value="/post/edit/product/{id}", method = RequestMethod.POST)
	public String postEditProd(@PathVariable("id")Long prodId,@ModelAttribute("product")Product prod) {
		Product editProduct = productService.findProductById(prodId);
		editProduct.setName(prod.getName());
		editProduct.setImageUrl(prod.getImageUrl());
		editProduct.setPrice(prod.getPrice());
		editProduct.setDescription(prod.getDescription());	
		productService.createProduct(editProduct);
		return "redirect:/products/"+prodId;
	}
	
	
}
