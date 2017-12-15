package com.lxit.crm.service;

import java.util.List;
import java.util.Map;

import com.lxit.crm.entities.CompeteManager;


public interface SellCompeteService {

	/**
	 * 列出销售信息
	 * @param map
	 * @return
	 */
	public Map<String,Object>  pageQuery(int page,int row,String like);
	
	
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
