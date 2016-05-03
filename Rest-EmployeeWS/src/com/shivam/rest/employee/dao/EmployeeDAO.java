package com.shivam.rest.employee.dao;

import java.util.List;

import com.shivam.rest.employee.model.Employee;

public interface EmployeeDAO {
	public List<Employee> getEmployees();
	public Employee getEmployee(int employeeNumber);
	public boolean createEmployee(Employee employee);
	public boolean updateEmployee(Employee employee);
	public boolean deleteEmployee(int employeeNumber);
}
