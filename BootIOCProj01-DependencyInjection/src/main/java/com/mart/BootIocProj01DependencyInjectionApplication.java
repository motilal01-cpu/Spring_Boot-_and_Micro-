package com.mart;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.mart.sbeans.SeasonFinder;

@SpringBootApplication
public class BootIocProj01DependencyInjectionApplication 
{
	@Bean(name="dt")
	public LocalDate createLDate()
	{
		return LocalDate.now();
	}

	public static void main(String[] args)
	{
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(BootIocProj01DependencyInjectionApplication.class, args);
		//ConfigurableApplicationContext ctx=SpringApplication.run(BootIocProj01DependencyInjectionApplication.class, args);
		
		//get target spring bean class obj ref
		SeasonFinder finder=ctx.getBean("sf",SeasonFinder.class);
		
		//Invoke the b.method
		String resultMsg=finder.findSeason();
		
		//display the result
		System.out.println(resultMsg);
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
		//ctx.close();
	}

}
