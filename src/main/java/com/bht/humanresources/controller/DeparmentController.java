package com.bht.humanresources.controller;

import com.bht.humanresources.model.Department;
import com.bht.humanresources.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
@RequestMapping("/Dep")
public class DeparmentController {
	@Autowired
	DepartmentService service;
	//CreateDepartment 和 create 到底可不可以合併呢？？？？？傻眼... 煩
	@GetMapping("/createdepartment")
	public ModelAndView redriectCreate() {
		// 搞很久就是 幹這裡出大事！
		ModelAndView mv = new ModelAndView("CreateDepartment");
		mv.addObject(new Department());
	    return mv;
	}
	//幹幹幹 因為不會ｊs 想要用 點擊 row的方式 delete 
	@GetMapping("/DeleteDepartment")
	public ModelAndView redriectDelete(Model model) {
		ModelAndView mv = new ModelAndView("DeleteDepartment");
		mv.addObject(new Department());
	    return mv;
	}
	//操他媽拿到所有資料喔喔喔喔喔喔喔
	//每個 request 完 都重新回get all那裡
	@GetMapping("/getAll")
	public ModelAndView getAllDepartment() { 
		List <Department> department= service.getAllDepartment();
		ModelAndView modelAndView = new ModelAndView("index");
	    modelAndView.addObject("department", department);
		return modelAndView;
	}
	//Create
	@PostMapping("/create")
	public ModelAndView newDepartment(@ModelAttribute Department department){
		service.newDepartment(department);
        return getAllDepartment();
	}
	/**Delete 
	 * /
	 * 操雞巴勒........ 竟然是因為這樣
	 * https://blog.csdn.net/weixin_43570367/article/details/103751142?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.nonecase
	 * @param department
	 * @return
	 */
	@DeleteMapping("/delete")
	public ModelAndView  deleteDepartment( @ModelAttribute Department department){
		service.deleteDepartmentById(department.getDeptid());
        return  getAllDepartment();
	}
	//Update
	@PutMapping("/update")
	public ModelAndView updateDepartment( @ModelAttribute Department department){
		System.out.println(department.getDeptid());
		service.updateDepartment( department);
        return getAllDepartment();
	}
} 



