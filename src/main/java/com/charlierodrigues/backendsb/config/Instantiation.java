package com.charlierodrigues.backendsb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.charlierodrigues.backendsb.domain.User;
import com.charlierodrigues.backendsb.repository.UserRepository;
@Configuration
public class Instantiation implements CommandLineRunner {
   
	@Autowired
	private UserRepository userRepository;
	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		User charlie = new User(null, "charlie", "charlie@gmail.com");
		User giovana = new User(null, "giovana","giovana@gmail.com" );
		User lucia = new User(null, "lucia", "lucia@gmail.com");
		userRepository.saveAll(Arrays.asList(charlie,giovana,lucia));
		
	}

}
