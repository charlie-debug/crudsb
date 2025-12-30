package com.charlierodrigues.backendsb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.charlierodrigues.backendsb.domain.Post;
import com.charlierodrigues.backendsb.domain.User;
import com.charlierodrigues.backendsb.dto.AuthorDTO;
import com.charlierodrigues.backendsb.dto.CommentsDTO;
import com.charlierodrigues.backendsb.repository.PostRepository;
import com.charlierodrigues.backendsb.repository.UserRepository;
@Configuration
public class Instantiation implements CommandLineRunner {
   
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private  PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		User charlie = new User(null, "charlie", "charlie@gmail.com");
		User giovana = new User(null, "giovana","giovana@gmail.com" );
		User lucia = new User(null, "lucia", "lucia@gmail.com");
		userRepository.saveAll(Arrays.asList(charlie,giovana,lucia));
		postRepository.deleteAll();
		Post post1 = new Post(null, sdf.parse("28/12/2025"), "partiu viagem", "Vou para Nova Zelândia!",new AuthorDTO(charlie));
		Post post2 = new Post(null, sdf.parse("25/12/2025"), "Bom dia!", "Hoje é dia de fazer caminhada...",new AuthorDTO(giovana));
	
		CommentsDTO c1 = new CommentsDTO(sdf.parse("28/12/2028"), "que legal, aproveite a viagem", new AuthorDTO(charlie));
		CommentsDTO c2 = new CommentsDTO(sdf.parse("26/12/2024"), "tenho vontade ir ir também!", new AuthorDTO(charlie));
		CommentsDTO c3 = new CommentsDTO(sdf.parse("21/12/2024"), "boa caminhada...", new AuthorDTO(lucia));
		
		post1.getComments().addAll(Arrays.asList(c1,c2));
		post2.getComments().addAll(Arrays.asList(c3));	
		
		postRepository.saveAll(Arrays.asList(post1,post2));		
		charlie.getPosts().add(post1);
		giovana.getPosts().add(post2);
		
		userRepository.saveAll(Arrays.asList(charlie,giovana));
	}

}
