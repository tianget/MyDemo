package com.lxit.crm.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;

import com.lxit.crm.entities.Base;
import com.lxit.crm.entities.Department;
import com.lxit.crm.entities.SellForecast;
import com.lxit.crm.entities.Staff;

public interface SellForecastService {

   public Map<String, Object> pageQuery(int page,int rows,String like,Staff staff);

	public int getEmpCount(Map<String,Object> map);
	
	
	public int getClientCount(Map<String,Object> map);
	
	
	public void setBaseValue(Base base);
	
	public void saveSellForecast(SellForecast sf);
	
	public List<Department> getSonDept(int did);
	
	public SellForecast getSellForecasById(int sfid);
}
