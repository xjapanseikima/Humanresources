package com.bht.humanresources.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bht.humanresources.dao.DepartmentRepository;
import com.bht.humanresources.model.Department;
@Service
public class DepartmentService {

	@Autowired 
    private DepartmentRepository repo;
	
	public Department getDepartmentById(int id) {
        return repo.findBydeptid(id);
    }
    public List<Department> getAllDepartment() {
        return repo.findAll();
    }
	public void newDepartment(Department department) {
		repo.newDepartment(department.getDeptid(),department.getName(),department.getLoc());
	}
	public void deleteDepartmentById(int id) {
        repo.deleteById(id);
	}
}
