package com.lxit.crm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lxit.crm.dao.SellPlanDao;
import com.lxit.crm.entities.SellPlan;
import com.lxit.crm.entities.Staff;
import com.lxit.crm.service.SellPlanService;

@Service
public class SellPlanServiceImpl implements SellPlanService {

	private SellPlanDao sellPlanDao;
	
	

	public SellPlanDao getSellPlanDao() {
		return sellPlanDao;
	}

	@Resource
	public void setSellPlanDao(SellPlanDao sellPlanDao) {
		this.sellPlanDao = sellPlanDao;
	}

	@Override
	public int save(SellPlan sellPlan) {
		System.out.println("sellPlan:"+sellPlan.getPlanName());
		sellPlanDao.save(sellPlan);
		return  sellPlan.getPlanId();
	}

	@Override
	public void delete(int id) {
		sellPlanDao.delete(id);
	}

	

	@Override
	public SellPlan getPlanCoding(String coding) {
		return sellPlanDao.getPlanCoding(coding);     
		
	}
	
	

	@Override
	public Map<String,Object> pageQuery(int page, int rows, Staff staff,String myPlan,String like) {
		
		Map<String,Object> pages = new HashMap<String,Object>();
		like = like==null?"%%":"%"+like+"%";
		pages.put("page", (page-1)*rows);
		pages.put("rows", rows);
		pages.put("state", "已创建");
		pages.put("myPlan", myPlan);
		pages.put("like", like);
		pages.put("staff", staff);
		List<SellPlan> sps = sellPlanDao.pageQuery(pages);
		int totle = sellPlanDao.getPageTotle(pages);
		pages.put("rows", sps);
		pages.put("total", totle);
		return pages;
	}

	@Override
	public void update(SellPlan sellplan) {
		sellPlanDao.update(sellplan);
	}

	@Override
	public void setState(SellPlan sellplan) {
		Staff staff = null;
		if(sellplan.getPlanManId()!=0){
			 staff = sellPlanDao.getStaff(sellplan.getPlanManId());
			 sellplan.setHandlerManId(staff.getSuperiorId());
			 
		}else{
			SellPlan sp = sellPlanDao.getSellPlan(sellplan.getPlanId());
			System.out.println(sp);
			if(sellplan.getState().equals("已通过")){
				 sellplan.setOperationManId(sp.getHandlerManId()); 
			 }else if(sellplan.getState().equals("已创建")){
				 sellplan.setOperationManId(sp.getPlanManId());
			 }
		}
		
		
		sellPlanDao.setState(sellplan);
		
	}

	
	
	
}
