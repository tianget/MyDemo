package com.lxit.crm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.lxit.crm.dao.SellChanceDao;
import com.lxit.crm.entities.SellChance;
import com.lxit.crm.entities.Staff;
import com.lxit.crm.service.SellChanceService;

@Service
public class SellChanceServiceImpl implements SellChanceService {

	private SellChanceDao sellChanceDao;
	
	
	
	public SellChanceDao getSellChanceDao() {
		return sellChanceDao;
	}

	@Resource
	public void setSellChanceDao(SellChanceDao sellChanceDao) {
		this.sellChanceDao = sellChanceDao;
	}

	@Override
	public int save(SellChance sellChance) {
		sellChanceDao.save(sellChance);
		return sellChance.getId();
	}

	@Override
	public Map<String,Object> pageQuery(int page,int rows,String like,Staff staff) {
		
		Map<String,Object> pages = new HashMap<String,Object>();
		like = like==null?"%%":"%"+like+"%";
		pages.put("like", like);
		pages.put("row", rows);
		pages.put("staff", staff);
		pages.put("page", (page-1)*rows);
		List<SellChance>  rowss = sellChanceDao.pageQuery(pages);
		int total = sellChanceDao.getPageTotle(pages);
		pages.put("rows", rowss);
		pages.put("total", total);
		return pages;
	}

	@Override
	public int getPageTotle(Map<String, Object> pages) {
		return sellChanceDao.getPageTotle(pages);
	}

	@Override
	public void update(SellChance sellChance) {
		sellChanceDao.update(sellChance);		
	}

	@Override
	public SellChance getSellChance(int id) {
		return sellChanceDao.getSellChance(id);
	}

	@Override
	public List<Staff> queryStaffs(int id) {
		return sellChanceDao.queryStaffs(id);
	}

	@Override
	public void allotChance(SellChance sellChance) {
		sellChanceDao.allotChance(sellChance);
	}

	
	
	

}
