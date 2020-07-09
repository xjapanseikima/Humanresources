package com.bht.humanresources.controller;

import com.bht.humanresources.service.DepartmentService;
import com.bht.humanresources.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("index")
public class IndexController {
	@Autowired
	DepartmentService dep_service;
	@Autowired
	EmployeeService  emp_service;
	//Read 為何 不能只有 get 還要post?????
	@RequestMapping(value = "/getID", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView getDepartment(@RequestParam(value = "ID")  int id) {
		if(dep_service.getDepartmentById(id)== null && emp_service.getEmployeeById(id)==null){
			ModelAndView mv = new ModelAndView("404page");
			return mv;
		}else if(emp_service.getEmployeeById(id)!=null){
			ModelAndView mv = new ModelAndView("index");
			mv.addObject("employee", emp_service.getEmployeeById(id));
			return mv;
		}
		else{
			ModelAndView mv = new ModelAndView("index");
			mv.addObject("department", dep_service.getDepartmentById(id));
			return mv;
		}
	}
	@GetMapping("")
	public String defaultDetail() {
	    return "index";
	}
	@GetMapping("/login")
	public String Login() {
		return "login";
	}
}
