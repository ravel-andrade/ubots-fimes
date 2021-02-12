package com.ravel.socialmovies.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ravel.socialmovies.domain.Movie;
import com.ravel.socialmovies.domain.Review;
import com.ravel.socialmovies.services.MovieService;
import com.ravel.socialmovies.services.ReviewService;
import com.ravel.socialmovies.services.UserService;

@RestController
@RequestMapping(value = "/movies")
public class MovieResource {

	@Autowired
	private MovieService service;

	@Autowired
	private UserService userService;

	@Autowired
	private ReviewService reviewService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Movie> findById(@PathVariable String id) {
		Movie Movie = service.findById(id);
		return ResponseEntity.ok().body(Movie);
	}

	@RequestMapping(value = "/{userId}/titlesearch", method = RequestMethod.GET)
	public ResponseEntity<List<Movie>> findByCommentsNotContaining(@PathVariable String userId) {
		List<Review> review = reviewService.findByAuthorId(userId);
		List<Movie> list = service.findByReviewsNotIn(review);
		return ResponseEntity.ok().body(list);
	}

}