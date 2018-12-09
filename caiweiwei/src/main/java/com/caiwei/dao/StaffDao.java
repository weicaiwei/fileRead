package com.caiwei.dao;

import java.util.Map;

import com.caiwei.entity.StaffInfo;

public interface StaffDao {
	/*
	 * 根据用户密码抽出用户
	 */
	/**
	 * @param map
	 * @return string
	 */
	public String queryStaff(Map<String,String> map);
	//根据用户Id查出用户的详细信息
	public StaffInfo queryStaffInfo(String staffId);

}
