package com.mart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mart.model.Employee;
import com.mart.service.IEmployeeMgmtService;

@Controller("empController")
public class EmployeeOperationController 
{
	@Autowired
	private IEmployeeMgmtService empService;
	
	
	public List<Employee> processEmployeesByDesgs(String desg1,String desg2,String desg3)throws Exception{
	
	//use Service
	List<Employee>list=empService.tethEmployeesByDesg(desg1,desg2,desg3);
	return list;
//
}

}

