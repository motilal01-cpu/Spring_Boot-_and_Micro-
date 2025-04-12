package com.mart;

import java.util.List;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.mart.controller.EmployeeOperationController;
import com.mart.model.Employee;

@SpringBootApplication
public class BootIocProj03MiniProjectLayeredAppApplication {

	public static void main(String[] args) {
		
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(BootIocProj03MiniProjectLayeredAppApplication.class, args);
		
		//get controller class obj ref
		 EmployeeOperationController  controller=ctx.getBean("empController", EmployeeOperationController.class);
		
		//read inputs from enduser
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter desg1");
		String desg1=sc.next();
		System.out.println("Enter desg2");
		String desg2=sc.next();
		System.out.println("Enter desg3");
		String desg3=sc.next();
		
		//invoke the b.method
		try
		{
			List<Employee>list=controller.processEmployeesByDesgs(desg1,desg2,desg3);
			System.out.println("Total employees fetched: " + list.size());

			list.forEach(emp->{
				System.out.println(emp);
			});
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Internal problem ...Try again..");
		}
		//close the container
		((ConfigurableApplicationContext)ctx).close();
	}

}
