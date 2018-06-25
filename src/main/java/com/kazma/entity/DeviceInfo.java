package com.kazma.entity;


/**
 * controller用,封装除业务外的其他参数
 * <p>
 * Created by codingH on 2017/1/10.
 */
public class DeviceInfo {

	protected String token;           //认证
	protected Integer port;           //端口
	protected String clientIP;        //ip
	protected Integer deviceType;     //设备类型 2：iOS手机端；3：ipad端 ;4:百度微购;5:安卓客户端
	protected String clientVersion;   //版本
	protected String source;          //渠道
	protected String IMEI;            //串号

	public static DeviceInfo convertJsonToThis(String deviceInfoJson){
	}


	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getClientIP() {
		return clientIP;
	}

	public void setClientIP(String clientIP) {
		this.clientIP = clientIP;
	}

	public Integer getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}

	public String getClientVersion() {
		return clientVersion;
	}

	public void setClientVersion(String clientVersion) {
		this.clientVersion = clientVersion;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getIMEI() {
		return IMEI;
	}

	public void setIMEI(String IMEI) {
		this.IMEI = IMEI;
	}

	public boolean isVersion() {
		return true;
	}

	@Override
	public String toString() {
		return "DeviceInfo{" +
				"token='" + token + '\'' +
				", port=" + port +
				", clientIP='" + clientIP + '\'' +
				", deviceType=" + deviceType +
				", clientVersion='" + clientVersion + '\'' +
				", source='" + source + '\'' +
				", IMEI='" + IMEI + '\'' +
				", address=" + address +
				'}';
	}
}
