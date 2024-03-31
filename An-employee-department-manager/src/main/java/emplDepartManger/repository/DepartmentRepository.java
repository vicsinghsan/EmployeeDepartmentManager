package emplDepartManger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import emplDepartManger.entity.Department;


/**
 * @author Vivek Singh
 *
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	  @Query("SELECT d.name, COUNT(e) FROM Department d JOIN d.employees e GROUP BY d.name")
	    List<Object[]> getEmployeeCountPerDepartment();
}
