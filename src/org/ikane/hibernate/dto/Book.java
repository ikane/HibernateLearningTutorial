package org.ikane.hibernate.dto;

import javax.persistence.Embeddable;

@Embeddable
public class Book {
	
	String title;
	
	String isbn;
	
	String author;
	
	public Book() {}
	
	public Book(String title, String isbn, String author) {
		this.title = title;
		this.isbn = isbn;
		this.author = author;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
}
