package login.vo;

public class Res {

	private boolean successful;

	private String message;

	public Res() {
		// TODO Auto-generated constructor stub
	}

	public Res(boolean successful, String message) {
		super();
		this.successful = successful;
		this.message = message;
	}

	public boolean isSuccessful() {
		return successful;
	}

	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}




}
