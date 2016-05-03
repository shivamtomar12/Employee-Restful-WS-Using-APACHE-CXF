package com.shivam.rest.employee.dao;

public class SQL {
public static final String GETEMPLOYEES = "select * from employees";
public static final String GETEMPLOYEE = "select * from employees e where e.employeeNumber= :employeeNumber";
public static final String INSERTEMPLOYEE ="insert  into `employees`(`employeeNumber`,`lastName`,`firstName`,`extension`,`email`,`officeCode`,`reportsTo`,`jobTitle`) "
		+ "values (:employeeNumber,:lastName,:firstName,:extension,:email,:officeCode,:reportsTo,:jobTitle)";
public static final String UPDATEMPLOYEE="update employees set lastName=:lastName where employeeNumber= :employeeNumber";
public static final String DELETEEMPLOYEE="delete from employees where employeeNumber=:employeeNumber";

}
