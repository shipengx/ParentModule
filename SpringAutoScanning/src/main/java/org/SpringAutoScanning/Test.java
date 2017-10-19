package org.SpringAutoScanning;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shipeng.service.CustomerService;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"Spring-AutoScan.xml"});
		CustomerService customerService = (CustomerService) context.getBean("customerService");
		System.out.println(customerService);
		
	}
	
}
