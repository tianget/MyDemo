package com.lxit.crm.service;

import com.lxit.crm.entities.Staff;


public interface LoginService {
	/**
	 * 
	 * @param name
	 *            传入的用户名
	 * @param password
	 *            密码
	 * @return
	 */
	public Staff login(String name, String password);
}
