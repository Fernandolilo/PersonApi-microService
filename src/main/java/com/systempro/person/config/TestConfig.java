package com.systempro.person.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.systempro.person.services.DBService;

@Configuration
@Profile("test")
public class TestConfig {

	private final DBService dbService;
	
	@Autowired
	public TestConfig(DBService dbService) {
		this.dbService = dbService;
	}
	
	@Bean
	public Boolean instantiateDatabase() throws ParseException {
		dbService.instantiateTestDatabase();
		return true;
	}
}