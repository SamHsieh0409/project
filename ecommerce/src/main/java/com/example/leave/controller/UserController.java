package com.example.leave.controller;


import org.springframework.web.bind.annotation.RestController;

import com.example.leave.model.dto.UserDTO;
import com.example.leave.service.UserService;



import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController

public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public String getUsers() {
        return "Hello, Users!";
    }
	
	//員工註冊(註冊頁面)
	@GetMapping("/rigister")
	public String register() {
		return "user_register";
	}
	
	//員工註冊(從註冊頁面傳來的資訊)
	@PostMapping("/register")
	public String addUser(@RequestParam String username,
			            @RequestParam String password,
			            @RequestParam(required = false) String role, 
			            Model model) {
		userService.addUser(username, password, role);
		
		model.addAttribute("message", "用戶註冊成功");
		return "result";
	}
}
