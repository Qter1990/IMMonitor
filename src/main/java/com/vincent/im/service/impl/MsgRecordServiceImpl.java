package com.vincent.im.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vincent.im.dao.MsgRecordDao;
import com.vincent.im.model.MsgRecord;
import com.vincent.im.service.MsgRecordService;

@Service("msgRecordService")
public class MsgRecordServiceImpl implements MsgRecordService {
	
	@Autowired
	private MsgRecordDao msgRecordDao;

	@Override
	public int addMsgRecord(MsgRecord record) {
		
		return msgRecordDao.insert(record);
	}

	
	
}
