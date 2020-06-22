package com.bht.humanresources.service;

import com.bht.humanresources.dao.EmployeeRepository;
import com.bht.humanresources.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repo;
	public List<Employee> getAllEmployee() {
		return repo.findAll();
	}
	public Employee getEmployeeById(int id) {
		return repo.findByEmpid(id);
	}
	public void newEmployee(Employee employee) {
		repo.newDepartment(employee.getEmpid(),employee.getName(),employee.getJob(), employee.getManager(), employee.getHiredate(),employee.getSalary(),employee.getDeptid());
	}
	public void deleteEmployeeById(int id) {
		repo.deleteById(id);
	}
}
