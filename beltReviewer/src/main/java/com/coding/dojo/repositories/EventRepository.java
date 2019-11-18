package com.coding.dojo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.coding.dojo.models.Event;

public interface EventRepository extends CrudRepository<Event, Long>{
	public List<Event> findByState(String state);
}
