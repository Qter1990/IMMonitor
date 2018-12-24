package com.vincent.im.model;

public class MsgRecord {
	private int id;
	private String eventType;
	private String convType;
	private String to;
	private String fromAccount;
	private String fromClientType;
	private String fromDeviceId;
	private String fromNick;
	private String msgTimestamp;
	private String msgType;
	private String body;
	private String msgContent;
	private String ext;
	private String createTime;
	private int dur;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getConvType() {
		return convType;
	}
	public void setConvType(String convType) {
		this.convType = convType;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}
	public String getFromClientType() {
		return fromClientType;
	}
	public void setFromClientType(String fromClientType) {
		this.fromClientType = fromClientType;
	}
	public String getFromDeviceId() {
		return fromDeviceId;
	}
	public void setFromDeviceId(String fromDeviceId) {
		this.fromDeviceId = fromDeviceId;
	}
	public String getFromNick() {
		return fromNick;
	}
	public void setFromNick(String fromNick) {
		this.fromNick = fromNick;
	}
	public String getMsgTimestamp() {
		return msgTimestamp;
	}
	public void setMsgTimestamp(String msgTimestamp) {
		this.msgTimestamp = msgTimestamp;
	}
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getMsgContent() {
		return msgContent;
	}
	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
	public int getDur() {
		return dur;
	}
	public void setDur(int dur) {
		this.dur = dur;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}
