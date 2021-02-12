package com.ravel.socialmovies.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.ravel.socialmovies.dto.AuthorDTO;


	@Document(collection="Review")
	public class Review implements Serializable {
		private static final long serialVersionUID = 1L;
		
		@Id
		private String Id;
		private String text;
		private Date date;
		private AuthorDTO author;
		
		public Review() {}
		
		
		public Review(String id, String text, Date date, AuthorDTO author) {
			super();
			Id = id;
			this.text = text;
			this.date = date;
			this.author = author;
		}

		public String getId() {
			return Id;
		}

		public void setId(String id) {
			Id = id;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public AuthorDTO getAuthor() {
			return author;
		}

		public void setAuthor(AuthorDTO author) {
			this.author = author;
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((Id == null) ? 0 : Id.hashCode());
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
			Review other = (Review) obj;
			if (Id == null) {
				if (other.Id != null)
					return false;
			} else if (!Id.equals(other.Id))
				return false;
			return true;
		}

		
	}
	
		
	

	


