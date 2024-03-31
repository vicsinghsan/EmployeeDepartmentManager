/**
 * 
 */
package emplDepartManger.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emplDepartManger.entity.Department;
import emplDepartManger.entity.EmployeeCountPerDepartmentDTO;
import emplDepartManger.exception.ResourceNotFound;
import emplDepartManger.repository.DepartmentRepository;

/**
 * @author Vivek Singh
 *
 */
@Service
public class DepartmentService {
	@Autowired
	DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		department.setCreatedAt(new Date());
		return departmentRepository.save(department);
	}

	public List<Department> getDepartments() {
		return departmentRepository.findAll();
	}

	public Department getDepartmentById(Long id) {
		return departmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFound("department with given id is not found " + id));
	}
	
	public List<EmployeeCountPerDepartmentDTO> getEmployeeCountPerDepartment() {
        List<Object[]> results = departmentRepository.getEmployeeCountPerDepartment();
        return results.stream()
                .map(obj -> new EmployeeCountPerDepartmentDTO((String) obj[0], (Long) obj[1]))
                .collect(Collectors.toList());
    }

}
