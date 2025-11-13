package com.app.example;

import java.util.Date;
import java.util.List;

public class Book {
	private String title;
	private List<Author> authors;  //Has a relationship
	private int id;
	private Genre genre;
	private Edition edition;
	private float price;
	private Date publishedDate;
	//have to avoid these type of constructors
	//called anti pattern
	//bad coding practice
	//because of multiple arguments
	public Book(int id,String title, List<Author> authors,Genre genre,Edition edition,float price,Date publishedDate) {
		this.title = title;
		this.authors = authors;
		this.id = id;
		this.genre = genre;
		this.edition=edition;
		this.price=price;
		this.publishedDate=publishedDate;
	}
	public String getTitle() {
		return title;
	}
	public List<Author> getAuthors() {
		return authors;
	}
	public int getId() {
		return id;
	}
	public Genre getGenre() {
		return genre;
	}
	public Edition getEdition() {
		return edition;
	}
	public float getPrice() {
		return price;
	}
	public Date getPublishedDate() {
		return publishedDate;
	}
	@Override
	public String toString(){
		return "Book [title=" + title + ", authors=" + authors + ", id=" + id + ", genre=" + genre + ", edition="
				+ edition + ", price=" + price + ", publishedDate=" + publishedDate + "]";
	}
}
