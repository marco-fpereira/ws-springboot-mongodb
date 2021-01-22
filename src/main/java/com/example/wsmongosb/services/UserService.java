package com.example.wsmongosb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wsmongosb.domain.User;
import com.example.wsmongosb.dto.UserDTO;
import com.example.wsmongosb.repositories.UserRepository;
import com.example.wsmongosb.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
	
	public User insert(User user) {
		return userRepository.insert(user);
	}
	
	public void delete(String id) {
		
		userRepository.delete(findById(id));
	}
	
	public User update(User user) {
		User newUser = findById(user.getId());
		updateData(user, newUser);
		return userRepository.save(newUser);
	}
	
	private void updateData(User user, User newUser) {
		newUser.setName(user.getName());
		newUser.setEmail(user.getEmail());
	}

	//it would be done in the UserDTO class, but as there's already a userRepository here, I preferred to do it here
	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(),userDTO.getName(),userDTO.getEmail());
	}
}
