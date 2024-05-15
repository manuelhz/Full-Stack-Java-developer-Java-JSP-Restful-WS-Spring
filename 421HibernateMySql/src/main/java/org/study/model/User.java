package org.study.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class User {
	private int userId;
	@Size(min = 5, max = 10, message = "Enter the name between 5 to 10 characters")
	private String name;
	@Email
	private String email;

	public User(int userId, @Size(min = 5, max = 10, message = "Enter the name between 5 to 10 characters") String name,
			@Email String email) {
		this.userId = userId;
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + "]";
	}

}
