package com.example.wsmongosb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.wsmongosb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post,String>{

}
