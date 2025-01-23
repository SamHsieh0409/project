package com.example.leave.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.leave.model.entity.User;
import com.example.leave.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	//新增員工
	public void addUser(String username, String password, String role) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setRole(role);
		userRepository.save(user);
		
	}
}
