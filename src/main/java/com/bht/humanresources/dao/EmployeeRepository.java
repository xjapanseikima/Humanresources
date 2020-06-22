package com.bht.humanresources.dao;

import com.bht.humanresources.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	Employee findByEmpid(int id);
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO employee (empid, name, job, manager,hiredate, salary, deptid) VALUES (:empid,:name,:job,:manager,:hiredate,:salary,:deptid)", nativeQuery = true)
	void newDepartment(@Param("empid") int empid, @Param("name") String name, @Param("job") String job, @Param("manager") String manager, @Param ("hiredate") String hiredate, @Param("salary") int salary,@Param("deptid") int deptid);

}
