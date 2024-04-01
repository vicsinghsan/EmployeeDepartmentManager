/**
 * 
 */
package emplDepartManger.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Vivek Singh
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeCountPerDepartmentDTO {
	
	 
	 private Long employeeID;
	    private String employeeName;
	    private Long departmentID;
	    private String departmentName;

}
