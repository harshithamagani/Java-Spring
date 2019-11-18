package com.coding.dojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coding.dojo.models.Like;
import com.coding.dojo.repositories.LikeRepository;

@Service
public class LikeService {
	private final LikeRepository likeRepository;
	
	public LikeService(LikeRepository likeRepository) {
		this.likeRepository = likeRepository;
	}
	
	public Like createLike(Like like) {
		return likeRepository.save(like);
	}
	
	public List<Like> findAllLikes(){
		return (List<Like>) likeRepository.findAll();
	}

	
	public Like findLikeById(Long id) {
		Optional<Like> likeOp = likeRepository.findById(id);
		if(likeOp.isPresent()) {
			return likeOp.get();
		} else {
			return null;
		}
	}
}
