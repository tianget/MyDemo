package com.lxit.crm.service;

import java.util.List;
import java.util.Map;

import com.lxit.crm.entities.Linkman;
import com.lxit.crm.entities.SellChance;
import com.lxit.crm.entities.Staff;

public interface SellChanceService {

	/**
	 * 保存录入机会
	 * @return
	 */
	public int save(SellChance sellChance);
	
	
	
	
	/**
	 * 列出所有机会
	 * @return
	 */
	public Map<String,Object> pageQuery(int page,int rows,String like,Staff staff);
	
	
	
	
	/**
	 * 获取分页数据的总条数
	 * @param pages
	 * @return
	 */
	public int getPageTotle(Map<String,Object> pages);
	
	
	/**
	 * 修改机会信息
	 */
	public void update(SellChance sellChance);
	
	
	
	
	
	/**
	 * 获取机会对象
	 */
	public SellChance getSellChance(int id);
	
	/**
	 * 获取销售代表
	 */
	public List<Staff> queryStaffs(int id);
	
	/**
	 * 分配机会
	 */
	public void allotChance(SellChance sellChance);
	
}
