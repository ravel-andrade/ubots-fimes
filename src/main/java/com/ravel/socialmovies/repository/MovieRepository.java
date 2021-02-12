package com.ravel.socialmovies.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ravel.socialmovies.domain.Movie;
import com.ravel.socialmovies.domain.Review;


@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

	List<Movie> findByReviewsNotIn(List<Review> reviews);
	
}