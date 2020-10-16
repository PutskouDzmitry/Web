package by.gsu.epamlab.exception;

public class ValidationException extends Exception{
	private static final long serialVersionUID = 1L;
	private String error;
	
	public ValidationException(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return error;
	}
}
