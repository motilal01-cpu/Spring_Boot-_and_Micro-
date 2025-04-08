package com.mart.sbeans;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("sf")
public class SeasonFinder 
{
	@Autowired //Field injection
	private LocalDate ldate;
	
	//b.method
	public String findSeason()
	{
		//get current month value
		int month=ldate.getMonthValue(); 
		
		//generate the season name
		if(month>=3 && month<=6)
			return"summer season";
		else if(month>=7 && month<=10)
			return "Rainy season";
		else
			return "Winter Season";
	

	}}
