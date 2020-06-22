package com.bht.humanresources.dao;

import com.bht.humanresources.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    Department findBydeptid (int deptName);
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO department (deptid, name, loc) VALUES (:deptid,:name,:loc)", nativeQuery = true)
	void newDepartment(@Param("deptid") int deptid, @Param("name") String name,@Param("loc") String loc);
    @Modifying
    @Transactional
    @Query(value = "UPDATE Department dept set dept.name= :name,dept.loc= :loc WHERE dept.deptid=:deptid", nativeQuery = true)
    void updateDepartment(@Param("deptid") int deptid, @Param("name") String name,@Param("loc") String loc);
}
