package com.systempro.person.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.systempro.person.entities.Function;

@Repository
public interface FunctionRepository extends JpaRepository<Function, Integer>{

}