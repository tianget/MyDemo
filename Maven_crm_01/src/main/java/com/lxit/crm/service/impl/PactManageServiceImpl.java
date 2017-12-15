package com.lxit.crm.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxit.crm.dao.PactManageDao;
import com.lxit.crm.entities.Pact;
import com.lxit.crm.service.PactManageService;

@Service
public class PactManageServiceImpl implements PactManageService{
	@Autowired
	private PactManageDao pactManage;

	@Override
	public Pact getPactById(int pid) {
		return pactManage.getPactById(pid);
	}

	@Override
	public boolean updatePactStatus(Map<String, Object> map) {
		return pactManage.updatePactStatus(map);
	}

	@Override
	public boolean pactInsepect(Map<String, Object> map) {
		return pactManage.pactInsepect(map);
	}
}
