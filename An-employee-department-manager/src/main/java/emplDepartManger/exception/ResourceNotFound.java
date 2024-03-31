package emplDepartManger.exception;

/**
 * @author Vivek Singh
 *
 */
public class ResourceNotFound extends RuntimeException {

	public ResourceNotFound() {
		super("Resource not found");
	}

	public ResourceNotFound(String msg) {
		super(msg);
	}

}
