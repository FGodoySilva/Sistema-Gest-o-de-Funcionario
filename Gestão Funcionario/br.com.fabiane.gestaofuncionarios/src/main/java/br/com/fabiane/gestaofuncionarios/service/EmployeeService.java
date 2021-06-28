package br.com.fabiane.gestaofuncionarios.service;

import java.util.List;

import br.com.fabiane.gestaofuncionarios.model.Employee;

/**
 * 
 * @author fabianeGodoy
 *
 */
public interface EmployeeService {
	List<Employee> getAllEmployess();
	
	void saveEmployee(Employee employee);
	Employee getEmployeeById(long Id);
	
	void deleteEmployeeById(long id);
	
}
