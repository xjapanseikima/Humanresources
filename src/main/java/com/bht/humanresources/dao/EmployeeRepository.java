package com.bht.humanresources.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bht.humanresources.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO employee (empid, name, job, manager, salary, deptid) VALUES (:empid,:name,:job,:manager,:salary,:deptid)", nativeQuery = true)
	void newDepartment(@Param("empid") int empid, @Param("name") String name, @Param("job") String job, @Param("manager") String manager,@Param("salary") int salary,@Param("deptid") int deptid);

}
