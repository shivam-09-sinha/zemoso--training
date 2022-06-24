package com.luv2code.springsecurity.demo.controller;

import com.luv2code.springsecurity.demo.model.Teams;
import com.luv2code.springsecurity.demo.repository.TeamsRepository;
import com.luv2code.springsecurity.demo.service.TeamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TeamsController {

	@Autowired
	private TeamsService teamservice;
	
	// display list of employees
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		// create model attribute to bind form data
		Teams teams = new Teams();
		model.addAttribute("teams", teams);
		return "new_teams";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("teams") Teams teams) {
		// save employee to database
		teamservice.saveTeams(teams);
		return "redirect:/";
	}
	
//	@GetMapping("/showFormForUpdate/{id}")
//	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
//
//		// get employee from the service
//		Employee employee = employeeService.getEmployeeById(id);
//
//		// set employee as a model attribute to pre-populate the form
//		model.addAttribute("employee", employee);
//		return "update_employee";
//	}
//
//	@GetMapping("/deleteEmployee/{id}")
//	public String deleteEmployee(@PathVariable (value = "id") long id) {
//
//		// call delete employee method
//		this.employeeService.deleteEmployeeById(id);
//		return "redirect:/";
//	}
//
//
//	@GetMapping("/page/{pageNo}")
//	public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
//			@RequestParam("sortField") String sortField,
//			@RequestParam("sortDir") String sortDir,
//			Model model) {
//		int pageSize = 5;
//
//		Page<Employee> page = employeeService.findPaginated(pageNo, pageSize, sortField, sortDir);
//		List<Employee> listEmployees = page.getContent();
//
//		model.addAttribute("currentPage", pageNo);
//		model.addAttribute("totalPages", page.getTotalPages());
//		model.addAttribute("totalItems", page.getTotalElements());
//
//		model.addAttribute("sortField", sortField);
//		model.addAttribute("sortDir", sortDir);
//		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
//
//		model.addAttribute("listEmployees", listEmployees);
//		return "index";
//	}
}
