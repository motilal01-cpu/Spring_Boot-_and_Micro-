package com.mart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mart.model.Employee;


@Repository("empDAo")
public class EmployeeDAOImpl implements IEmployeeDAO
{
	private static final String GET_EMPS_BY_DESG="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE UPPER(JOB) IN (UPPER(?), UPPER(?), UPPER(?))"; 
	@Autowired
	private DataSource ds;

	@Override
	public List<Employee>getEmpsByDesgs(String desg1, String desg2, String desg3) throws Exception 
	{
		List<Employee>list=null;
		//GET pooled connection
		try(Connection con=ds.getConnection();
				
				//create PreparedStatement object having the pre-compiled SQLQuery
			PreparedStatement ps=con.prepareStatement(GET_EMPS_BY_DESG);)
		{
			//set values to query parameters
			ps.setString(1,desg1);
			ps.setString(2, desg2);
			ps.setString(3, desg3);
			
			//execute the query
			try(ResultSet rs=ps.executeQuery();)
			{
				//Process the result set object
				list=new ArrayList();
				while(rs.next())
				{
					//copy each record into java bean class object
					Employee emp=new Employee();
					emp.setEmpno(rs.getInt(1));
					emp.setEname( rs.getString(2));
					emp.setJob(rs.getString(3));
					emp.setSalary(rs.getDouble(4));
					emp.setDeptno(rs.getInt(5));
					
					//add each java bean object in list collection
					list.add(emp);
					
					
				}
			}
		}
		catch(SQLException se)
		{
			System.out.println("Some DB Problem,wait for sum Time");
			throw se;
			
		}
		catch(Exception e)
		{
			System.out.println("Some un known Problem,wait for sum Time");
			throw e;
			
		}
		
		return list;
	}

}
