package util;

public class OutputObject {
	private String respCode;
	private String respMessage;
	private Object data;


	public String getRespCode() {
		return respCode;
	}

	public OutputObject setRespCode(String respCode) {
		this.respCode = respCode;
		return this;
	}

	public String getRespMessage() {
		return respMessage;
	}

	public OutputObject setRespMessage(String respMessage) {
		this.respMessage = respMessage;
		return this;
	}

	public Object getData() {
		return data;
	}

	public OutputObject setData(Object data) {
		this.data = data;
		return this;
	}

	@Override
	public String toString() {
		return "OutputObject{" +
				"respCode='" + respCode + '\'' +
				", respMessage='" + respMessage + '\'' +
				", data=" + data +
				'}';
	}
}
