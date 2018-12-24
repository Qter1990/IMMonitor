package com.vincent.im.dao;

import org.springframework.stereotype.Repository;

import com.vincent.im.model.LoginRecord;

@Repository
public interface LoginRecordDao {
	
	int insert(LoginRecord record);
}
