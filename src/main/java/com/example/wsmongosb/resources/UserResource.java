package com.example.wsmongosb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.wsmongosb.domain.User;
import com.example.wsmongosb.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.GET)
	// @GetMapping
	public ResponseEntity<List<User>> findAll(){
		
		return ResponseEntity.ok().body(userService.findAll());
	}
}
