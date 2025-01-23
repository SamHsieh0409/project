package com.example.leave.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.leave.model.entity.User;


@Repository
public interface  UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);
}
