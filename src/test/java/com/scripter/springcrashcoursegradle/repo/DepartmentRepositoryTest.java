package com.scripter.springcrashcoursegradle.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.scripter.springcrashcoursegradle.entity.Department;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DepartmentRepositoryTest {

	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private TestEntityManager entityManager;
	private Department department;

	@BeforeEach
	void setUp() throws Exception {
		department = new Department();
		department.setDepartmentName("MECH");
		department.setDepartmentCode("KOL-29");
		department.setDepartmentAddress("Kolkata");
		entityManager.persist(department);
	}

	@Test
	@Disabled
	public void findByIdTest() {
		Department department = departmentRepository.findById(1L).get();
		System.out.println(department.toString());
		assertEquals(department.getDepartmentName(), "MECH");
	}

}
