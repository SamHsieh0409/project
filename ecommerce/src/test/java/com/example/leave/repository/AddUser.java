package com.example.leave.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.leave.model.dto.UserDTO;
import com.example.leave.model.entity.User;
import com.example.leave.service.UserService;

@SpringBootTest
public class AddUser {
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	public void test() {
		try {
			// 建立一個 user 物件
			User user = new User();
			user.setUsername("Jenny");
			user.setPassword("111");
			
			userRepository.save(user);
			
			System.out.println("新增完成");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
