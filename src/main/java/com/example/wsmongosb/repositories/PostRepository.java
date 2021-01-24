package com.example.wsmongosb.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.wsmongosb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post,String>{
	
	//reference: https://docs.mongodb.com/manual/reference/operator/query/regex/
	// format: { <field>: { $regex: /pattern/, $options: '<options>' } }
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	public List<Post> findByTitle(String Text);
	
	public List<Post> findByTitleContainingIgnoreCase(String title);

	@Query("{ $and: [ {date: {$gte: ?1} }, {date: { $lte: ?2} }, "
			+ "{ $or: [ { 'title': { $regex: ?0, $options: 'i' } }, "
			+ "{ 'body': { $regex: ?0, $options: 'i' } }, "
			+ "{ 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	public List<Post> findString(String text, Date d1, Date d2);
}
