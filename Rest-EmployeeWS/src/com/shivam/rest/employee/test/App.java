package com.shivam.rest.employee.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shivam.rest.employee.dao.EmployeeDAO;

public class App {
	
	
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("com/shivam/rest/employee/context/dao-context.xml");
		
		EmployeeDAO employeedao=(EmployeeDAO) context.getBean("employeedao");
		System.out.println(employeedao.getEmployee(1002));
		
		((ClassPathXmlApplicationContext)context).close();
	}

}
