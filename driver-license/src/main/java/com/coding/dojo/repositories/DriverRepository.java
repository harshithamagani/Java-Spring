package com.coding.dojo.repositories;


import org.springframework.data.repository.CrudRepository;

import com.coding.dojo.models.Person;

public interface DriverRepository extends CrudRepository<Person, Long>{
	
}