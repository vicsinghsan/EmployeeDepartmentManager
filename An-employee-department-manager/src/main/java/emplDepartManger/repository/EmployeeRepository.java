package emplDepartManger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import emplDepartManger.entity.Employee;

/**
 * @author Vivek Singh
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	List<Employee> findByDepartmentId(Long departmentId);
	
}

