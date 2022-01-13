package com.systempro.person.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.systempro.person.entities.Salary;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Integer> {

}
