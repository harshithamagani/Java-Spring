package com.coding.dojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coding.dojo.models.Event;
import com.coding.dojo.repositories.EventRepository;

@Service
public class EventService {
	
	private final EventRepository eventRepository;
	
	public EventService(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}
	
	public Event createEvent(Event event){
		return eventRepository.save(event);
	}
	
	public Event updateEvent(Event event){
		return eventRepository.save(event);
	}
	
	public Event findEventById(Long id){
		Optional<Event> eventOp =  eventRepository.findById(id);
		if(eventOp.isPresent()) {
			return eventOp.get();
		}
		else {
			return null;
		}
	}
	
	public List<Event> findAllEvents(){
		return (List<Event>) eventRepository.findAll();
	}
	
	public List<Event> findEventByState(String state) {
		return eventRepository.findByState(state);
	}



}
