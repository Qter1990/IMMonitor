package com.vincent.im.dao;

import org.springframework.stereotype.Repository;

import com.vincent.im.model.MsgRecord;

@Repository
public interface MsgRecordDao {

	public int insert(MsgRecord record);
}
