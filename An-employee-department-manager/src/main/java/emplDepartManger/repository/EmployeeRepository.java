package emplDepartManger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import emplDepartManger.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	  @Query("SELECT e.id, e.name, d.id, d.name " +
	           "FROM Employee e " +
	           "JOIN e.departments d")
	    List<Object[]> findEmployeeAndDepartmentInfo();
	    
	    @Query("SELECT d.name, COUNT(e.id) " +
	            "FROM Employee e " +
	            "JOIN e.departments d " +
	            "GROUP BY d.name")
	     List<Object[]> countEmployeesPerDepartment();
}


