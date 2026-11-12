package com.internmo.hashnode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internmo.hashnode.entity.User;
import com.internmo.hashnode.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public User createUser(User u) {
		
		return userRepository.save(u);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUserById(Long id) {
		return userRepository.findById(id).orElseThrow();
	}

	public User getUserByName(String name) {
		return userRepository.getUserByName(name);
	}

	public User updateUserById(User user, Long id) {
		
		User userBeforeUpdate = getUserById(id);
		
		userBeforeUpdate.setAvatarUrl(user.getAvatarUrl());
		userBeforeUpdate.setBio(user.getBio());
		userBeforeUpdate.setEmail(user.getEmail());
		userBeforeUpdate.setName(user.getName());
		userBeforeUpdate.setPassword(user.getPassword());
		
		return userRepository.save(userBeforeUpdate);
	}

	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
	}
	
	

}
