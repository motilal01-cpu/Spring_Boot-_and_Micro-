//AutowiredTest.java
package com.nt.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;
import com.nt.sbeans.WishMessageGenerator;

public class AutowiringTest 
{

	public static void main(String[] args)
	{
		//Create IOC Container
		 AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class); 
		 System.out.println("Autowiring Test::IOC Container creation completed");
		 //get Target Spring Bean class obj.ref
		 WishMessageGenerator generator=ctx.getBean("wmg",WishMessageGenerator.class);
		 System.out.println("Target Spring bean Class obj. ref is gathered");
		 
		 //invoke b.method
		 /*String msg=generator.generateMessage("raja");
		 //display the result
		 System.out.println("result is::"+msg);
		 //close the container
		 ctx.close();*/
		 
		 System.out.println("AutowiringTest.main()==>red");
		 

	}

}
