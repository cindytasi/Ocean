package shop.vo;

/*
 * API 預設狀態碼
 */
public class BaseAPIResult<T>{
	private int status = ApiConstants.STATUS_SUCCESS;
	private String code = null;
	private String description = null;
	private T data;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
