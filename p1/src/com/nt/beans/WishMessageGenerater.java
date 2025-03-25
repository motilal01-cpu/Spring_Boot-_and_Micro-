package com.nt.beans;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerater {
	
	@Autowired
	private LocalTime lt;
	
	public WishMessageGenerater()
	{
		System.out.println("WishMessageGenerater.WishMessageGenerator()");
	}
  public String generateMessage(String user)
  {
	  int hour=lt.getHour();
	  
	  if(hour<12)
	    return "Good Morning"+user;
	  else
		  return "good Night"+user;
  }
	

}
