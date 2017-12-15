package com.lxit.crm.service;

import java.util.List;
import java.util.Map;

import com.lxit.crm.entities.Staff;

public interface SellPerService {

	/**
	 * 销售绩效service
	 */
	
	
	
	/**
	 * 列出所有员工绩效
	 * @param map
	 * @return
	 */
	public Map<String,Object> pageQuery(int page,int row,Staff staff,String like);
	
	
	
}
