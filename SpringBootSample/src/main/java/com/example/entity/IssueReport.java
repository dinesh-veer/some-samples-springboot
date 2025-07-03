package com.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name="issues")
public class IssueReport {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	private String name;

	private String email;
	private String description;
	
	public IssueReport() {}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
