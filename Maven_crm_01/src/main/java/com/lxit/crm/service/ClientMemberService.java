package com.lxit.crm.service;

import com.lxit.crm.entities.Client_member;

public interface ClientMemberService {
	/**
	 * 查询用户信息
	 * @param id
	 * @return
	 */
	public Client_member getAllMember(int id);
}
