package com.systempro.person.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.systempro.person.entities.Departiment;
import com.systempro.person.entities.Function;
import com.systempro.person.entities.User;
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

		Departiment d1 = new Departiment(null, "Departamento T.I");
		Function f1 = new Function(null, "Tecnico de campo I", d1);
		User u1 = new User(null, "Fernando da Silva", "nando.systempro@hotmail.com", "1234", "36906855832", d1, f1);
		
		d1.getFunctions().add(f1);
		d1.getUsers().add(u1);
		f1.getUsers().add(u1);

		departimentRepository.save(d1);
		functionRepository.save(f1);
		userRepository.save(u1);
	}
}
