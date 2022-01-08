package com.systempro.person.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.systempro.person.entities.Departiment;

@Repository
public interface DepartimentRepository extends JpaRepository<Departiment, Integer>{

}
