package com.coding.dojo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.coding.dojo.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

}
