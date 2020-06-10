package com.bht.humanresources.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bht.humanresources.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	

}
