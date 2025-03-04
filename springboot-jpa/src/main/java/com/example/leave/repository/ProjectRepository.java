package com.example.leave.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.leave.model.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
