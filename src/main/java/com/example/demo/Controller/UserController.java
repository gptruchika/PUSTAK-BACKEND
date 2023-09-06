package com.example.demo.Controller;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/login")
	public Boolean processLogin(@RequestParam String username , @RequestParam String password ) {
		
		User user = userRepository.findByUsername(username);
		
		if(user != null && user.getPassword().equals(password)) {
			return true;
		}
		
		return false;
		
	}
	
	@PostMapping("/addUser")
	public Boolean AddUser (@RequestBody User user) {
		User user1 = userRepository.findByUsername(user.getUsername());
		if(user1 != null) {
			return false;
		}
		userRepository.save(user);
		return true;
	}
	
	@GetMapping("user/{username}") 
	public User getUser (@PathVariable("username")String username ) {
		
			User user = userRepository.findByUsername(username);
				return user;
			
	}
	
	@PutMapping("/update")
	public boolean updateUser(@RequestBody User user) {
		
		User user1 = null;
		user1 = userRepository.findByUsername(user.getUsername());
		if(user1 != null) {
			user1.setAddress(user.getAddress());
			user1.setPassword(user.getPassword());
			user1.setCity(user.getCity());
			user1.setState(user.getState());
			user1.setPostalCode(user.getPostalCode());
			user1.setGender(user.getGender());
			user1.setEmail(user.getEmail());
			user1.setContact(user.getContact());
			userRepository.save(user1);
			return true;
		}
		return false;
	}
	
	
}

