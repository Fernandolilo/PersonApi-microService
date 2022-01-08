package com.systempro.person.entities;

import java.util.ArrayList;
import java.util.List;

public class Function {

	private Integer id;
	private String function;
	private User user;
	
	private List<Departiment> departments = new ArrayList<>();
	
	public Function() {
	}

	public Function(Integer id, String function, User user) {
		super();
		this.id = id;
		this.function = function;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Departiment> getDepartments() {
		return departments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Function other = (Function) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("id: ")
			   .append(id)
			   .append(", função: ")
			   .append(function)
			   .append(", Funcionário: ")
			   .append(user)
			   .append(", departamento: ")
			   .append(departments);
		return builder.toString();
	}

}
