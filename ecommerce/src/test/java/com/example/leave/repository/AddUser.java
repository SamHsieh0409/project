package com.example.leave.repository;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.example.leave.model.entity.User;

@SpringBootTest
public class AddUser {
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	public void test() {
		try {
			
			
			// 建立一個  物件
			User user = new User();
			user.setUsername("Tina");
			user.setPassword("111");
			user.setRole("admin");
			
			userRepository.save(user);
			
			System.out.println("新增完成");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
