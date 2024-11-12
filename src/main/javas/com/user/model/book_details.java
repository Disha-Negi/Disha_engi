package com.user.model;

public class book_details {
	
	private int book_id;
	private String B_name;
	private String Author;
	private String Publisher;
	private String edition;
	public book_details() {
		super();
		// TODO Auto-generated constructor stub
	}
	public book_details(int book_id, String b_name, String author, String publisher, String edition) {
		super();
		this.book_id = book_id;
		B_name = b_name;
		Author = author;
		Publisher = publisher;
		this.edition = edition;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getB_name() {
		return B_name;
	}
	public void setB_name(String b_name) {
		B_name = b_name;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getPublisher() {
		return Publisher;
	}
	public void setPublisher(String publisher) {
		Publisher = publisher;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	@Override
	public String toString() {
		return "book_details [book_id=" + book_id + ", B_name=" + B_name + ", Author=" + Author + ", Publisher="
				+ Publisher + ", edition=" + edition + "]";
	}
	
		
		
	}
	
	

}
