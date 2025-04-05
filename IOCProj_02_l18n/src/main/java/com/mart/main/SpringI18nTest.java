package com.mart.main;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mart.config.AppConfig;

public class SpringI18nTest {

	public static void main(String[] args) 
	{
		
		//create IOC container
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		
		//gather Local details from enduser
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter language code:");
		String lang=sc.next();
		System.out.println("Enter country code:");
		String country=sc.next();
		
		//preapre locale obj data
		Locale locale=new Locale(lang,country);
		
		//get the message from the locale specific 
		String msg1=ctx.getMessage("nit.welcome",new String[] {},"aa",locale);
		String msg2=ctx.getMessage("nit.bye",new String[] {},"bb",locale);
		String msg3=ctx.getMessage("nit.wishes",new String[] {},"cc",locale);
		
		//Print message
		System.out.println(msg1+""+msg2+""+msg3 );
		
		//close the container
		ctx.close();
	}

}
