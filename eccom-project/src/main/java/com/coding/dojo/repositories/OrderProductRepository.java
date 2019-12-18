package com.coding.dojo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coding.dojo.models.OrderProduct;

@Repository
public interface OrderProductRepository extends CrudRepository<OrderProduct, Long>{
	
	
}
