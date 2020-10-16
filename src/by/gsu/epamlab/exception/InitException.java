package by.gsu.epamlab.exception;

public class InitException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private String error;
	
	public InitException(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return error;
	}
}
