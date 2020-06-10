package com.springJdbc.springbootjdbc.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springJdbc.springbootjdbc.modal.Employee;
import com.springJdbc.springbootjdbc.modal.EmployeeRowMapper;

@Repository
@PropertySource(value= {"classpath:Queries.properties"})
public class EmployeeRepository {

	@Autowired
	private Environment env;
	 @Autowired
	 private JdbcTemplate jdbcTemplate;

	 public List<Employee> getAllEmployees() {
		  RowMapper<Employee> rowMapper = new EmployeeRowMapper();
		  List<Employee> list = jdbcTemplate.query(env.getProperty("FETCH_ALL_EMP"), rowMapper);		  
		  return list;
	 }
	 
	 public Employee findeEmployeeById(int id) {
		  RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
		  Employee employee = jdbcTemplate.queryForObject(env.getProperty("FETCH_EMP_BY_ID"), rowMapper, id);		  
		  return employee;
	 }
	 
	 public String addEmployee(Employee employee) {
		  jdbcTemplate.update(env.getProperty("ADD_EMP"), employee.getEmpId(), employee.getFirstName(), employee.getLastName());
		return "employee saved Succesfully";
		  
	 }
	 
	 public String updateEmployee(Employee employee) {
		  jdbcTemplate.update(env.getProperty("UPDATE_EMP"), employee.getEmpId(), employee.getFirstName(), employee.getLastName() );
		  return "updated successfully";
	 }
	 
	 public String deleteEmployee(int id) {
		  jdbcTemplate.update(env.getProperty("DELETE_EMP"), id);
		  return "deleted successfully";
	 }
}
