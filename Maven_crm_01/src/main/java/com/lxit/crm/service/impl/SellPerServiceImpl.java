package com.lxit.crm.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lxit.crm.dao.SellPerDao;
import com.lxit.crm.entities.SellPerformance;
import com.lxit.crm.entities.Staff;
import com.lxit.crm.service.SellPerService;

@Service
public class SellPerServiceImpl implements SellPerService {

	private SellPerDao sellPerDao;

	
	
	//private DecimalFormat df = new DecimalFormat("#.00");
	
	
	public SellPerDao getSellPerDao() {
		return sellPerDao;
	}

	@Resource
	public void setSellPerDao(SellPerDao sellPerDao) {
		this.sellPerDao = sellPerDao;
	}

	@Override
	public Map<String, Object> pageQuery(int page, int row, Staff staff, String like) {
		 Map<String, Object> map = new HashMap<String,Object>();
		 map.put("page", (page-1)*row);
		 map.put("row", row);
		 like = like==null?null:"%"+like+"%";
		 map.put("like", like);
		 map.put("staff", staff);
		 List<SellPerformance> pers = sellPerDao.pageQuery(map);
		 String baseCoding = staff.getRid()==4?"jxkhjl":"jxkhyg";
		 String baseValue = sellPerDao.getBaseValue(baseCoding);
		 List<SellPerformance> perss = new ArrayList<SellPerformance>();
		 for (SellPerformance sellPerformance : pers) {
			 if(sellPerformance!=null){
				 int baseValueInt = Integer.parseInt(baseValue);
					sellPerformance.setGrade((int)((sellPerformance.getSumMoney()-baseValueInt)/baseValueInt*10)+"");
					sellPerformance.setOperationManName(staff.getName());
					perss.add(sellPerformance);	 
			 }
			
		 }
		 map.put("rows", perss);
		 map.put("total", sellPerDao.getTotal(map));
		return map;
	}

	
	

	
	
	
	
}
