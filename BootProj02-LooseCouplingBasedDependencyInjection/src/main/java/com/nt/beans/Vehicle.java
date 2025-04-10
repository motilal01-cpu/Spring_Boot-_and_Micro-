//Vehicle.java
package com.nt.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("vehicle")
public class Vehicle {
	
	@Autowired //Field Injection
	@Qualifier("motor")
	private IEngine engg;
	
	public Vehicle()
	{
		System.out.println("Vehicle::0-arg constructor");
	}
	
	
	
	
	//b.method
	public void journey(String startPlace,String endPlace)
	{
		System.out.println("Vehicle.journey()--->journey started from::"+startPlace);
		engg.startEngine();
		System.out.println("Vehicle.journey()--->journey is going on...from"+startPlace);
		
		engg.stopEngine();
		System.out.println("Vehicle.journey()--->journey ended at::"+endPlace);
	}
	

}
