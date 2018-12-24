package com.vincent.im.model;

public class LoginRecord {
	
	private Integer id;
	private String accid;
	private Integer login_operation;
	private Integer event_type;
	private String client_ip;
	private String client_type;
	private String code;
	private String sdk_version;
	private String timestamp;
	private String create_time;
	private String update_time;
	private String delete_time;
	
	public Integer getId() {
		return id;
	}
	public String getSdk_version() {
		return sdk_version;
	}
	public void setSdk_version(String sdk_version) {
		this.sdk_version = sdk_version;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAccid() {
		return accid;
	}
	public void setAccid(String accid) {
		this.accid = accid;
	}
	public Integer getLogin_operation() {
		return login_operation;
	}
	public void setLogin_operation(Integer login_operation) {
		this.login_operation = login_operation;
	}
	public Integer getEvent_type() {
		return event_type;
	}
	public void setEvent_type(Integer event_type) {
		this.event_type = event_type;
	}
	public String getClient_ip() {
		return client_ip;
	}
	public void setClient_ip(String client_ip) {
		this.client_ip = client_ip;
	}
	public String getClient_type() {
		return client_type;
	}
	public void setClient_type(String client_type) {
		this.client_type = client_type;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	public String getDelete_time() {
		return delete_time;
	}
	public void setDelete_time(String delete_time) {
		this.delete_time = delete_time;
	}
}
