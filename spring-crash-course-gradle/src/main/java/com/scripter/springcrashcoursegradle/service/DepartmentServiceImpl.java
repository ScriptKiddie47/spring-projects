package com.scripter.springcrashcoursegradle.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.scripter.springcrashcoursegradle.entity.Department;
import com.scripter.springcrashcoursegradle.exception.DepartmentNotFoundException;
import com.scripter.springcrashcoursegradle.repo.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRepository departmentRepository;

	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}

	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> fetchDepartmentList() {
		return departmentRepository.findAll();
	}

	@Override
	public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
		return departmentRepository.findById(departmentId)
				.orElseThrow((() -> new DepartmentNotFoundException("Department is not available")));
	}

	@Override
	public void deleteDepartmentById(Long departmentId) {
		departmentRepository.deleteById(departmentId);
	}

	@Override
	public Department updateDepartment(Department department, Long departmentId) {
		Department fromDb = departmentRepository.findById(departmentId).get();
		if (Objects.nonNull(department.getDepartmentName()) && !department.getDepartmentName().isEmpty())
			fromDb.setDepartmentName(department.getDepartmentName());
		// We can do this for other Attributes , I am gonna skip it ( Better to use
		// Spring Validations )
		fromDb.setDepartmentAddress(department.getDepartmentAddress());
		fromDb.setDepartmentCode(department.getDepartmentCode());
		return departmentRepository.save(fromDb);
	}

	@Override
	public Department fetchDepartmentByName(String name) {
		return departmentRepository.findByDepartmentNameIgnoreCase(name);
	}
}
