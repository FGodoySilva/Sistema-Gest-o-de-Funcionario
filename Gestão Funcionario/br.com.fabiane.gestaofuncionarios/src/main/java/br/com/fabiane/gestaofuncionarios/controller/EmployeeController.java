package br.com.fabiane.gestaofuncionarios.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.fabiane.gestaofuncionarios.model.Employee;
import br.com.fabiane.gestaofuncionarios.service.EmployeeService;


/**
 * 
 * @author fabianeGodoy
 *
 */


@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	//Display list off de employees
	private String update_employee;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees", employeeService.getAllEmployess());
		return "index";
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}

	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee")Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/";
		
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		Employee employee = employeeService.getEmployeeById(id);
		
		model.addAttribute("employee", employee);
		return "update_employee";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value = "id")long id, Model model) {
		
		this.employeeService.deleteEmployeeById(id);	
		return "redirect:/";
	}

}
