package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja, Long>{
	
}
