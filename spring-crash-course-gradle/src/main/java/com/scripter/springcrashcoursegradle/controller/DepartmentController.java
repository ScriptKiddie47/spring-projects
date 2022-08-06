package com.scripter.springcrashcoursegradle.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.scripter.springcrashcoursegradle.entity.Department;
import com.scripter.springcrashcoursegradle.exception.DepartmentNotFoundException;
import com.scripter.springcrashcoursegradle.service.DepartmentService;

@RestController
public class DepartmentController {
	
	
	private static final Logger log = LoggerFactory.getLogger(DepartmentController.class);


	private DepartmentService departmentService;

	public DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		log.info("Request : " + department );
		 return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/departments")
	public List<Department> fetchDepartments(){
		return departmentService.fetchDepartmentList();
	}
	
	@GetMapping("/departments/{id}")
	public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
		return departmentService.fetchDepartmentById(departmentId);
	}
	
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
		departmentService.deleteDepartmentById(departmentId);
		return "Department Deleted Successfully!";
	}
	
	@PutMapping("/departments/{id}")
	public Department updateDepartment(@RequestBody Department department,@PathVariable("id") Long departmentId) {
		return departmentService.updateDepartment(department,departmentId);
	}
	
	@GetMapping("/departments/name/{name}")
	public Department fetchDepartmentByName(@PathVariable(value = "name") String name) {
		return departmentService.fetchDepartmentByName(name);
	}
}
