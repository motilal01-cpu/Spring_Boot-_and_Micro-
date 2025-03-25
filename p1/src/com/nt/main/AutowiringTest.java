package com.nt.main;
import com.nt.config.AppConfig;
import com.nt.beans.WishMessageGenerater;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class AutowiringTest {
	
	public static void main(String[]args)
	{
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		
		WishMessageGenerater generater=ctx.getBean("wmg",WishMessageGenerater.class);
		 String msg = generater.generateMessage("Moti");
		 
		 System.out.println("Result is"+msg);
		
	}

}
