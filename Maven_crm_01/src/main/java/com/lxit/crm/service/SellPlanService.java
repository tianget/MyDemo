package com.lxit.crm.service;

import java.util.List;
import java.util.Map;

import com.lxit.crm.entities.SellPlan;
import com.lxit.crm.entities.Staff;

public interface SellPlanService {

	
	/**
	 * 保存录入销售计划
	 * @return
	 */
	public int save(SellPlan sellPlan);
	
	
	/**
	 * 删除销售计划
	 * @param id
	 */
	public void delete(int id);
	
	
	/**
	 * 列出所以的销售计划
	 * @return
	 */
	public Map<String,Object> pageQuery(int page,int rows,Staff staff,String myPlan,String like);
	
	
	/**
	 * 获取销售编码
	 * @return
	 */
	public SellPlan getPlanCoding(String coding);
	
	
	

	/**
	 * 修改销售计划
	 */
	public void update(SellPlan sellplan);
	
	/**
	 * 修改销售计划状态
	 */
	public void setState(SellPlan sellplan);
}
