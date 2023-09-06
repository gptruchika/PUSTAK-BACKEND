//package com.example.demo.Controller;
//
//import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.demo.Entity.JwtResponse;
//import com.example.demo.Entity.User;
//import com.example.demo.Service.CustomUserDetailsService;
//import com.example.demo.helper.JwtHelper;
//
//@RestController
//public class JwtController {
//	
//	@Autowired
//	private AuthenticationManager authenticationManager;
//	
//	@Autowired
//	private CustomUserDetailsService customUserDetailsService;
//	
//	@Autowired
//	private JwtHelper jwtHelper;
//	
//	
//	@RequestMapping(value = "/token", method = RequestMethod.POST)
//	public ResponseEntity<?> generateToken(@RequestBody User user) throws Exception{
//		
//		try {
//			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
//			
//			
//			
//		}catch(UsernameNotFoundException e) {
//			e.printStackTrace();
//			throw new Exception("Invalid Credentials"); 
//		}
//		
//		UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(user.getUsername());
//		
//		String token = this.jwtHelper.generateToken(userDetails);
//		
//		System.out.println("JWT" + token);
//		
//		
//		return ResponseEntity.ok(new JwtResponse(token));
//		
//	}
//	
//	
//}
