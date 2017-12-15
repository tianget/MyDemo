package com.lxit.crm.dao;

import org.mybatis.spring.annotation.MapperScan;

import com.lxit.crm.entities.Client_member;

@MapperScan
public interface ClientMemberDao {
	/**
	 * 查询用户信息
	 * @param id
	 * @return
	 */
	public Client_member getAllMember(int id);
}
