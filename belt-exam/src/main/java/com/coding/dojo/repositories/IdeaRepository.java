package com.coding.dojo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.coding.dojo.models.Idea;

public interface IdeaRepository extends CrudRepository<Idea, Long>{

}
