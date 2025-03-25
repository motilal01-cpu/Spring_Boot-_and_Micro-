//AppConfig.java(Target Class)
package com.nt.config;

import java.time.LocalTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.nt.sbeans")
public class AppConfig 
{
	public AppConfig()
	{
		System.out.println("AppConfig.0-arg Constructor");
		
	}
	@Bean(name="time")
	public LocalTime createLTime()
	{
		return LocalTime.now();
	}
	

}
 