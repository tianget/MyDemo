package com.lxit.crm.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import com.lxit.crm.entities.SellPerformance;
/**
 * 销售绩效dao
 * @author Administrator
 *
 */
@MapperScan
public interface SellPerDao {

	
	/**
	 * 列出所有员工绩效
	 * @param map
	 * @return
	 */
	public List<SellPerformance> pageQuery(Map<String,Object> map);
	
	
	/**
	 * 获取分页总数
	 * @param map
	 * @return
	 */
	public int getTotal(Map<String,Object> map);
	
	
	
	public String getBaseValue(String baseCoding);
}
