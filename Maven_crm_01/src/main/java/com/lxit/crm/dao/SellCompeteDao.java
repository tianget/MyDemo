package com.lxit.crm.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import com.lxit.crm.entities.CompeteManager;

@MapperScan
public interface SellCompeteDao {

	/**
	 * 列出销售竞争
	 * @param map
	 * @return
	 */
	public List<CompeteManager> pageQuery(Map<String,Object> map);
	
	
	/**
	 * 获取总数
	 * @param map
	 * @return
	 */
	public int getTotal(Map<String,Object> map);

	/**
	 * 录入销售竞争
	 * @param competeManager
	 */
	public void saveSellCompete(CompeteManager competeManager);
	
	
	/**
	 * 获取CompeteManager
	 * @param int
	 * @return
	 */
	public CompeteManager getSellComtepeById(int id);
	
	/**
	 * 更新CompeteManager
	 * @param 
	 * @return
	 */
	public void updateSellCompete(CompeteManager competeManager);
	
	/**
	 * 归档
	 * @param 
	 * @return
	 */
	public void setState(CompeteManager competeManager);
}

