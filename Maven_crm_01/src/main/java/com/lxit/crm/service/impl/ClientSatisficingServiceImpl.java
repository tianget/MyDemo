package com.lxit.crm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxit.crm.dao.ClientSatisficingDao;
import com.lxit.crm.entities.ClientSatisficing;
import com.lxit.crm.entities.Client_allot;
import com.lxit.crm.entities.Client_cost;
import com.lxit.crm.entities.Client_grade;
import com.lxit.crm.entities.Client_member;
import com.lxit.crm.entities.Client_order;
import com.lxit.crm.service.ClientSatisficingService;
import com.lxit.crm.util.Pager;

@Service("satisficingService")
public class ClientSatisficingServiceImpl implements ClientSatisficingService{
    @Autowired
	private ClientSatisficingDao satisficingDao;
    
	@Override
	public Pager<ClientSatisficing> getPlanss(int id, int pag, int rows) {
		Pager<ClientSatisficing> page = new Pager<>();
		page.setPageIndex(pag);
		page.setPageSize(rows);
		page.setSumSize(getPlanCount(id));
		Map<String,Integer> map = new HashMap<>();
		map.put("pageIndex", (page.getPageIndex()-1)*page.getPageSize());
		map.put("pageSize", page.getPageSize());
		List<ClientSatisficing> list = satisficingDao.getPlans(map);
		page.setData(list);
		return page;
	}
	
	


	@Override
	public List<ClientSatisficing> getPlans(Map<String, Integer> map) {
		return satisficingDao.getPlans(map);
	}


	@Override
	public int getPlanCount(int id) {
		return satisficingDao.getPlanCount(id);
	}




	@Override
	public ClientSatisficing getSatisficing(int id) {
		return satisficingDao.getSatisficing(id);
	}




	@Override
	public int updateSatisficing(ClientSatisficing clientSatisficing) {
		return satisficingDao.updateSatisficing(clientSatisficing);
	}




	@Override
	public int deleteSatisficing(int id) {
		return satisficingDao.deleteSatisficing(id);
	}

	@Override
	public List<Client_member> getMembers() {
		return satisficingDao.getMembers();
	}




	@Override
	public ClientSatisficing getMembersTwo(int mid) {
		return satisficingDao.getMembersTwo(mid);
	}




	@Override
	public int addSatisficing(ClientSatisficing cl) {
		return satisficingDao.addSatisficing(cl);
	}
}
