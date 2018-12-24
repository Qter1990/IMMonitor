package com.vincent.im.contorller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.io.ResolverUtil.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.vincent.im.core.CheckSumBuilder;
import com.vincent.im.core.VincentCommon;
import com.vincent.im.model.LoginRecord;
import com.vincent.im.model.MsgRecord;
import com.vincent.im.service.LoginRecordService;
import com.vincent.im.service.MsgRecordService;

@RestController
public class IMReceiveMsgController {
	
	private final String AppKey = "b8bfd72ceefa106406faa1820b1357d5";
	private final String AppSecret = "2ea02e70f618";

	@Autowired
	private LoginRecordService loginRecordService;
	
	@Autowired
	private MsgRecordService msgRecordService;
	private String durStr;

	/*
	 * 插入登录登出记录
	 */
	public int addLoginRecord(LoginRecord record) {
		return loginRecordService.addLoginRecord(record);
	}
	
	/*
	 * 通过json插入登录登出记录
	 */
	public int addLoginRecordFromJson(JSONObject jsonObject) {
		int entType = Integer.parseInt(jsonObject.getString("eventType"));
		
		Date date = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss ");
		LoginRecord record  = new LoginRecord();
		
		record.setEvent_type(entType);
		record.setCreate_time(sdf.format(date));
		record.setLogin_operation(entType==2?1:2);
		record.setAccid(jsonObject.getString("accid"));
		record.setClient_ip(jsonObject.getString("clientIp"));
		record.setClient_type(jsonObject.getString("clientType"));
		record.setCode(jsonObject.getString("code"));
		record.setSdk_version(jsonObject.getString("sdkVersion"));
		
		long ts = Long.parseLong(jsonObject.getString("timestamp"));
		date.setTime(ts);
		record.setTimestamp(sdf.format(date));
		
		int ret = this.addLoginRecord(record);
		
		return ret;
	}
	
	/*
	 * 插入消息记录
	 */
	private int addMsgRecord(MsgRecord record) {
		return msgRecordService.addMsgRecord(record);
	}
	
	/*
	 * 通过json插入消息记录
	 */
	private int addMsgRecordFromJson(JSONObject jsonObject) {
		
		String convType = jsonObject.getString("convType");
		System.out.println(convType);
		if(convType.equals("PERSON") ==  false && convType.equals("TEAM") == false)
			return 0;
		
		MsgRecord record = new MsgRecord();
		Date date = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss ");
	
		record.setEventType(jsonObject.getString("eventType"));
		record.setConvType(jsonObject.getString("convType"));
		record.setTo(jsonObject.getString("to"));
		record.setFromAccount(jsonObject.getString("fromAccount"));
		record.setFromClientType(jsonObject.getString("fromClientType"));
		record.setFromDeviceId(jsonObject.getString("fromDeviceId"));
		record.setFromNick(jsonObject.getString("fromNick"));

		long ts = Long.parseLong(jsonObject.getString("msgTimestamp"));
		date.setTime(ts);
		record.setMsgTimestamp(sdf.format(date));
		
		String msgType = jsonObject.getString("msgType");
		String body = jsonObject.getString("body");
		String attach = jsonObject.getString("attach");
		record.setMsgType(msgType);
		record.setBody(body);
		
		
		//分析消息类型
		JSONObject attachJsonObject = JSON.parseObject(attach);
		if(attachJsonObject == null || attachJsonObject.isEmpty() == false) {
			if(msgType.equals("PICTURE") || 
					msgType.equals("AUDIO") ||
					msgType.equals("VIDEO") ||
					msgType.equals("FILE")) {
				record.setMsgContent(attachJsonObject.getString("url"));
				record.setExt(attachJsonObject.getString("ext"));
				durStr = attachJsonObject.getString("dur");
				if(durStr != null || durStr.isEmpty() == false)
				{
					int dur = Integer.parseInt(attachJsonObject.getString("dur"));
					record.setDur(dur);
				}
			}
		}

		record.setCreateTime(sdf.format(date));
		
		return this.addMsgRecord(record);
		
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String Test() {
		Date date = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss ");
	    
		LoginRecord record  = new LoginRecord();
		record.setAccid("1");
		record.setClient_ip("192.160.1.1");
		record.setClient_type("ios");
		record.setCode("code");
		record.setCreate_time(sdf.format(date));
		record.setDelete_time(sdf.format(date));
		record.setEvent_type(1);
		record.setId(1);
		record.setLogin_operation(1);
		record.setTimestamp(sdf.format(date));
		record.setUpdate_time(sdf.format(date));
		
		this.addLoginRecord(record);
		System.out.println("111");
		return "hello";
	}

	@RequestMapping(value = "/IMReceiveMsg", method = RequestMethod.POST)
	public String IMReceiveMsg(@RequestHeader("AppKey") String hAppKey,
			@RequestHeader("CurTime") String hCurTime,
			@RequestHeader("CheckSum") String hCheckSum,
			@RequestHeader("MD5") String hMD5, @RequestBody String body) {
		
		//验证云信密钥
		String requestBody = body;
		String md5 = CheckSumBuilder.getMD5(requestBody);
		String CheckSum = CheckSumBuilder.getCheckSum(AppSecret, md5, hCurTime);
		Boolean isVaild = false;
		if(CheckSum.equals(hCheckSum))
			isVaild = true;
		
		//解析Json
		if(isVaild)
		{	
			JSONObject jsonObject = JSON.parseObject(body);
			if(jsonObject == null || jsonObject.isEmpty())
				return "";
			int entType = Integer.parseInt(jsonObject.getString("eventType"));
			switch (entType) {
			case 1:
				this.addMsgRecordFromJson(jsonObject);
				System.out.println("111");
				break;
			case 2:
			case 3:
				this.addLoginRecordFromJson(jsonObject);
				break;

			default:
				break;
			}
		}
		
		return "IMReceiveMsgController";
	}
}
