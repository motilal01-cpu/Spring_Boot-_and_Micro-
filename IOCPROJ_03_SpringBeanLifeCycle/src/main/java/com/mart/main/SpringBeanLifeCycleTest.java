package com.mart.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mart.config.AppConfig;
import com.mart.sbeans.VoterDetails;

public class SpringBeanLifeCycleTest 
{

	public static void main(String[] args) 
	{
		//create IOC container
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		
		//get spring bean class obj ref
		VoterDetails details=ctx.getBean("vd",VoterDetails.class);
		
		//invoke the b.method
		String resultMsg=details.checkVotingElgblity();
		System.out.println(resultMsg);
		
		//close the container
		ctx.close();
	}

}
