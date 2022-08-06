package com.scripter.springcrashcoursegradle.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.scripter.springcrashcoursegradle.entity.Department;
import com.scripter.springcrashcoursegradle.repo.DepartmentRepository;

@SpringBootTest
class DepartmentServiceTest {

	@Autowired
	private DepartmentService departmentService;
	@MockBean
	private DepartmentRepository departmentRepository;

	private Department department;

	@BeforeEach
	void setUp() {
		department = new Department(1L, "IT", "Bengaluru", "IT-06");
	}

	@DisplayName("Fetch data based on valid dept name")
	@Test
	public void fetchDepartmentByNamewithValidName() {
		String depatmentName = "IT";
		Mockito.when(departmentService.fetchDepartmentByName(depatmentName)).thenReturn(department);
		Department found = departmentService.fetchDepartmentByName(depatmentName);
		assertEquals(depatmentName, found.getDepartmentName());
	}
}
