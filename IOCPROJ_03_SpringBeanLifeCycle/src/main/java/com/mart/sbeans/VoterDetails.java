package com.mart.sbeans;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("vd")
@PropertySource("com/mart/commons/PersonInfo.properties")
public class VoterDetails 

{
	private static final long OL=0;
  @Value("${voter.ano}")
  private long vid;
  
  @Value("${voter.name}")
  private String name;
  
  @Value("${voter.age}")
  private float age;
  
  private Date dov;
  
  public VoterDetails()
  {
	  System.out.println("VoterDetails.VoterDetails()");
  }
  
  //custom init method init lifecycle method
  
  
  @PostConstruct
  public void myInit()
  {
	 System.out.println("VoterDetails.myInit()"); 
	 
	 dov=new Date(0,0,0);
	 
	 if(name==null || age<18||age>120||vid<0)
		 throw new IllegalArgumentException("invalid inputs");
	 
  }
  
  //b.method
  public String checkVotingElgblity()

  {
	  System.out.println("VoterDetails.checkVotingElgblity()");
	  if(age<18)
		  return "Mr/Mis/Mrs"+name+"you are not elgblity for voting--->verified on"+dov;
	  else
		  return "Mr/Miss/Mrs"+name+"you are elgblity for voting--->verified on"+dov;
  }
  
  @PreDestroy
  public void destroy()
  {
	System.out.println("VoterDetails.destroy()");  
	//nullifying the spring bean properties
	dov=null;
	vid=0L;
	age=0;
  }
}
