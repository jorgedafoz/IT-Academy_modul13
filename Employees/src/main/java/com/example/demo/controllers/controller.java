package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.exceptions.RecordNotFoundException;
import com.example.demo.models.EmployeeEntity;
import com.example.demo.services.EmployeesService;

@Controller    //lo convertimos en un servlet atiende peticiones http
@RequestMapping("/")
public class controller {
	
	@Autowired
	EmployeesService service;
	
	@RequestMapping("/")
    public String getAllEmployees (Model model) {
		System.out.print("getAllEmployees");
	    List<EmployeeEntity> list = service.getAllEmployees();
	    model.addAttribute ("employees", list);
	    return "index";
   }
	
	//get employee by id
	@GetMapping("/{id}")
	public String findEmployeeById(Model model, Long id) throws RecordNotFoundException {
		
		System.out.print("findEmployeeById" + id);
		model.addAttribute("employee", service.getEmployeeById(id));
		return "Employees list";
	}
	
	//update employee by id
	@RequestMapping(path = {"/edit", "/edit/{id}"})
	public String editEmployeeById(Model model, @PathVariable("id") Optional<Long> id) throws RecordNotFoundException {
		
		System.out.println("editEmployeeById" + id);
		if (id.isPresent()) {
			EmployeeEntity entity = service.getEmployeeById(id.get());
			model.addAttribute ("employee", entity);
		} else {
			model.addAttribute("employee", new EmployeeEntity());
		}
		return "add or edit employee";
	}
	
	//deteles employee by id
	@RequestMapping(path = "/delete/{id}") 
	public String deleteEmployeeById (Model model, @PathVariable("id") Long id) throws RecordNotFoundException {
	
		System.out.print("deleteEmployeeById" + id);
		service.deleteEmployeeById(id);
		return "redirect:/";
		
	}
	
	//create/update employee
	@RequestMapping(path="/createEmployee", method = RequestMethod.POST)
	public String createOrUpdateEmployee (EmployeeEntity employee) {
		
		System.out.print("createOrUpdateEmployee");
		service.createOrUpdateEmployee(employee);
		return "redirect:/";
	}
	
	//Finds all employees by job 
	@GetMapping ("/findEmployeesByJob")
	public String findEmployeesByJob (Model model, String job) {
		if (job != null) {
			model.addAttribute("employee", service.findEmployeesByjob(job));
		} else {
			model.addAttribute("employee", service.getAllEmployees());
		}
		return "Employees list";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
