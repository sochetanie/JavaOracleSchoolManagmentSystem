package customExceptions;

public class InstructorRegistrationException extends Exception {
	
	public InstructorRegistrationException(String message) {
		super("\n\t"+message+"\n");
	}
	
	
}

