package com.example.demo.resouces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	@Autowired
	private UserRepository repository;
	
	@Value("${test.config}")
	private String testConfig;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findByID(@PathVariable Long id){
		User obj = repository.findById(id).get();
		return ResponseEntity.ok(obj);		
	}
	
	@GetMapping(value = "/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email) {
		User obj = repository.findByEmail(email);
		return ResponseEntity.ok(obj);
	}
}
