package com.coding.dojo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coding.dojo.models.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long>{

}
