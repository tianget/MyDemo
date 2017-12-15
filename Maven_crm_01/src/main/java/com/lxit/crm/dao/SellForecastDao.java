package com.lxit.crm.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import com.lxit.crm.entities.Base;
import com.lxit.crm.entities.Department;
import com.lxit.crm.entities.SellForecast;

@MapperScan
public interface SellForecastDao {
	
	public List<SellForecast> pageQuery(Map<String,Object> map);

	
	public int getTotal(Map<String,Object> map);
	
	
	public int getEmpCount(Map<String,Object> map);
	
	
	public int getClientCount(Map<String,Object> map);
	
	
	public void setBaseValue(Base base);
	
	public void saveSellForecast(SellForecast sf);
	
	public List<Department> getSonDept(int did);
	
	
	public SellForecast getSellForecasById(int sfid);
	
	
}
