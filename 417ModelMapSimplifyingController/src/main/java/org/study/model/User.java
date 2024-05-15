package org.study.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class User {
	@Size(min=5, max=10, message = "Enter the name between 5 to 10 characters")
	private String name;
	private String gender;
	private String country;
	@Email
	private String introduction;
	private String visitedCountries[];

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String[] getVisitedCountries() {
		return visitedCountries;
	}

	public void setVisitedCountries(String[] visitedCountries) {
		this.visitedCountries = visitedCountries;
	}
	
	
}
