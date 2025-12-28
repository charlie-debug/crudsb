package com.charlierodrigues.backendsb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.charlierodrigues.backendsb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
