package com.systempro.person.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Departiment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String department;

	@OneToMany(mappedBy = "departiment")
	private List<Function> functions = new ArrayList<>();

	@OneToMany(mappedBy = "departiment")
	private List<Client> clients = new ArrayList<>();

	public Departiment() {
	}

	public Departiment(Integer id, String department) {
		super();
		this.id = id;
		this.department = department;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<Function> getFunctions() {
		return functions;
	}

	public List<Client> getUsers() {
		return clients;
	}

}
