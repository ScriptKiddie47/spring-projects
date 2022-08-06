package com.scripter.springcrashcoursegradle.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.scripter.springcrashcoursegradle.entity.Department;
import com.scripter.springcrashcoursegradle.service.DepartmentService;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private DepartmentService departmentService;

	private Department department;

	@BeforeEach
	void setUp() {
		department = new Department(1L, "IT", "Bengaluru", "IT-06");
	}
	
	@Test
	void saveDepartmentTest() throws Exception {
		Department inputDepartment =  new Department();
		inputDepartment.setDepartmentName("IT");
		inputDepartment.setDepartmentCode("IT-06");
		inputDepartment.setDepartmentAddress("Bengaluru");
		
		Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);
		mockMvc.perform(MockMvcRequestBuilders.post("/departments").contentType(MediaType.APPLICATION_JSON)
				.content("{\r\n"
						+ "    \"departmentName\": \"IT\",\r\n"
						+ "    \"departmentAddress\": \"Bengaluru\",\r\n"
						+ "    \"departmentCode\": \"IT-06\"\r\n"
						+ "}")).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	void fetchDepartmentByIdTest() throws Exception {
		Mockito.when(departmentService.fetchDepartmentById(1L)).thenReturn(department);
		mockMvc.perform(MockMvcRequestBuilders
				.get("/departments/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.departmentName").value(department.getDepartmentName()));
	}
}
