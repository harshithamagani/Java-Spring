package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Product;
import com.example.demo.repositories.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository productRepo;
	
	public ProductService(ProductRepository productRepo) {
		this.productRepo=productRepo;
	}
	
	public List<Product> findAllProducts(){
		return (List<Product>) productRepo.findAll();
	}
	
	public Product findProdById(Long id) {
		Optional<Product> prodOp=productRepo.findById(id);
		if(prodOp.isPresent()) {
			return prodOp.get();
		}
		else {
			return null;
		}
	}
	
	public Product createProduct(Product prod) {
		return productRepo.save(prod);
	}
}