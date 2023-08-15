package core.vo;

public class CoreVo {

	private boolean successful;
	private String message;
	private boolean imageSuccessful;
	private String imageMessage;
	

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
	

	public boolean isImageSuccessful() {
		return imageSuccessful;
	}

	public void setImageSuccessful(boolean imageSuccessful) {
		this.imageSuccessful = imageSuccessful;
	}

	public String getImageMessage() {
		return imageMessage;
	}

	public void setImageMessage(String imageMessage) {
		this.imageMessage = imageMessage;
	}
	
	
}
