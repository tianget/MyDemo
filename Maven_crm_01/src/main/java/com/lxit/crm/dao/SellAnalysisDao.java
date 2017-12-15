package com.lxit.crm.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import com.lxit.crm.entities.SellAnalysis;

@MapperScan
public interface SellAnalysisDao {

	/**
	 * 列出销售数据
	 * @param map
	 * @return
	 */
	public List<SellAnalysis> pageQuery(Map<String,Object> map);
	
	
	/**
	 * 获取总数
	 * @param map
	 * @return
	 */
	public List<SellAnalysis> getTotal(Map<String,Object> map);
	
	
	/**
	 * 列出各部门销售数据
	 * @param map
	 * @return
	 */
	public List<SellAnalysis> queryDeptDate(String month);
	
	
	/**
	 * 列出各部门员工销售数据
	 * @param map
	 * @return
	 */
	public List<SellAnalysis> queryEmpDate(Map<String,Object> map);
}
