package com.example.leave.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.leave.model.dto.UserDTO;
import com.example.leave.model.entity.User;
import com.example.leave.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	//新增員工
	public void addUser(UserDTO userDTO) {
		
		User user = new User();
		user.setUsername(userDTO.getUsername());
		//加密密碼
		user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		user.setRole(userDTO.getRole() != null ? userDTO.getRole():"customer");
		userRepository.save(user);
		
	}
}
