package com.systempro.person.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Departiment implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String department;

	@ManyToOne
	@JoinColumn(name = "function_id")
	private Function function;


	@OneToMany(mappedBy = "departiment")
	private List<User> users = new ArrayList<>();

	public Departiment() {
	}

	public Departiment(Integer id, String department, Function function) {
		super();
		this.id = id;
		this.department = department;
		this.function = function;
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

	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

	public List<User> getUsers() {
		return users;
	}
}
