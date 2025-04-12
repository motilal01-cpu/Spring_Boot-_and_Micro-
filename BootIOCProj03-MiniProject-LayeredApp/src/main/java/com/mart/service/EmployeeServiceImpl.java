package com.mart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mart.dao.IEmployeeDAO;
import com.mart.model.Employee;

@Service("empService")
public class EmployeeServiceImpl implements IEmployeeMgmtService
{
	@Autowired
	private IEmployeeDAO dao;

	@Override
	public List<Employee> tethEmployeesByDesg(String desg1, String desg2, String desg3) throws Exception 
	{
		//convert the received signature to Uppercase Content
		
		desg1=desg1.toUpperCase();
		desg2=desg2.toUpperCase();
		desg3=desg3.toUpperCase();
		
		//use DAO
		List<Employee>list=dao.getEmpsByDesgs(desg1, desg2, desg3);
		
		//sort the object in list collection
		list.sort((t1,t2)->t1.getEmpno().compareTo(t2.getEmpno()));
		
		//calculate Gross and net salary
		list.forEach(emp->{
			emp.setGrossSalary(emp.getSalary()+(emp.getSalary()*0.5));
			emp.setNetSalary(emp.getGrossSalary()-(emp.getGrossSalary()*0.2));
		});
		
		return list;
	}

}
