package com.cognixia.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="borrowed")
public class Borrowed {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;
	private int userId;
	@Column(name="book_isbn")
	private long bookISBN;
	private String transactionTime;
	
	public Borrowed(int transactionId, int userId, long bookISBN, String transactionTime) {
		super();
		this.transactionId = transactionId;
		this.userId = userId;
		this.bookISBN = bookISBN;
		this.transactionTime = transactionTime;
	}

	public Borrowed(int userId, long bookISBN, String transactionTime) {
		super();
		this.userId = userId;
		this.bookISBN = bookISBN;
		this.transactionTime = transactionTime;
	}


	public Borrowed() {
		super();
	}

	public int getTransactionId() {
		return transactionId;
	}

	public int getUserId() {
		return userId;
	}

	public long getBookISBN() {
		return bookISBN;
	}

	public String getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setBookISBN(long bookISBN) {
		this.bookISBN = bookISBN;
	}

	public void setTransactionTime(String transactionTime) {
		this.transactionTime = transactionTime;
	}

	public static String tableHeader() {
		String header = "<table><tr><th>Transaction ID</th><th>User Id</th><th>Book Title</th><th>On Hold Time</th><th>Returned</th></tr>";
		return header;
	}

	public String toString(String bookName) {
		return "<tr><td>" + transactionId + "</td><td>" + userId + "</td><td>" + bookName + "</td><td>" + transactionTime
				+ "</td><td><input type=\"checkbox\" name = \"book\" value=\"" + transactionId + "\" ></td></tr>";
	}

	public static String tableFooter() {
		return "</table>";
}

	public static String withoutChecksTableHeader() {
		String header = "<table><tr><th>Transaction ID</th><th>User Id</th><th>Book Title</th><th>On Hold Time</th></tr>";
		return header;
	}

	public String withoutChecksToString(String bookName) {
		return "<tr><td>" + transactionId + "</td><td>" + userId + "</td><td>" + bookName + "</td><td>" + transactionTime
				+ "</td></tr>";
	}
	
	

}
