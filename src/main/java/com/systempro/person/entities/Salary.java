package com.systempro.person.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "SALARY")
public class Salary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Double salary;
	private Double percentage;

	@JsonIgnore
	@OneToMany(mappedBy = "salary")
	private List<Occupation> occupations = new ArrayList<>();

	public Salary() {
	}

	public Salary(Integer id, Double salary) {
		this.id = id;
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public List<Occupation> getOccupations() {
		return occupations;
	}

	@JsonIgnore
	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	public double getINSS() {
		if (salary <= 1100.00) {
			return -salary * 0.075;
		}
		if (salary > 1100.00 && salary <= 2203.48) {
			return (salary - 1100) * 0.09;
		}
		if (salary > 2203.48 && salary <= 3305.22) {
			return (salary - 2203.48) * 0.12;
		}
		if (salary > 3305.22) {
			return (salary - 3305.22) * 0.14;
		} else {
			return salary;
		}
	}

	public double getFgts() {
		return salary * 0.08;
	}

	public double getIR() {
		if (salary <= 1903.98) {
			return 0;
		}
		if (salary >= 1903.98 && salary <= 2826.65) {
			return ((salary - getINSS())* 12 * 0.075) /12;
		}
		if (salary > 2826.65 && salary <= 3751.05) {
			return ((salary - getINSS()) * 12 * 0.15) / 12;
		}
		if (salary > 3751.05 && salary <= 4664.68) {
			return ((salary - getINSS()) * 12 * 0.225) / 12;
		}
		if (salary > 4664.68) {
			return ((salary- getINSS()) * 12 * 0.275) / 12;
		} else {
			return salary;
		}
	}

	public double getSalaryBase() {
		return salary - (getINSS() + getIR() + getFgts());
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
		Salary other = (Salary) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
