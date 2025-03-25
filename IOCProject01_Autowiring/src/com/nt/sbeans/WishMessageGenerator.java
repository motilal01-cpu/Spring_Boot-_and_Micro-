//WishMessageGenerator.java
package com.nt.sbeans;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerator 
{
	@Autowired //Field Injection
	private LocalTime lt;//HAS-A property(composition)
	
	public WishMessageGenerator()
	{
		System.out.println("WishMessageGenerator::0-arg constructor");
	}
	//Business method 
	public String generateMessage(String user)
	{
		//get current hour of the day
		int hour=lt.getHour();
		//generate the wishMessages
		if(hour<12)
			return "Good Morning:"+user;
		else if(hour<16)
			return "Good Afternoon:"+user;
		else if(hour<20)
			return "Good evening:"+user;
		else
			return "Good night:"+user;
	}

}
