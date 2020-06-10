package com.springJdbc.springbootjdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springJdbc.springbootjdbc.modal.Employee;
import com.springJdbc.springbootjdbc.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees() {
		return employeeRepository.getAllEmployees();
	}
	
	 public Employee findeEmployeeById(int id) {
		 return employeeRepository.findeEmployeeById(id);
	 }
	 
	 public String addEmployee(Employee employee) {
		 return  employeeRepository.addEmployee(employee);
		
	 }
	 
	 public String updateEmployee(Employee employee) {
		 return employeeRepository.updateEmployee(employee);
	 }
	 
	 public String deleteEmployee(int id) {
		 return employeeRepository.deleteEmployee(id);
	 }
}
