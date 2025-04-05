package com.mart.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mart.config.AppConfig;
import com.mart.sbeans.PersonInfo;

public class ValueAnnotationTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
	
		PersonInfo info=ctx.getBean("pinfo",PersonInfo.class);
		System.out.println(info);
		ctx.close();

//okk
		
	}

}
