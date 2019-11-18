package com.coding.dojo.services;

import org.springframework.stereotype.Service;

import com.coding.dojo.models.Message;
import com.coding.dojo.repositories.MessageRepository;

@Service
public class MessageService {
	private final MessageRepository messageRepository;
	
	public MessageService(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}
	
	public Message createMessage(Message message) {
		return messageRepository.save(message);
	}
	
}
