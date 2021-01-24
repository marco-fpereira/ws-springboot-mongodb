package com.example.wsmongosb.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wsmongosb.domain.Post;
import com.example.wsmongosb.repositories.PostRepository;
import com.example.wsmongosb.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	public List<Post> findAll(){
		return postRepository.findAll();
	}
	
	public Post findById(String id) {
		Optional<Post> post = postRepository.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
	
	public Post insert(Post post) {
		return postRepository.insert(post);
	}
	
	public void delete(String id) {
		
		postRepository.delete(findById(id));
	}
	
	public Post update(Post post) {
		Post newPost = findById(post.getId());
		updateData(post, newPost);
		return postRepository.save(newPost);
	}
	
	private void updateData(Post post, Post newPost) {
		newPost.setDate(post.getDate());
		newPost.setTitle(post.getTitle());
		newPost.setBody(post.getBody());
		newPost.setAuthor(post.getAuthor());
	}
	
	public List<Post> findByTitle(String text){
		//return postRepository.findByTitleContainingIgnoreCase(text);
		return postRepository.findByTitle(text);
	}
	
	public List<Post> findString(String text, Date d1, Date d2){
		d2 = new Date(d2.getTime()+24*60*60*1000);
		return postRepository.findString(text, d1, d2);
	}
}
