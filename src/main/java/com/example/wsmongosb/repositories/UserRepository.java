package com.example.wsmongosb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.wsmongosb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User,String>{

}
