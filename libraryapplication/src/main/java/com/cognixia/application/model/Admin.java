package com.cognixia.application.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admins")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;
	private String adminPassword;
	private String lastName;
	private String firstName;
	private String email;
	private String phoneNumber;
	
	public Admin(int adminId, String adminPassword, String lastName, String firstName, String email, String phoneNumber) {
		super();
		this.adminId = adminId;
		this.adminPassword = adminPassword;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	public Admin() {
		super();
	}
	public int getAdminId() {
		return adminId;
	}
	public String getAdminPassword() {
		return adminPassword;
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
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
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
		return "Admin [adminId=" + adminId + ", adminPassword=" + adminPassword + ", lastName=" + lastName
				+ ", firstName=" + firstName + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
}
