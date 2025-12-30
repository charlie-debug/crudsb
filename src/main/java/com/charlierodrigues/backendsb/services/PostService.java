package com.charlierodrigues.backendsb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charlierodrigues.backendsb.domain.Post;
import com.charlierodrigues.backendsb.repository.PostRepository;
import com.charlierodrigues.backendsb.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> post = repo.findById(id);
		return post.orElseThrow(()-> new ObjectNotFoundException("post não encontrado!"));
	}
	public List<Post>findByTitle(String text){
		return repo.findByTitleContainingIgnoreCase(text);
		
		
	}
}
