package com.cognixia.application.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="on_hold")
public class OnHold {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;
	private int userId;
	private long bookISBN;
	private String transactionTime;
	
	public OnHold(int transactionId, int userId, long bookISBN, String transactionTime) {
		super();
		this.transactionId = transactionId;
		this.userId = userId;
		this.bookISBN = bookISBN;
		this.transactionTime = transactionTime;
	}

	public OnHold() {
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

	@Override
	public String toString() {
		return "OnHold [transactionId=" + transactionId + ", userId=" + userId + ", bookISBN=" + bookISBN
				+ ", transactionTime=" + transactionTime + "]";
	}
	
	
	
	
}
