package com.systempro.person.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.systempro.person.entities.Department;
import com.systempro.person.entities.Occupation;
import com.systempro.person.entities.Client;
import com.systempro.person.repositories.DepartimentRepository;
import com.systempro.person.repositories.FunctionRepository;
import com.systempro.person.repositories.UserRepository;

@Service
public class DBService {

	private final UserRepository userRepository;
	private final DepartimentRepository departimentRepository;
	private final FunctionRepository functionRepository;
	

	@Autowired
	public DBService(UserRepository userRepository, DepartimentRepository departimentRepository,
			FunctionRepository functionRepository) {
		super();
		this.userRepository = userRepository;
		this.departimentRepository = departimentRepository;
		this.functionRepository = functionRepository;
		
	}

	public void instantiateTestDatabase() {

		Department d1 = new Department(null, "Departamento T.I");
		Occupation f1 = new Occupation(null, "Tecnico de campo I", d1);
		Client u1 = new Client(null, "Fernando da Silva", "nando.systempro@hotmail.com","1234", "36906855832", d1, f1);
		
		d1.getFunctions().add(f1);
		d1.getUsers().add(u1);
		f1.getUsers().add(u1);

		departimentRepository.save(d1);
		functionRepository.save(f1);
		userRepository.save(u1);
	}
}
