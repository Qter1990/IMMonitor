package com.vincent.im.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vincent.im.dao.LoginRecordDao;
import com.vincent.im.model.LoginRecord;
import com.vincent.im.service.LoginRecordService;

@Service("loginRecordService")
public class LoginRecordServiceImpl implements LoginRecordService {
	
	@Autowired
	private LoginRecordDao loginRecordDao;
	
	public int addLoginRecord(LoginRecord record) {
		return loginRecordDao.insert(record);
	}
}
