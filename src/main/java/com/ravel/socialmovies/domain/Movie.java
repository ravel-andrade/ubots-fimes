package com.ravel.socialmovies.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.ravel.socialmovies.dto.AuthorDTO;

@Document
public class Movie implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private String id;
	private Date date;
	private String title;
	private String body;
	private AuthorDTO author;
	private List<Review> reviews = new ArrayList<>();

	public Movie() {}

	public Movie(String id, Date date, String title, String body, AuthorDTO user) {
		super();
		this.id = id;
		this.date = date;
		this.title = title;
		this.body = body;
		this.author = user;
	}
	
	public Movie(String id, Date date, String title, String body, AuthorDTO user, List<Review> Reviews) {
		super();
		this.id = id;
		this.date = date;
		this.title = title;
		this.body = body;
		this.author = user;
		this.reviews = Reviews;
	}
	
	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}

