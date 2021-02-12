package com.ravel.socialmovies.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravel.socialmovies.domain.Movie;
import com.ravel.socialmovies.domain.Review;
import com.ravel.socialmovies.repository.MovieRepository;
import com.ravel.socialmovies.services.exeption.ObjectNotFoundException;


@Service
public class MovieService {

	@Autowired
	private MovieRepository repo;
	
	public Movie findById(String id) {
		Optional<Movie> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Movie> findByReviewsNotIn(List<Review> review) {
		return repo.findByReviewsNotIn(review);
	}
	
	public List<Review> getReviewsFromPosts(List<Movie> movies){
		List<Review> reviews = new ArrayList<>();
		for (Movie movie : movies) {
			reviews.addAll(movie.getReviews());
			}
		return reviews;
	}

	
	
}