package com.example.leave.service;

import org.modelmapper.ModelMapper;
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
	
	@Autowired
	private ModelMapper modelMapper;
	
	//新增員工
	public void addUser(String username, String rawPassword, String role) {
		
		User user = new User();
		user.setUsername(username);
		//加密密碼
		user.setPassword(passwordEncoder.encode(rawPassword));
		user.setRole(role != null ? role:"customer");
		userRepository.save(user);
		
	}
	
	//員工登入
	public UserDTO login(String username, String rawpassword) {
		
		User user = userRepository.findByUsername(username);
		
		if (user == null) {
			throw new IllegalArgumentException("用戶不存在");
		}
		
		if (!passwordEncoder.matches(rawpassword, user.getPassword()) ) {
			throw new IllegalArgumentException("密碼錯誤");
		}
		
		UserDTO userDTO = modelMapper.map(user, UserDTO.class);
		return userDTO;
	}
	
	
	
}
