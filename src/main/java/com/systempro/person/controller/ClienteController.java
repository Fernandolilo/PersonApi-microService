package com.systempro.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.systempro.person.entities.Client;
import com.systempro.person.services.ClientService;

@RestController
@RequestMapping(value= "/client")
public class ClienteController {

	private final ClientService clientService;

	@Autowired
	public ClienteController(ClientService clientService) {
		this.clientService = clientService;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Client> findById(@PathVariable Integer id){
		Client obj = clientService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
