package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Ninja;
import com.example.demo.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	private final NinjaRepository ninjaRepo;
	
	public NinjaService(NinjaRepository ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}
	
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	public Ninja findNinjaById(Long id) {
		Optional<Ninja> ninjaOp =  ninjaRepo.findById(id);
		if(ninjaOp.isPresent()) {
			return ninjaOp.get();
		}
		else {
			return null;
		}
	}
	
	public void deleteNinjaById(Long id) {
		 ninjaRepo.deleteById(id);
	}
}
