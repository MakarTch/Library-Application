package com.cognixia.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="book_isbn")
	private Long bookISBN;
	private String bookTitle;
	private String author;
	private int inStock;
	
	public Book(Long bookISBN, String bookTitle, String author, int inStock) {
		super();
		this.bookISBN = bookISBN;
		this.bookTitle = bookTitle;
		this.author = author;
		this.inStock = inStock;
	}

	public Book() {
		super();
	}

	public Long getBookISBN() {
		return bookISBN;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public String getAuthor() {
		return author;
	}

	public int getInStock() {
		return inStock;
	}

	public void setBookISBN(Long bookISBN) {
		this.bookISBN = bookISBN;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setInStock(int inStock) {
		this.inStock = inStock;
	}
	
	public static String tableHeader() {
			String header = "<table><tr><th>Book ISBN</th><th>Title</th><th>Author</th><th>In Stock</th><th>Put on Hold</th></tr>";
			return header;
		}
	
	@Override
	public String toString() {
		if(inStock<=0) {
			return "";
		}
		return "<tr><td>" + bookISBN + "</td><td>" + bookTitle + "</td><td>" + author + "</td><td>" + inStock
				+ "</td><td><input type=\"checkbox\" name = \"book\" value=\"" + bookISBN + "\"style=\"margin:0\" ></td></tr>";
	}
	
	public static String tableFooter() {
		return "</table>";
	}

	public String withoutChecksToString() {
		if(inStock<=0) {
			return "";
		}
		return "<tr><td>" + bookISBN + "</td><td>" + bookTitle + "</td><td>" + author + "</td><td>" + inStock
				+ "</td></tr>";
	}
	
	
	public static String withoutChecksTableHeader() {
		String header = "<table><tr><th>Book ISBN</th><th>Title</th><th>Author</th><th>In Stock</th></tr>";
		return header;
	}

	public static String submitButton() {
		return "<input type=\"submit\" value=\"Put on Hold!\" style=\"float:right\">";
	}
	
	

}
