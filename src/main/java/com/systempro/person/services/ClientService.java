package com.systempro.person.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.systempro.person.entities.Client;
import com.systempro.person.repositories.ClientRepository;
import com.systempro.person.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {

	private final ClientRepository clientRepository;

	@Autowired
	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	
	
	/* Retona um cliente por ID */
	public Client findById(Integer id) {
		Optional<Client> obj = clientRepository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " +", Tipo: " + Client.class.getName()));
	}
}
