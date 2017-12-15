package com.lxit.crm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxit.crm.dao.ClientPlanDao;
import com.lxit.crm.entities.ClientPlan;
import com.lxit.crm.entities.Client_allot;
import com.lxit.crm.entities.Serve;
import com.lxit.crm.service.ClientPlanService;
import com.lxit.crm.util.Pager;

@Service("planService")
public class ClientPlanServiceImpl implements ClientPlanService{
 
	@Autowired
	private ClientPlanDao planDao;
	@Override
	public Pager<ClientPlan> getPlanss(int id,int pag,int rows) {
		Pager<ClientPlan> page = new Pager<>();
		page.setPageIndex(pag);
		page.setPageSize(rows);
		if("销售代表".equals(getRname(id))){
			page.setSumSize(rgetPlanCount(id));
			Map<String,Integer> map = new HashMap<>();
			map.put("id",id);
			map.put("pageIndex", (page.getPageIndex()-1)*page.getPageSize());
			map.put("pageSize", page.getPageSize());
			List<ClientPlan> list = planDao.rgetPlans(map);
			page.setData(list);
		}else{
			page.setSumSize(getPlanCount(id));
			Map<String,Integer> map = new HashMap<>();
			map.put("id",id);
			map.put("pageIndex", (page.getPageIndex()-1)*page.getPageSize());
			map.put("pageSize", page.getPageSize());
			List<ClientPlan> list = planDao.getPlans(map);
			page.setData(list);
		}
		return page;
	}
	
	@Override
	public List<ClientPlan> getDate(Map<String,Object> map){
		return planDao.getDate(map);
	}
	
	public int getPlanCount(int id){
	    return planDao.getPlanCount(id);	
	}

	@Override
	public List<ClientPlan> getPlans(Map<String, Integer> map) {
		return planDao.getPlans(map);
	}

	@Override
	public List<ClientPlan> rgetPlans(Map<String, Integer> map) {
		return planDao.rgetPlans(map);
	}

	@Override
	public int rgetPlanCount(int id) {
		return planDao.rgetPlanCount(id);
	}
	
	@Override
	public String getRname(int id){
		return planDao.getRname(id);
	}

	@Override
	public int setPlan(ClientPlan plan) {
		return planDao.setPlan(plan);
	}

	@Override
	public ClientPlan getPlan(int id) {
		return planDao.getPlan(id);
	}

	@Override
	public int updatePlan(ClientPlan plan) {
		return planDao.updatePlan(plan);
	}

	@Override
	public int delete(int id) {
		return planDao.delete(id);
	}




}
