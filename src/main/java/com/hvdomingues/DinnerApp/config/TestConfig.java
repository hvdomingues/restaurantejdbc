package com.hvdomingues.DinnerApp.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("sql")
public class TestConfig implements CommandLineRunner {


	@Override
	public void run(String... args) throws Exception {
		
		

	}

}
