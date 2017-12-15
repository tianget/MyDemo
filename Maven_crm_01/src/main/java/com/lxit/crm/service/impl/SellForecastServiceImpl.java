package com.lxit.crm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lxit.crm.dao.SellForecastDao;
import com.lxit.crm.entities.Base;
import com.lxit.crm.entities.Department;
import com.lxit.crm.entities.SellForecast;
import com.lxit.crm.entities.Staff;
import com.lxit.crm.service.SellForecastService;

@Service
public class SellForecastServiceImpl implements SellForecastService {

	private SellForecastDao sellForecastDao;

	
	
	public SellForecastDao getSellForecastDao() {
		return sellForecastDao;
	}

	@Resource
	public void setSellForecastDao(SellForecastDao sellForecastDao) {
		this.sellForecastDao = sellForecastDao;
	}

	@Override
	
	
	
	public Map<String, Object> pageQuery(int page,int row,String like,Staff staff) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("page", (page-1)*row);
		map.put("row", row);
		like = like==null?null:"%"+like+"%";
		map.put("like", like);
		map.put("staff", staff);
		List<SellForecast> sfs = sellForecastDao.pageQuery(map);
		for (SellForecast sellForecast : sfs) {
			if("0".equals(sellForecast.getType())){
				sellForecast.setType("整体预测");
			}else if("1".equals(sellForecast.getType())){
				sellForecast.setType("部门预测");
			}else if("2".equals(sellForecast.getType())){
				sellForecast.setType("个人预测");
			}
		}
		int total = sellForecastDao.getTotal(map);
		map.put("rows", sfs);
		map.put("total", total);
		return map;
	}

	@Override
	public int getEmpCount(Map<String, Object> map) {
		return sellForecastDao.getEmpCount(map);
	}

	@Override
	public int getClientCount(Map<String, Object> map) {
		return sellForecastDao.getClientCount(map);
	}

	@Override
	public void setBaseValue(Base base) {
		sellForecastDao.setBaseValue(base);
	}

	@Override
	public void saveSellForecast(SellForecast sf) {
		sellForecastDao.saveSellForecast(sf);		
	}

	@Override
	public List<Department> getSonDept(int did) {
		return sellForecastDao.getSonDept(did);
	}

	@Override
	public SellForecast getSellForecasById(int sfid) {
		return sellForecastDao.getSellForecasById(sfid);
	}
	
	
	
	
}
