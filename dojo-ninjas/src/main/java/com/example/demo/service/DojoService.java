package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Dojo;
import com.example.demo.repositories.DojoRepository;



@Service
public class DojoService {

	private final DojoRepository dojoRepo;
	
	public DojoService(DojoRepository dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	
	public List<Dojo> getAllDojos(){
		List<Dojo> listDojos = (List<Dojo>) dojoRepo.findAll();
		return listDojos;
	}

	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	public Dojo findDojoById(Long id) {
		Optional<Dojo> dojoOp = dojoRepo.findById(id);
		if(dojoOp.isPresent()) {
			return dojoOp.get();
		}
		else {
			return null;
		}
	}
	
	public void deleteDojo(Long id) {
		dojoRepo.deleteById(id);
	}
	
}