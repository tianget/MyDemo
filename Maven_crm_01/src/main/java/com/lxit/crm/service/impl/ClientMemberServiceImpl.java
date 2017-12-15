package com.lxit.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lxit.crm.dao.ClientMemberDao;
import com.lxit.crm.entities.Client_member;
import com.lxit.crm.service.ClientMemberService;

@Service
public class ClientMemberServiceImpl implements ClientMemberService{
	
	@Autowired
	private ClientMemberDao clientMemberDao;
	
	@Override
	public Client_member getAllMember(int id) {
		return clientMemberDao.getAllMember(id);
	}
	
	

}
