package com.lxit.crm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxit.crm.dao.ClientAllotDao;
import com.lxit.crm.entities.ClientPlan;
import com.lxit.crm.entities.Client_allot;
import com.lxit.crm.entities.Client_member;
import com.lxit.crm.entities.Staff;
import com.lxit.crm.service.ClientAllotService;
import com.lxit.crm.util.Pager;


@Service("allotService")
public class ClientAllotServiceImpl implements ClientAllotService{
	@Autowired
    private ClientAllotDao allotDao;

	@Override
	public List<Client_allot> getAllots(int sid) {
		return allotDao.getAllots(sid);
	}

	@Override
	public Pager<Client_allot> getPlanss(int id, int pag, int rows) {
		Pager<Client_allot> page = new Pager<>();
		page.setPageIndex(pag);
		page.setPageSize(rows);
		if("销售代表".equals(getRname(id))){
			page.setSumSize(rgetPlanCount(id));
			Map<String,Integer> map = new HashMap<>();
			map.put("id",id);
			map.put("pageIndex", (page.getPageIndex()-1)*page.getPageSize());
			map.put("pageSize", page.getPageSize());
			List<Client_allot> list = allotDao.rgetPlans(map);
			page.setData(list);
		}else{
			page.setSumSize(getPlanCount(id));
			Map<String,Integer> map = new HashMap<>();
			map.put("id",id);
			map.put("pageIndex", (page.getPageIndex()-1)*page.getPageSize());
			map.put("pageSize", page.getPageSize());
			List<Client_allot> list = allotDao.getPlans(map);
			page.setData(list);
		}
		
		return page;
	}
	
	@Override
	public int getPlanCount(int id){
	    return allotDao.getPlanCount(id);	
	}

	@Override
	public List<Client_allot> getPlans(Map<String, Integer> map) {
		return allotDao.getPlans(map);
	}
	
	@Override
	public String getRname(int id){
		return allotDao.getRname(id);
	}

	@Override
	public List<Client_allot> rgetPlans(Map<String, Integer> map) {
		return allotDao.rgetPlans(map);
	}

	@Override
	public int rgetPlanCount(int id) {
		return allotDao.rgetPlanCount(id);
	}

	@Override
	public int setMember(Client_member member) {
		return allotDao.setMember(member);
	}

	@Override
	public Client_member getMember(int mid) {
		return allotDao.getMember(mid);
	}

	@Override
	public int updateMember(Client_member member) {
		return allotDao.updateMember(member);
	}

	@Override
	public int addAllot(Client_allot all) {
		return allotDao.addAllot(all);
	}

	@Override
	public Client_member getMember2(String enteringDate) {
		return allotDao.getMember2(enteringDate);
	}

	@Override
	public List<Staff> getStaff() {
		return allotDao.getStaff();
	}

	@Override
	public int setAllotd(Client_allot allot) {
		return allotDao.setAllotd(allot);
	}

}
