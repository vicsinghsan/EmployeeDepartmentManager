package emplDepartManger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import emplDepartManger.entity.Department;
import emplDepartManger.entity.Employee;
import emplDepartManger.entity.EmployeeCountPerDepartmentDTO;
import emplDepartManger.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
    EmployeeService employeeService;

  

    // Create an employee
    @PostMapping("/")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.SaveEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Get all employees
    @GetMapping("/")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    // Get an employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id)
                .map(employee -> new ResponseEntity<>(employee, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
	
    @GetMapping("/employee-departments-info")
    public List<EmployeeCountPerDepartmentDTO> getEmployeeAndDepartmentInfo() {
        return employeeService.findEmployeeAndDepartmentInfo();
    }
    
    @GetMapping("/employees-per-department")
    public List<Object[]> getEmployeesPerDepartment() {
        return employeeService.getEmployeesPerDepartment();
    }
    
    
    }
	 
    
    

    

