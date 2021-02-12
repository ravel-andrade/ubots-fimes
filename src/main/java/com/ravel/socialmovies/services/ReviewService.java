package com.ravel.socialmovies.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravel.socialmovies.domain.Review;
import com.ravel.socialmovies.repository.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository repo;
	
	
	
	public List<Review> findAll() {
		return repo.findAll();
	}
	
	public List<Review> findByAuthorId(String id) {
		return repo.findByAuthorId(id);
	}
	
	

}