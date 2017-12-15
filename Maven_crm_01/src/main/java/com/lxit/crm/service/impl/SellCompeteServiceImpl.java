package com.lxit.crm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lxit.crm.dao.SellCompeteDao;
import com.lxit.crm.entities.CompeteManager;
import com.lxit.crm.service.SellCompeteService;

@Service
public class SellCompeteServiceImpl implements SellCompeteService {

	private SellCompeteDao sellCompeteDao;

	public SellCompeteDao getSellCompeteDao() {
		return sellCompeteDao;
	}

	@Resource
	public void setSellCompeteDao(SellCompeteDao sellCompeteDao) {
		this.sellCompeteDao = sellCompeteDao;
	}

	@Override
	public Map<String, Object> pageQuery(int page, int row, String like) {
		 Map<String, Object> map = new HashMap<String,Object>();
		 map.put("page", (page-1)*row);
		 map.put("row", row);
		 like = like==null?null:"%"+like+"%";
		 map.put("like", like);
		 List<CompeteManager> cms = sellCompeteDao.pageQuery(map);
		 for (CompeteManager competeManager : cms) {
				 competeManager.setType("0".equals(competeManager.getType())?"行业分析":"公司分析");
				 competeManager.setState("0".equals(competeManager.getState())?"未归档":"已归档"); 
		 }
		 int total = sellCompeteDao.getTotal(map);
		 map.put("rows", cms);
		 map.put("total", total);
		return map;
	}

	@Override
	public void saveSellCompete(CompeteManager competeManager) {
		sellCompeteDao.saveSellCompete(competeManager);
	}

	@Override
	public CompeteManager getSellComtepeById(int id) {
		return sellCompeteDao.getSellComtepeById(id);
	}

	@Override
	public void updateSellCompete(CompeteManager competeManager) {
		sellCompeteDao.updateSellCompete(competeManager);
	}

	@Override
	public void setState(CompeteManager competeManager) {
		sellCompeteDao.setState(competeManager);
	}
	
	
	
}
