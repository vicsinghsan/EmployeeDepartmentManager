package emplDepartManger.payload;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author Vivek Singh
 *
 */

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
	
	public String message;
	public boolean sucess;
	public HttpStatus status;
	
	
	
	

}
