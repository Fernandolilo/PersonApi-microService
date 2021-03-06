package com.systempro.person.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String department;

	@JsonIgnore
	@OneToMany(mappedBy = "department")
	private List<Occupation> occupations = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "department")
	private List<Client> clients = new ArrayList<>();

	public Department() {
	}

	public Department(Integer id, String department) {
		this.id = id;
		this.department = department;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JsonIgnore
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@JsonIgnore
	public List<Occupation> getFunctions() {
		return occupations;
	}

	@JsonIgnore
	public List<Client> getUsers() {
		return clients;
	}

}
