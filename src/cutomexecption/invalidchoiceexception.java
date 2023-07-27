package cutomexecption;

public class invalidchoiceexception extends RuntimeException{
	private String message;

	public invalidchoiceexception(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
