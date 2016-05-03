package com.shivam.rest.employee.service;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.shivam.rest.employee.businessservice.EmployeeBusinessService;
import com.shivam.rest.employee.model.Employee;
import com.shivam.rest.employee.model.EmployeeList;
@Produces({"application/xml","application/json"})
public class EmployeeServiceImpl {
	private EmployeeBusinessService employeeBusinessService;
	@Autowired
	public void setEmployeeBusinessService(EmployeeBusinessService employeeBusinessService) {
		this.employeeBusinessService = employeeBusinessService;
	}
	
	@GET
	@Path("/employees/")
	public EmployeeList getEmployees(){
		EmployeeList employees = new EmployeeList();
		try{
			employees.setEmployee(employeeBusinessService.getEmployees());
		}catch(Exception e){
			e.printStackTrace();
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return employees;

	}
	@GET
	@Path(("/employee/{id}/"))
	public Employee getEmployee(@PathParam("id") int employeeNumber){
		System.out.println("jhello"+employeeNumber);
		Employee employee = new Employee();
		try{
			employee=employeeBusinessService.getEmployee(employeeNumber);
		}catch(Exception e){
			e.printStackTrace();
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		if(employee.getEmployeeNumber()==0){
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return employee;
	}
	@POST
	@Path(("/employee/"))
	public Response createEmployee(Employee employee){
		boolean isCreated=false;
		Response response;
		try{
			isCreated=employeeBusinessService.createEmployee(employee);
			response=Response.ok().build();
		}catch(Exception e){
			e.printStackTrace();
			throw new NotFoundException();
		}
		if(!isCreated){
			throw new NotFoundException();
		}
		return response;
		
	}
	@PUT
	@Path(("/employee/"))
	public Response updateEmployee(Employee employee){
		boolean isUpdated=false;
		Response response;
		try{
			isUpdated=employeeBusinessService.updateEmployee(employee);
			response=Response.ok().build();
		}catch(Exception e){
			throw new NotFoundException();
		}
		if(!isUpdated){
			throw new NotFoundException();
		}
		return response;
	}
	@DELETE
	@Path(("/employee/{id}/"))
	public Response deleteEmployee(@PathParam("id") int employeeNumber){
		
		boolean isDeleted=false;
		Response response;
		try{
			isDeleted=employeeBusinessService.deleteEmployee(employeeNumber);
			response=Response.ok().build();
		}catch(Exception e){
			throw new NotFoundException();
		}
		if(!isDeleted){
			throw new NotFoundException();
		}
		return response;
	}
}
