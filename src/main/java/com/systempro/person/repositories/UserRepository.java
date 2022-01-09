package com.systempro.person.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.systempro.person.entities.Client;

@Repository
public interface UserRepository extends JpaRepository<Client, Integer>{

}
