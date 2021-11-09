package exceptions.technical;

public class DAOException extends Exception {

	private static final long serialVersionUID = 4076095523249440927L;

	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}

	public DAOException(Throwable cause) {
		super(cause);
	}

	public DAOException(String message) {
		super(message);
	}
}
