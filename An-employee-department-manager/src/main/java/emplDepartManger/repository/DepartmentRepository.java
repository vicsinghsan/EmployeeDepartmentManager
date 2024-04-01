package emplDepartManger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import emplDepartManger.entity.Department;


/**
 * @author Vivek Singh
 *
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
