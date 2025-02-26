package com.example.leave.model.dto;

import java.util.Date;
import java.util.List;

import com.example.leave.model.entity.LeaveRequest;
import com.example.leave.model.entity.Project;
import com.example.leave.model.entity.Salary;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalaryDTO {
	private Integer id;
	private Integer amount;//薪資
	
	
}
