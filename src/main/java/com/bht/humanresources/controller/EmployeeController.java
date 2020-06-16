package com.bht.humanresources.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bht.humanresources.model.Employee;
import com.bht.humanresources.service.EmployeeService;

@Controller
@RequestMapping("/Emp")
public class EmployeeController {
	@Autowired
	EmployeeService service;
	@GetMapping("/getAll")
	public ModelAndView getAllEmployee() {
		List<Employee> employee= service.getAllDepartment();
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("employee", employee);
		return mv;
	}
	@GetMapping("/createemployee")
	public ModelAndView redriectCreate() {
		ModelAndView mv = new ModelAndView("CreateEmployee");
		mv.addObject(new Employee());
	    return mv;
	}
	@PostMapping("/create")
	public ModelAndView newEmployee(@ModelAttribute Employee employee){
		service.newDepartment(employee);
        return getAllEmployee();
	}
	@DeleteMapping("/delete")
	public ModelAndView deleteEmployeeById(@ModelAttribute Employee employee){
		service.deleteEmployeeById(employee.getEmpid());
        return getAllEmployee() ;
	}
}
