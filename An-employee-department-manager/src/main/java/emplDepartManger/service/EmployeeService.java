/**
 * 
 */
package emplDepartManger.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emplDepartManger.entity.Employee;
import emplDepartManger.repository.EmployeeRepository;

/**
 * @author Vivek Singh
 *
 */
@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	
	
	public Employee SaveEmployee(Employee employee) {
		employee.setCreatedAt(new Date());
		return employeeRepository.save(employee);
		
	}
	
	 public List<Employee> getAllEmployees() {
	        return employeeRepository.findAll();
	    }
	 
	 public Optional<Employee> getEmployeeById(Long id) {
	        return employeeRepository.findById(id);
	    }
	 
	 public List<Employee> getEmployeesByDepartmentId(Long departmentId) {
	        return employeeRepository.findByDepartmentId(departmentId);
	    }

}
