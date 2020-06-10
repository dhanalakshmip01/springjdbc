package com.springJdbc.springbootjdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springJdbc.springbootjdbc.modal.Employee;
import com.springJdbc.springbootjdbc.service.EmployeeService;

@RestController
@RequestMapping(path="/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;

	@GetMapping
	public String test() {
		return "welcome world";
	}
	
	@GetMapping("/getallemps")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(),HttpStatus.OK);
		
	}
	
	@GetMapping("/getempbyid/{id}")
	 public ResponseEntity<Employee> findeEmployeeById(@PathVariable int id) {
		return new ResponseEntity<Employee>(employeeService.findeEmployeeById(id),HttpStatus.OK);
	}
	
	@PostMapping("/addemp")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<String>(employeeService.addEmployee(employee),HttpStatus.OK);
	}
	
	@PutMapping("/updateemp")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee){
		return new ResponseEntity<String>(employeeService.updateEmployee(employee),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id){
		return new ResponseEntity<String>(employeeService.deleteEmployee(id),HttpStatus.OK);
	}
}
