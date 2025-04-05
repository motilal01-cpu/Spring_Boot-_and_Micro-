package com.mart.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages="com.mart.sbeans")
@PropertySource("com/mart/commons/info.properties")
public class AppConfig {

}
