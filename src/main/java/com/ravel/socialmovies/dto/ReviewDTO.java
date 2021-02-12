package com.ravel.socialmovies.dto;

import java.io.Serializable;
import java.util.Date;

import com.ravel.socialmovies.domain.Review;


public class ReviewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String text;
	private Date date;
	private AuthorDTO author;
	
	public ReviewDTO() {}

	public ReviewDTO(Review obj) {
		
		this.id = obj.getId();
		this.text = obj.getText();
		this.date = obj.getDate();
		this.author = obj.getAuthor();
	}
	
	
}



