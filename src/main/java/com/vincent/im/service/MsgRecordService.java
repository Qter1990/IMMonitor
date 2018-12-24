package com.vincent.im.service;

import org.springframework.stereotype.Service;

import com.vincent.im.model.MsgRecord;

@Service
public interface MsgRecordService {
	int addMsgRecord(MsgRecord record);
}
