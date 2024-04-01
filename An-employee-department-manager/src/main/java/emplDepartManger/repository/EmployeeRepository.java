package emplDepartManger.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import emplDepartManger.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	  @Query("SELECT e.id, e.name, d.id, d.name " +
	           "FROM Employee e " +
	           "JOIN e.departments d")
	    List<Object[]> findEmployeeAndDepartmentInfo();
}


