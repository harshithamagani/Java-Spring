package com.coding.dojo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.coding.dojo.models.User;

public interface UserRepository extends CrudRepository<User, Long>{
 public User findByEmail(String email);
}
