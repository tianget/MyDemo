package com.lxit.crm.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import com.lxit.crm.entities.SellPlan;
import com.lxit.crm.entities.Staff;

/**
 * 
 * @author Administrator
 *
 */
@MapperScan
public interface SellPlanDao {
     
	/**
	 * 保存录入销售计划
	 * @return
	 */
	public void save(SellPlan sellplan);
	
	
	/**
	 * 删除销售计划
	 * @param id
	 */
	public void delete(int id);
	
	
	/**
	 * 列出所以的销售计划
	 * @return
	 */
	public List<SellPlan> pageQuery(Map<String,Object> pages);
	
	
	/**
	 * 获取销售编码
	 * @return
	 */
	public SellPlan getPlanCoding(String coding);
	
	
	/**
	 * 获取分页数据的总条数
	 * @param pages
	 * @return
	 */
	public int getPageTotle(Map<String,Object> pages);
	
	
	/**
	 * 修改销售计划
	 */
	public void update(SellPlan sellplan);
	
	
	/**
	 * 修改销售计划状态
	 */
	public void setState(SellPlan sellplan);
	
	
	/**
	 * 获取staff
	 */
	public Staff getStaff(int id);
	
	
	/**
	 * 获取销售计划
	 * @return
	 */
	public SellPlan getSellPlan(int id);
}
