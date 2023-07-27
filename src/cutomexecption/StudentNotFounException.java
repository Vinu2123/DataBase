package cutomexecption;

public class StudentNotFounException extends RuntimeException {
	private String message;

	public StudentNotFounException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}


}

