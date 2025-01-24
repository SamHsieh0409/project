package com.example.leave.repository;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.leave.model.dto.UserDTO;
import com.example.leave.model.entity.User;
import com.example.leave.service.UserService;

@SpringBootTest
public class AddUser {
	
	@Autowired
	UserService userService;
	
	@Test
	public void test() {
		try {
			// 建立一個  物件
			UserDTO userDTO = new UserDTO();
			userDTO.setUsername("Andy");
			userDTO.setPassword("111");
			userService.addUser(userDTO);
			System.out.println("新增完成");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
