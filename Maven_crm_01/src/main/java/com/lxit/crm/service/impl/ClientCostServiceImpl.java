package com.lxit.crm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxit.crm.dao.ClientCostDao;
import com.lxit.crm.entities.Client_allot;
import com.lxit.crm.entities.Client_cost;
import com.lxit.crm.entities.Client_member;
import com.lxit.crm.entities.Client_order;
import com.lxit.crm.entities.Client_orders;
import com.lxit.crm.entities.Order;
import com.lxit.crm.service.ClientCostService;
import com.lxit.crm.util.Pager;

@Service("costService")
public class ClientCostServiceImpl implements ClientCostService{
	@Autowired
	private ClientCostDao costDao;

	@Override
	public List<Client_cost> getCosts(int sid) {
		return costDao.getCosts(sid);
	}

	@Override
	public List<Client_cost> getPlans(Map<String, Integer> map) {
		return costDao.getPlans(map);
	}

	@Override
	public Long[] getPlanCount(int id) {
		return costDao.getPlanCount(id);
	}

	@Override
	public Pager<Client_cost> getPlanss(int id, int pag, int rows) {
		Pager<Client_cost> page = new Pager<>();
		page.setPageIndex(pag);
		page.setPageSize(rows);
		page.setSumSize(getPlanCount(id).length);
		Map<String,Integer> map = new HashMap<>();
		map.put("pageIndex", (page.getPageIndex()-1)*page.getPageSize());
		map.put("pageSize", page.getPageSize());
		List<Client_cost> list = costDao.getPlans(map);
		page.setData(list);
		return page;
	}

	@Override
	public Client_member getMmember(int mid) {
		return costDao.getMmember(mid);
	}

	@Override
	public List<Client_orders> getMorder(int mid) {
		return costDao.getMorder(mid);
	}
	
	

}
