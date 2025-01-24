package com.example.leave.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.leave.model.dto.UserDTO;
import com.example.leave.service.UserService;

import jakarta.servlet.http.HttpSession;


@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
	
	//驗證
	@PostMapping("/login")
	public String login(@RequestParam String username, 
						@RequestParam String password, 
						HttpSession session) {
		
		UserDTO userDTO = userService.login(username, password);
		return "/index";
	}
	
}
