package com.coding.dojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coding.dojo.models.OrderProduct;
import com.coding.dojo.repositories.OrderProductRepository;

@Service
public class OrderProductService {
	private final OrderProductRepository orderProductRepo;
	
	public OrderProductService(OrderProductRepository orderProductRepo) {
		this.orderProductRepo = orderProductRepo;
	}
	
	public OrderProduct createOrderProduct(OrderProduct orderProduct) {
		return orderProductRepo.save(orderProduct);
	}
	
	public List<OrderProduct> findOrderProducts(){
		return (List<OrderProduct>) orderProductRepo.findAll();
	}
	
	public OrderProduct findOrderProductById(Long id) {
		Optional<OrderProduct> orderProductOp=orderProductRepo.findById(id);
		if(orderProductOp.isPresent()) {
			return orderProductOp.get();
		}
		else {
			return null;
		}
	}
}
