package br.com.fabiane.gestaofuncionarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fabiane.gestaofuncionarios.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
