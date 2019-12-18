package com.coding.dojo.services;

import javax.validation.Valid;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.coding.dojo.models.User;
import com.coding.dojo.repositories.RoleRepository;
import com.coding.dojo.repositories.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public UserService(UserRepository userRepository,RoleRepository roleRepository,BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.bCryptPasswordEncoder =  bCryptPasswordEncoder;
	}
    
    public void saveWithUserRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_USER"));
        userRepository.save(user);
    }
     
    public void saveUserWithAdminRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
        userRepository.save(user);
    }    
    
    public User findByEmail(String username) {
        return userRepository.findByEmail(username);
    }

	public boolean checkIfUserInDataBase(@Valid User user) {
		// TODO Auto-generated method stub
		return false;
	}
}
