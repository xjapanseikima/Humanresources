package com.bht.humanresources.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bht.humanresources.model.Department;
import com.bht.humanresources.service.DepartmentService;
@Controller
@RequestMapping("/Dep")
public class DeparmentController {
	@Autowired
	DepartmentService service;
	//Read 為何 不能只有 get 還要post?????
	@RequestMapping(value = "/getID", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView getDepartment(@RequestParam(value = "deptid")  int id) {
		ModelAndView mv = new ModelAndView("index");
		System.out.println( service.getDepartmentById(id).getName());
		mv.addObject("department", service.getDepartmentById(id));
		return mv;
	}
	//CreateDepartment 和 create 到底可不可以合併呢？？？？？傻眼... 煩
	@GetMapping("/createdepartment")
	public ModelAndView redriectCreate() {
		// 搞很久就是 幹這裡出大事！
		ModelAndView mv = new ModelAndView("createDepartment");
		mv.addObject(new Department());
	    return mv;
	}
	//幹幹幹 因為不會ｊs 想要用 點擊 row的方式 delete 
	@GetMapping("/deletedepartment")
	public ModelAndView redriectDelete(Model model) {
		ModelAndView mv = new ModelAndView("deleteDepartment");
		mv.addObject(new Department());
	    return mv;
	}
	//操他媽拿到所有資料喔喔喔喔喔喔喔
	@GetMapping("/getAll")
	public ModelAndView getAllDepartment() { 
		List <Department> department= service.getAllDepartment();
		ModelAndView modelAndView = new ModelAndView("index");
	    modelAndView.addObject("department", department);
		return modelAndView;
	}
	//Create
	@PostMapping("/create")
	public String newDepartment(@ModelAttribute Department department){
		service.newDepartment(department);
        return "index";
	}
	//Delete 
	//感覺可以用  getmapping 拿到參數再去 delete???????
	// 網頁讀取不能直接post???????
	@DeleteMapping("/delete")
	public String deleteDepartment(@ModelAttribute Department department){
//		System.out.print(deptid);
//		service.deleteDepartmentById(deptid);
        return "index";
	}
	//Update
} 



