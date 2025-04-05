package com.mart.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("pinfo")
public class PersonInfo {

	
	@Value("${per.id}")
	private int pid;
	@Value("${per.name}")
	private String pname;
	@Value("${per.billamt}")
	private float amt;
	@Value("hyd")//directly
	private String addrs;
	
	@Value("${os.name}")
	private String osName;
	@Override
	public String toString() {
		return "PersonInfo [pid=" + pid + ", pname=" + pname + ", amt=" + amt + ", addrs=" + addrs + ", osName="
				+ osName + "]";
	}
	
}
