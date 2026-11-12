package com.internmo.hashnode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internmo.hashnode.entity.User;
import com.internmo.hashnode.service.UserService;

@RestController
@RequestMapping("api/v1")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/createUser")
	public User createUser(@RequestBody User u) {
		return userService.createUser(u);
	}

	@GetMapping("/getallusers")
	List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/getuserbyid/{id}")
	User getUserById(@PathVariable("id") Long id) {
		return userService.getUserById(id);
	}

	@GetMapping("/getuserbyname/{name}")
	User getUserByName(@PathVariable("name") String name) {
		return userService.getUserByName(name);
	}

	@PutMapping("/updateuserbyid/{id}")
	User updateUserById(@RequestBody User user, @PathVariable Long id) {

		return userService.updateUserById(user, id);
	}

	@DeleteMapping("/deleteuserbyid/{id}")
	String deleteUserById(@PathVariable("id") Long id) {
		userService.deleteUserById(id);
		return "User with " + id + " has been deleted";
	}

}
