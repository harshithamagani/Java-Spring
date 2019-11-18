package com.coding.dojo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.coding.dojo.models.Message;

public interface MessageRepository extends CrudRepository<Message, Long>{

}
