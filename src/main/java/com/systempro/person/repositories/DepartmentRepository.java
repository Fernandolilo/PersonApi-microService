package com.systempro.person.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.systempro.person.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
