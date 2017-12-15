package com.lxit.crm.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lxit.crm.dao.SellLinkManDao;
import com.lxit.crm.entities.Linkman;
import com.lxit.crm.entities.SellPlan;
import com.lxit.crm.service.SellLinkManService;

@Service
public class SellLinkManServiceImpl implements SellLinkManService {

	private SellLinkManDao linkManDao;
	
	

	

	public SellLinkManDao getLinkManDao() {
		return linkManDao;
	}

	@Resource
	public void setLinkManDao(SellLinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}

	@Override
	public int save(Linkman linkman) {
		linkManDao.save(linkman);
		if(linkman==null){
			return -1;
		}
		return linkman.getId();

	}

	@Override
	public void delete(int id) {
		linkManDao.delete(id);
	}

	

	@Override
	public int getPageTotle(Map<String, Object> pages) {
		return 0;
	}

	@Override
	public void update(Linkman linkman) {
		linkManDao.update(linkman);
	}

	@Override
	public Linkman getLinkMan(int id) {
		return linkManDao.getLinkMan(id);
	}

	@Override
	public Map<String, Object> pageQuery(Map<String, Object> pages) {
		
		int row = (int)pages.get("row");
		int page = (int)pages.get("page");
		String like = (String) pages.get("like");
		like = like==null?"%%":"%"+like+"%";
		pages.put("like", like);
		pages.put("row", row);
		pages.put("page", (page-1)*row);
		List<Linkman> rows = linkManDao.pageQuery(pages);
		int total = linkManDao.getPageTotle(pages);
		pages.put("rows", rows);
		pages.put("total", total);		
		return pages;
	}

	

	
	
	
}
