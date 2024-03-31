package emplDepartManger.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import emplDepartManger.payload.ApiResponse;
/**
 * @author Vivek Singh
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<ApiResponse> handleResourceNotfoundException(ResourceNotFound msg){
		String message = msg.getMessage();
	ApiResponse response = 	ApiResponse.builder().message(message).sucess(true).status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		
	}

}
