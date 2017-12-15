package com.lxit.crm.service;

import java.util.List;
import java.util.Map;

import com.lxit.crm.entities.SellAnalysis;
import com.lxit.crm.entities.Staff;

public interface SellAnalysisService {
   
	/**
	 * 列出销售信息
	 * @param map
	 * @return
	 */
	public Map<String,Object>  pageQuery(int page,int row,Staff staff,String like);
	
	
	/**
	 * 列出各部门销售数据
	 * @param map
	 * @return
	 */
	public List<SellAnalysis> queryDeptDate(String month,int did);
	
	
	
	
}
