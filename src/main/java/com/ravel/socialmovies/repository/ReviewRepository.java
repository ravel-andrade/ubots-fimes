package com.ravel.socialmovies.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ravel.socialmovies.domain.Review;



@Repository
public interface ReviewRepository extends MongoRepository<Review, String> {

	List<Review> findByAuthorId(String id);
}