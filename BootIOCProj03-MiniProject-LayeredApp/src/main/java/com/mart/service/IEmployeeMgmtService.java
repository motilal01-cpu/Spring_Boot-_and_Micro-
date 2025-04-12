package com.mart.service;

import java.util.List;

import com.mart.model.Employee;

public interface IEmployeeMgmtService 
{
	public List<Employee> tethEmployeesByDesg(String desg1,String desg2,String desg3)throws Exception; 
}
