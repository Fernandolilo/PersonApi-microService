package com.systempro.person.services;

import org.bouncycastle.jcajce.provider.keystore.BC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.systempro.person.entities.Department;
import com.systempro.person.entities.Occupation;
import com.systempro.person.entities.Client;
import com.systempro.person.repositories.DepartmentRepository;
import com.systempro.person.repositories.OccupationRepository;
import com.systempro.person.repositories.ClientRepository;

@Service
public class DBService {

	private final ClientRepository clientRepository;
	private final DepartmentRepository departmentRepository;
	private final OccupationRepository occupationRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public DBService(ClientRepository clientRepository, DepartmentRepository departmentRepository,
			OccupationRepository occupationRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.clientRepository = clientRepository;
		this.departmentRepository = departmentRepository;
		this.occupationRepository = occupationRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		
	}

	public void instantiateTestDatabase() {

		Department d1 = new Department(null, "Departamento T.I");
		Occupation f1 = new Occupation(null, "Tecnico de campo I", d1);
		Client u1 = new Client(null, "Fernando da Silva", "nando.systempro@hotmail.com",bCryptPasswordEncoder.encode("1234"), "36906855832", d1, f1);
		
		d1.getFunctions().add(f1);
		d1.getUsers().add(u1);
		f1.getUsers().add(u1);

		departmentRepository.save(d1);
		occupationRepository.save(f1);
		clientRepository.save(u1);
	}
}
