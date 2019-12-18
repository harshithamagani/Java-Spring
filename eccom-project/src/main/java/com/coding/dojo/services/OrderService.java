package com.coding.dojo.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coding.dojo.models.Order;
import com.coding.dojo.repositories.OrderRepository;

@Service
public class OrderService {
	private final OrderRepository orderRepository;
	
	public OrderService(OrderRepository orderRepository){
		this.orderRepository = orderRepository;
	}
	
	public Order createOrder(Order order) {
		return orderRepository.save(order);
	}
	
	public Order findOrderById(Long id) {
		Optional<Order> orderOp = orderRepository.findById(id);
		if(orderOp.isPresent()) {
			return orderOp.get();
		}
		else {
			return null;
		}
	}

}
