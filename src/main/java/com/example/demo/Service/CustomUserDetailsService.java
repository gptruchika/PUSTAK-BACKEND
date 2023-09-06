//package com.example.demo.Service;
//
//import java.util.ArrayList;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.Entity.User;
//import com.example.demo.Repository.UserRepository;
//
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService{
//	@Autowired
//	UserRepository userRepository;
//	
//	@Override 
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		
//		User user = userRepository.findByUsername(username);
//		
//		if(username.equals(user.getUsername())) {
//			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
//		}
//		else {
//			throw new UsernameNotFoundException("User not found !!");
//		}
//			
//	}
//	
//}
