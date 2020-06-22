package com.bht.humanresources.controller;

import com.bht.humanresources.model.Employee;
import com.bht.humanresources.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/Emp")
public class EmployeeController {
	@Autowired
	EmployeeService service;
	@GetMapping("/getAll")
	public ModelAndView getAllEmployee() {
		List<Employee> employee= service.getAllEmployee();
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
		service.newEmployee(employee);
        return getAllEmployee();
	}
	@DeleteMapping("/delete")
	public ModelAndView deleteEmployeeById(@ModelAttribute Employee employee){
		service.deleteEmployeeById(employee.getEmpid());
        return getAllEmployee() ;
	}
}
