package com.coding.dojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coding.dojo.models.Idea;
import com.coding.dojo.repositories.IdeaRepository;

@Service
public class IdeaService {
	
	
	private final IdeaRepository ideaRepository;
	
	public IdeaService(IdeaRepository ideaRepository) {
		this.ideaRepository = ideaRepository;
	}
	
	public Idea createIdea(Idea idea){
		return ideaRepository.save(idea);
	}
	
	public Idea findIdeaByIdea(Long id){
		Optional<Idea> ideaOp =  ideaRepository.findById(id);
		if(ideaOp.isPresent()) {
			return ideaOp.get();
		}
		else {
			return null;
		}
	}
	
	public List<Idea> findAllIdeas(){
		return (List<Idea>) ideaRepository.findAll();
	}
	
	public void deleteIdea(Long id) {
		 ideaRepository.deleteById(id);
	}
}
