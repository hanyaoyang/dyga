package util;

public class InputObject {
	//APP：手机端 H5: h5端
	private String terminal;
	//请求时间(yyyy-MM-dd HH:mm:ss)
	private String reqTime;
	//app版本号
	private String clientVersion;
	//接口版本号
	private String version;
	private String token;
	//加密数据
	private String custId;
	// 终端类型 ios，android
	private String terminalType;
	/**
	 * 设备唯一标识
	 */
	private String deviceIdfaImei;

	/**
	 *用于追踪日志链
	 */
	private String reqId;

	private Object data;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	public String getReqTime() {
		return reqTime;
	}

	public void setReqTime(String reqTime) {
		this.reqTime = reqTime;
	}

	public String getClientVersion() {
		return clientVersion;
	}

	public void setClientVersion(String clientVersion) {
		this.clientVersion = clientVersion;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getTerminalType() {
		return terminalType;
	}

	public void setTerminalType(String terminalType) {
		this.terminalType = terminalType;
	}

	public String getDeviceIdfaImei() {
		return deviceIdfaImei;
	}

	public void setDeviceIdfaImei(String deviceIdfaImei) {
		this.deviceIdfaImei = deviceIdfaImei;
	}
	
	public String getReqId() {
		return reqId;
	}

	public void setReqId(String reqId) {
		this.reqId = reqId;
	}

	@Override
	public String toString() {
		return "InputObject{" +
				"terminal='" + terminal + '\'' +
				", reqTime='" + reqTime + '\'' +
				", clientVersion='" + clientVersion + '\'' +
				", version='" + version + '\'' +
				", token='" + token + '\'' +
				", custId='" + custId + '\'' +
				", terminalType='" + terminalType + '\'' +
				", deviceIdfaImei='" + deviceIdfaImei + '\'' +
				", reqId=" + reqId +
				", data=" + data +
				'}';
	}
}
