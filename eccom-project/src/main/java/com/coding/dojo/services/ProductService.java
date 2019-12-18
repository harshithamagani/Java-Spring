package com.coding.dojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coding.dojo.models.Product;
import com.coding.dojo.repositories.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public List<Product> findAllProducts(){
		return (List<Product>) productRepository.findAll();
	}
	
	public Product findProductById(Long id) {
		Optional<Product> prodOp = productRepository.findById(id);
		if(prodOp.isPresent()) {
			return prodOp.get();
		}
		else {
			return null;
		}
	}
	
	public Product createProduct(Product prod) {
		return productRepository.save(prod);
	}
	
	public Product editProduct(Product prod) {
		return productRepository.save(prod);
	}
	
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

}
