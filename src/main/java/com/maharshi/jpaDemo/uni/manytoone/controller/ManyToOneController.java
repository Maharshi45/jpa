package com.maharshi.jpaDemo.uni.manytoone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maharshi.jpaDemo.uni.manytoone.model.Employee;
import com.maharshi.jpaDemo.uni.manytoone.model.Employer;
import com.maharshi.jpaDemo.uni.manytoone.repository.EmployeeRepository;
import com.maharshi.jpaDemo.uni.manytoone.repository.EmployerRepository;

@RestController
@RequestMapping("/employee")
public class ManyToOneController {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private EmployerRepository employerRepository;

	@PostMapping("")
	public Employee createEmployee(@RequestBody Employee employee) {
		Employer employer = employee.getEmployer();
		employer = employerRepository.save(employer);
		employee.setEmployer(employer);
		return employeeRepository.save(employee);
	}

	@GetMapping("")
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	@PutMapping("/{id}")
	public Employee addEmployeeToEmployer(@PathVariable("id") int id, @RequestBody Employee employee) {
		Employer employer = employerRepository.findById(id).get();
		employee.setEmployer(employer);
		return employeeRepository.save(employee);
	}

}
