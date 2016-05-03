package com.shivam.rest.employee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.shivam.rest.employee.model.Employee;

@Component("employeedao")
public class EmployeeDAOImpl implements EmployeeDAO {

	private NamedParameterJdbcTemplate jdbc;
	@Autowired
	public void setDataSource(DataSource jdbc){
		this.jdbc=new NamedParameterJdbcTemplate(jdbc);
	}
	

	@Override
	public List<Employee> getEmployees() {
		System.out.println("inside getEmployees dao ");
		return jdbc.query(SQL.GETEMPLOYEES, new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee employee=new Employee();
				employee.setEmployeeNumber(rs.getInt("employeeNumber"));
				employee.setLastName(rs.getString("lastName"));
				employee.setFirstName(rs.getString("firstName"));
				employee.setExtension(rs.getString("extension"));
				employee.setEmail(rs.getString("email"));
				employee.setOfficeCode(rs.getString("officeCode"));
				employee.setReportsTo(rs.getInt("reportsTo"));
				employee.setJobTitle(rs.getString("jobTitle"));
				
				return employee;
			}
		});
		
	}

	@Override
	public Employee getEmployee(int employeeNumber) {
		MapSqlParameterSource params=new MapSqlParameterSource();
		params.addValue("employeeNumber", employeeNumber);
		return (Employee) jdbc.queryForObject(SQL.GETEMPLOYEE ,params ,new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee employee=new Employee();
				employee.setEmployeeNumber(rs.getInt("employeeNumber"));
				employee.setLastName(rs.getString("lastName"));
				employee.setFirstName(rs.getString("firstName"));
				employee.setExtension(rs.getString("extension"));
				employee.setEmail(rs.getString("email"));
				employee.setOfficeCode(rs.getString("officeCode"));
				employee.setReportsTo(rs.getInt("reportsTo"));
				employee.setJobTitle(rs.getString("jobTitle"));
				return employee;
			}
		});
		
	}

	@Override
	public boolean createEmployee(Employee employee) {
		BeanPropertySqlParameterSource param=new BeanPropertySqlParameterSource(employee);
		return jdbc.update(SQL.INSERTEMPLOYEE,param)==1;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		MapSqlParameterSource params=new MapSqlParameterSource();
		params.addValue("employeeNumber", employee.getEmployeeNumber());
		params.addValue("lastName", employee.getLastName());
		
		
		return jdbc.update(SQL.UPDATEMPLOYEE, params)==1;
	}

	@Override
	public boolean deleteEmployee(int employeeNumber) {
		MapSqlParameterSource params=new MapSqlParameterSource();
		params.addValue("employeeNumber",employeeNumber);
		
		return jdbc.update(SQL.DELETEEMPLOYEE, params)==1;
	}

}
