package com.charlierodrigues.backendsb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.charlierodrigues.backendsb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
