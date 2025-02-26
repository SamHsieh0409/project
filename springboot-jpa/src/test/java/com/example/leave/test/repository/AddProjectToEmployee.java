package com.example.leave.test.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.leave.model.entity.Employee;
import com.example.leave.model.entity.Project;
import com.example.leave.repository.EmployeeRepository;
import com.example.leave.repository.ProjectRepository;

@SpringBootTest
public class AddProjectToEmployee {

	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Test
	public void test() {
		try {
			//取得專案(請自行查詢資料表紀錄)
			Project Web = projectRepository.findById(1).get();
			Project PPT = projectRepository.findById(2).get();
			Project App = projectRepository.findById(3).get();
			//取得員工(請自行查詢資料表紀錄)
			Employee david = employeeRepository.findById(1).get();
			Employee john = employeeRepository.findById(2).get();
			Employee sam = employeeRepository.findById(3).get();
			//員工自行認領專案
			john.getProjects().add(Web);
			john.getProjects().add(PPT);
			john.getProjects().add(App);
			employeeRepository.save(john);
			
			sam.getProjects().add(Web);
			sam.getProjects().add(PPT);
			employeeRepository.save(sam);
			
			david.getProjects().add(App);
			employeeRepository.save(david);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
