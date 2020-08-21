package com.cognixia.application.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String userPassword;
	private String lastName;
	private String firstName;
	private String email;
	private String phoneNumber;
	
	public User(int userId, String userPassword, String lastName, String firstName, String email, String phoneNumber) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	public User() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userPassword=" + userPassword + ", lastName=" + lastName + ", firstName="
				+ firstName + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
	}

	public static String nonUserHeaderString() {
		//about us, location, catalog, create and account, log in
		String headerString = "<img src=\"libraryimage.jpg\" alt=\"checkin_pic\" width=\"98%\" style=\"margin-left:auto; margin-right:auto; display:block\">"
				+ "<ul><li><a href= \"/\">Home</a></li>"
				+ "<li><a href=\"/aboutus.jsp\">About Us</a></li>"
				+ "<li><a href=\"/location.jsp\">Location</a></li>"
				+ "<li><a href=\"/catalog\">Catalog</a></li>"
				+ "<li style=\"float:right\"><a href=\"/createaccount.jsp\">Create an account</a></li>"
				+ "<li style=\"float:right\"><a href=\"/login.jsp\">Log in</a></li></ul>";
		return headerString;
	}
	public static String headerString() {
		//about us, location, catalog, log out, and gotta make an account info later on
		String headerString = "<img src=\"libraryimage.jpg\" alt=\"checkin_pic\" width=\"98%\" style=\"margin-left:auto; margin-right:auto; display:block\">"
				+ "<ul><li><a href= \"/\">Home</a></li>"
				+ "<li><a href=\"/aboutus.jsp\">About Us</a></li>"
				+ "<li><a href=\"/location.jsp\">Location</a></li>"
				+ "<li><a href=\"/catalog\">Catalog</a></li>"
				+ "<li><a href = \"userinfo\">User Info</a></li>"
				+ "<li style=\"float:right\"><a href=\"/logout\">Log out</a></li></ul>";
		return headerString;
	}
	
	
}
