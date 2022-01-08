package com.systempro.person.entities;

import java.util.ArrayList;
import java.util.List;

public class Departiment {

	private Integer id;
	private String department;

	private Function function;

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
