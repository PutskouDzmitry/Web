package by.gsu.epamlab.exception;

public class DaoException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String error;
	
	public DaoException(String error) {
		this.error = error;
	}
	
	public DaoException(String error,Throwable e) {
		super(error,e);
	}

	@Override
	public String toString() {
		return error;
	}

}
