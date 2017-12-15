package com.lxit.crm.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import com.lxit.crm.entities.Linkman;
import com.lxit.crm.entities.SellChance;
import com.lxit.crm.entities.SellPlan;
import com.lxit.crm.entities.Staff;

/**
 * 
 * @author Administrator
 *
 */
@MapperScan
public interface SellLinkManDao {
     
	/**
	 * 保存录入联系人
	 * @return
	 */
	public void save(Linkman linkman);
	
	
	/**
	 * 删除联系人
	 * @param id
	 */
	public void delete(int id);
	
	
	/**
	 * 列出所有联系人
	 * @return
	 */
	public List<Linkman> pageQuery(Map<String,Object> pages);
	
	
	
	
	/**
	 * 获取分页数据的总条数
	 * @param pages
	 * @return
	 */
	public int getPageTotle(Map<String,Object> pages);
	
	
	/**
	 * 修改联系人信息
	 */
	public void update(Linkman linkman);
	
	
	
	
	
	/**
	 * 获取联系人对象
	 */
	public Linkman getLinkMan(int id);
	
	
	
	
}
