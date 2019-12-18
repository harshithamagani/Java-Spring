package com.coding.dojo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.coding.dojo.models.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{

}
