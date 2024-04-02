/**
 * 
 */
package emplDepartManger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emplDepartManger.entity.Department;
import emplDepartManger.entity.Employee;
import emplDepartManger.entity.EmployeeCountPerDepartmentDTO;
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
	 
	 
	 public List<EmployeeCountPerDepartmentDTO> findEmployeeAndDepartmentInfo() {
	        List<Object[]> resultList = employeeRepository.findEmployeeAndDepartmentInfo();
	        return mapToObject(resultList);
	    }
	 
	 private List<EmployeeCountPerDepartmentDTO> mapToObject(List<Object[]> resultList) {
		    return resultList.stream()
		            .map(obj -> new EmployeeCountPerDepartmentDTO(
		                    Long.valueOf(obj[0].toString()),
		                    obj[1].toString(), 
		                    Long.valueOf(obj[2].toString()), 
		                    obj[3].toString())) 
		            .collect(Collectors.toList());
		}
	 
	 public List<Object[]> getEmployeesPerDepartment() {
	        return employeeRepository.countEmployeesPerDepartment();
	    }


}
