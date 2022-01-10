package com.systempro.person.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.systempro.person.entities.Client;
import com.systempro.person.repositories.ClientRepository;
import com.systempro.person.security.UserSS;

@Service
public class UserDatailsServiceImpl implements UserDetailsService {

	private final ClientRepository repository;

	public UserDatailsServiceImpl(ClientRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Client cli = repository.findByEmail(email);
		if(cli == null) {
			throw new UsernameNotFoundException(email);
		}
		return new UserSS(cli.getId(), cli.getEmail(), cli.getPassword(), cli.getPerfis());
	}

}
