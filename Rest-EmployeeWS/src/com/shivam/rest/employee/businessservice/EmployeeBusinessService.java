package com.shivam.rest.employee.businessservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.shivam.rest.employee.dao.EmployeeDAO;
import com.shivam.rest.employee.model.Employee;

@Component
public class EmployeeBusinessService  {

	private EmployeeDAO employeeDao;

	@Autowired
	public void setEmployeeDao(EmployeeDAO employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	public List<Employee> getEmployees() throws Exception{
		System.out.println("inside getEmployees business service");
		List<Employee> list=new ArrayList<Employee>();
		try{
		list=employeeDao.getEmployees();
		}catch(DataAccessException dae){
			dae.printStackTrace();
			throw new Exception();
		}
		return list;
	}
	public Employee getEmployee(int employeeNumber) throws Exception{
		Employee employee=new Employee();
		try{
			employee=employeeDao.getEmployee(employeeNumber);
		}catch(DataAccessException dae)
		{
			dae.printStackTrace();
			throw new Exception();
		}
		return employee;
	}
	
	public boolean createEmployee(Employee employee) throws Exception{
		boolean isCreated=true;
		try{
			isCreated=employeeDao.createEmployee(employee);
		}catch(DataAccessException dae)
		{
			throw new Exception(dae);
		}
		return isCreated;
	}
	
	public boolean updateEmployee(Employee employee) throws Exception{
		boolean isUpdate=true;
		try{
			isUpdate=employeeDao.updateEmployee(employee);
		}catch(DataAccessException dae)
		{
			throw new Exception();
		}
		return isUpdate;
	}
	
	public boolean deleteEmployee(int employeeNumber ) throws Exception{
		boolean isDeleted=true;
		try{
			isDeleted=employeeDao.deleteEmployee(employeeNumber);
		}catch(DataAccessException dae)
		{
			throw new Exception();
		}
		return isDeleted;
	}
	 
}
