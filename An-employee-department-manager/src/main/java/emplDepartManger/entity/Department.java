/**
 * 
 */
package emplDepartManger.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Vivek Singh
 *
 */



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department extends Auditable {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;

	    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	    @JsonManagedReference // Breaks infinite recursion
	    private List<Employee> employees;
}


