/**
 * 
 */
package emplDepartManger.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Vivek Singh
 *
 */
@Data
@AllArgsConstructor
public class EmployeeCountPerDepartmentDTO {
	
	private String departmentName;
    private Long employeeCount;

   

}
