package com.scripter.springcrashcoursegradle.service;

import java.util.List;

import com.scripter.springcrashcoursegradle.entity.Department;
import com.scripter.springcrashcoursegradle.exception.DepartmentNotFoundException;

public interface DepartmentService {

	public Department saveDepartment(Department department);
	public List<Department> fetchDepartmentList();
	public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;
	public void deleteDepartmentById(Long departmentId);
	public Department updateDepartment(Department department, Long departmentId);
	public Department fetchDepartmentByName(String name);

}
