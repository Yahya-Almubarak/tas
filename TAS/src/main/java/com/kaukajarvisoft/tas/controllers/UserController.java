package com.kaukajarvisoft.tas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kaukajarvisoft.tas.services.UserService;
import com.kaukajarvisoft.tas.users.TasUser;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public ResponseEntity<List<TasUser>> getUsers(){
		List<TasUser> users = userService.getUsers();
		if(users == null)
			return new ResponseEntity<List<TasUser>>(users, HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<TasUser>>(users, HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<TasUser> getUser(@PathVariable Long id){
		TasUser user = userService.getUser(id);
		if(user == null)
			return new ResponseEntity<TasUser>(user, HttpStatus.NOT_FOUND);
		return new ResponseEntity<TasUser>(user, HttpStatus.OK);
	}
	
	@PostMapping("/user")
	public ResponseEntity<TasUser> registerUser(@RequestBody TasUser user){
		TasUser _user = userService.registerUser(user);
		if(_user == null)
			return new ResponseEntity<TasUser>(_user, HttpStatus.NOT_FOUND);
		return new ResponseEntity<TasUser>(_user, HttpStatus.OK);
	}
	
	
}
