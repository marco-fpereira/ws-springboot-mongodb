package com.example.wsmongosb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.wsmongosb.domain.Post;
import com.example.wsmongosb.domain.User;
import com.example.wsmongosb.repositories.PostRepository;
import com.example.wsmongosb.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdfm = new SimpleDateFormat("dd/MM/yyyy");
		sdfm.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		Post p1 = new Post(null,sdfm.parse("21/03/2018"), "partiu viagem", "vou viajar pra sp", maria);
		Post p2 = new Post(null,sdfm.parse("23/06/2018"), "Bom diaa", "acordei feliz hoje", maria);
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		postRepository.saveAll(Arrays.asList(p1,p2));
		
	}

}
