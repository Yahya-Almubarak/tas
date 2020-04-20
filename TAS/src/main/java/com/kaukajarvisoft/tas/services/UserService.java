package com.kaukajarvisoft.tas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaukajarvisoft.tas.policy.Policy;
import com.kaukajarvisoft.tas.policy.Role;
import com.kaukajarvisoft.tas.repositories.UserRepository;
import com.kaukajarvisoft.tas.users.TasUser;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public TasUser registerUser(TasUser user) {
		return userRepository.save(user);
	}
	
	public void unRegisterUser(TasUser user) {
		 userRepository.delete(user);
	}
	
	
	public TasUser getUser(Long id) {
		return userRepository.findById(id).get();
	}
	
	public List<TasUser> getUsers() {
		return userRepository.findAll();
	}
	
	

}
