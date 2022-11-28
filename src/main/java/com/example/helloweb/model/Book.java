package com.example.helloweb.model;

public class Book {
	private long id;
	private String title;
	private int numPages;
	private double cost;
	private String author;
	
	public Book(long id, String title, int numPages, double cost, String author) {
		
		this.id = id;
		this.title = title;
		this.numPages = numPages;
		this.cost = cost;
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public int getNumPages() {
		return numPages;
	}

	public double getCost() {
		return cost;
	}

	public String getAuthor() {
		return author;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
