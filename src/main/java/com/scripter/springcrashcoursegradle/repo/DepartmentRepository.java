package com.scripter.springcrashcoursegradle.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scripter.springcrashcoursegradle.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	public Department findByDepartmentName(String departmentName); // We are Creating this method here by carefully utilizing the attributes.
	public Department findByDepartmentNameIgnoreCase(String departmentName);
}
