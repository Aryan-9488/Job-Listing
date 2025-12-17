package com.aryan.joblisting.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aryan.joblisting.model.Post;

public interface PostRepository extends MongoRepository<Post,String>{

}
