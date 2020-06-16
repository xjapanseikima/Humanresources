package com.bht.humanresources.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bht.humanresources.dao.EmployeeRepository;
import com.bht.humanresources.model.Employee;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repo;
	public List<Employee> getAllDepartment() {
		return repo.findAll();
	}
	public void newDepartment(Employee employee) {
		repo.newDepartment(employee.getEmpid(),employee.getName(),employee.getJob(), employee.getManager(), employee.getSalary(),employee.getDeptid());
	}
	public void deleteEmployeeById(int id) {
		repo.deleteById(id);
	}
}
