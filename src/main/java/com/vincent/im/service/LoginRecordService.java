package com.vincent.im.service;

import org.springframework.stereotype.Service;

import com.vincent.im.model.LoginRecord;

@Service
public interface LoginRecordService {
	
	int addLoginRecord(LoginRecord record);
	
}
