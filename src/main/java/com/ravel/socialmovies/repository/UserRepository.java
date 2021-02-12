package com.ravel.socialmovies.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ravel.socialmovies.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}