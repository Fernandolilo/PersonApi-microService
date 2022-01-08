package com.systempro.person.entities;
import org.hibernate.validator.constraints.br.CPF;

public class User {
	
	private Integer id;
	private String name;
	private String email;
	private String password;
	@CPF
	private String cpf;
	private Departiment departiment;
	private Function function;
	
	public User() {
	}

	public User(Integer id, String name, String email, String password,
			String cpf, Departiment departiment,
			Function function) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.cpf = cpf;
		this.departiment = departiment;
		this.function = function;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Departiment getDepartiment() {
		return departiment;
	}

	public void setDepartiment(Departiment departiment) {
		this.departiment = departiment;
	}

	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
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
		User other = (User) obj;
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
			   .append(", nome: ")
			   .append(name)
			   .append(", email: ")
			   .append(email)
			   .append(", cpf: ")
			   .append(cpf)
			   .append(", departamento: ")
			   .append(departiment)
			   .append(", função: ")
			   .append(function);
		return builder.toString();
	}
	
	
	
}
