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
		return "<table><tr><th>User ID</th><th>Password</th><th>Last Name</th><th>First Name</th><th>Email</th><th>Phone Number</th></tr>"
				+ "<tr><td>" + userId + "</td><td>" + userPassword + "</td><td>" + lastName + "</td><td>" + firstName +"</td><td>" + email + "</td><td>" + phoneNumber
				+ "</td></tr></table>";
	}

	public static String nonUserHeaderString() {
		String headerString = "<ul><li><a href= \"/\">Home</a></li>"
				+ "<li><a href=\"/aboutus.jsp\">About us</a></li>"
				+ "<li><a href=\"/location.jsp\">Location</a></li>"
				+ "<li><a href=\"/catalog\">Catalog</a></li>"
				+ "<li><a href = \"/aboutme.jsp\">About me</a></li>"
				+ "<li style=\"float:right\"><a href=\"/createaccount.jsp\">Create an account</a></li>"
				+ "<li style=\"float:right\"><a href=\"/login.jsp\">Log in</a></li></ul>";
		return headerString;
	}
	public static String headerString() {
		String headerString = "<ul><li><a href= \"/\">Home</a></li>"
				+ "<li><a href=\"/aboutus.jsp\">About us</a></li>"
				+ "<li><a href=\"/location.jsp\">Location</a></li>"
				+ "<li><a href=\"/catalog\">Catalog</a></li>"
				+ "<li><a href = \"userinfo\">User Info</a></li>"
				+ "<li><a href = \"/aboutme.jsp\">About me</a></li>"
				+ "<li style=\"float:right\"><a href=\"/logout\">Log out</a></li></ul>";
		return headerString;
	}
	public static String footerString() {
		return "<div class=\"footer\">\r\n" + 
				"	<table style=\"width: 100%\">\r\n" + 
				"		<tr>\r\n" + 
				"			<td style=\"width: 20%\"><img\r\n" + 
				"				src=\"https://upload.wikimedia.org/wikipedia/en/thumb/7/7c/New_York_Public_Library_logo.svg/1200px-New_York_Public_Library_logo.svg.png\"\r\n" + 
				"				style=\"width: 100%\"></td>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"			<td>\r\n" + 
				"				<div style=\"padding: 20px; margin: auto; font-size: 1.1em\">\r\n" + 
				"					10 Grand Army Plaza<br> Brooklyn, NY 11238<br>\r\n" + 
				"					(718)-230-2100<br> <br style=\"line-height: 0.5em\"> <a href=\"/\">Home</a><br> <a\r\n" + 
				"						href=\"/aboutus.jsp\">About Us</a><br> <a href=\"/location.jsp\">Location</a><br>\r\n" + 
				"				</div>\r\n" + 
				"			</td>\r\n" + 
				"\r\n" + 
				"			<td>\r\n" + 
				"				<div>\r\n" + 
				"					<table style=\"padding: 10px 0; margin: 0; font-size: 0.8em;\">\r\n" + 
				"						<tr style=\"border-bottom: none\">\r\n" + 
				"							<td>Monday</td>\r\n" + 
				"							<td>10 AM - 4 PM</td>\r\n" + 
				"						</tr>\r\n" + 
				"						<tr style=\"border-bottom: none\">\r\n" + 
				"							<td>Tuesday</td>\r\n" + 
				"							<td>1 PM - 7 PM</td>\r\n" + 
				"						</tr>\r\n" + 
				"						<tr style=\"border-bottom: none\">\r\n" + 
				"							<td>Wednesday</td>\r\n" + 
				"							<td>10 AM - 4 PM</td>\r\n" + 
				"						</tr>\r\n" + 
				"						<tr style=\"border-bottom: none\">\r\n" + 
				"							<td>Thursday</td>\r\n" + 
				"							<td>1 PM - 7 PM</td>\r\n" + 
				"						</tr>\r\n" + 
				"						<tr style=\"border-bottom: none\">\r\n" + 
				"							<td>Friday</td>\r\n" + 
				"							<td>10 AM - 4 PM</td>\r\n" + 
				"						</tr>\r\n" + 
				"						<tr style=\"border-bottom: none\">\r\n" + 
				"							<td>Saturday</td>\r\n" + 
				"							<td>10 AM - 4 PM</td>\r\n" + 
				"						</tr>\r\n" + 
				"						<tr style=\"border-bottom: none\">\r\n" + 
				"							<td>Sunday</td>\r\n" + 
				"							<td>Closed</td>\r\n" + 
				"						</tr>\r\n" + 
				"					</table>\r\n" + 
				"				</div>\r\n" + 
				"			</td>\r\n" + 
				"			<td style=\"width: 40%\">\r\n" + 
				"				<div style=\"\">\r\n" + 
				"					<img\r\n" + 
				"						src=\"https://cdn-d8.nypl.org/s3fs-public/2020-05/NYPL_MainFacadeRev2Cam2.png\"\r\n" + 
				"						style=\"width: 100%\">\r\n" + 
				"				</div>\r\n" + 
				"			</td>\r\n" + 
				"		</tr>\r\n" + 
				"	</table>\r\n" + 
				"</div>\r\n";
	}

	
}
