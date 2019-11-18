package com.coding.dojo.services;

import java.util.Optional;


import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.coding.dojo.models.User;
import com.coding.dojo.repositories.UserRepository;

@Service
public class UserService {

private final UserRepository userRepo;
	
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	public User registerUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return userRepo.save(user);
	}
	
	public User findByEmail(String email){
		return userRepo.findByEmail(email);
	}
	
	public User findUserById(Long id) {
		Optional<User> userOp = userRepo.findById(id);
		if(userOp.isPresent()) {
			return userOp.get();
		} else {
			return null;
		}
	}
	
	public boolean authenticateUser(String email,String password) {
		User user = userRepo.findByEmail(email);
		if(user == null) {
			return false;
		}
		else {
			if(BCrypt.checkpw(password, user.getPassword())) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	public boolean checkIfUserInDataBase(User user) {
		if(findByEmail(user.getEmail()) != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
