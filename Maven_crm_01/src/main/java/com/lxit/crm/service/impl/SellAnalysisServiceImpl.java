package com.lxit.crm.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lxit.crm.dao.SellAnalysisDao;
import com.lxit.crm.entities.SellAnalysis;
import com.lxit.crm.entities.Staff;
import com.lxit.crm.service.SellAnalysisService;

@Service
public class SellAnalysisServiceImpl implements SellAnalysisService {

	private SellAnalysisDao sellAnalysisDao;
	
	private DecimalFormat df = new DecimalFormat("#.00");

	public SellAnalysisDao getSellAnalysisDao() {
		return sellAnalysisDao;
	}
	
	@Resource
	public void setSellAnalysisDao(SellAnalysisDao sellAnalysisDao) {
		this.sellAnalysisDao = sellAnalysisDao;
	}

	@Override
	public Map<String,Object>  pageQuery(int page,int row,Staff staff,String like) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("page", (page-1)*row);
		map.put("row", row);
		like = like==null?null:"%"+like+"%";
		map.put("like", like);
		map.put("staff", staff);
		List<SellAnalysis> sas = sellAnalysisDao.pageQuery(map);
		List<SellAnalysis> sellAnalysiss = new ArrayList<SellAnalysis>();
		for (SellAnalysis sellAnalysis : sas) {
			sellAnalysis.setLoopThan(df.format(((sellAnalysis.getSumMoney()-sellAnalysis.getLastMoney())/sellAnalysis.getSumMoney())*100)+"%");
			sellAnalysis.setWithThan(df.format(((sellAnalysis.getSumMoney()-sellAnalysis.getLastYearMoney())/sellAnalysis.getSumMoney())*100)+"%");
			sellAnalysis.setSumMoney(Double.parseDouble(df.format(sellAnalysis.getSumMoney()/10000)));
			sellAnalysiss.add(sellAnalysis);
		}
		List<SellAnalysis> total = sellAnalysisDao.getTotal(map);
		map.put("rows", sellAnalysiss);
		map.put("total", total.size());
		return map;
	}

	@Override
	public List<SellAnalysis> queryDeptDate(String month,int did) {
		List<SellAnalysis>  sas = null;
		if(did<0){
			 sas = sellAnalysisDao.queryDeptDate(month);
		}else{
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("month", month);
			map.put("did", did);
			sas = sellAnalysisDao.queryEmpDate(map);
		}
		List<SellAnalysis> sellAnalysiss = new ArrayList<SellAnalysis>();
		for (SellAnalysis sellAnalysis : sas) {
			sellAnalysis.setLoopThan(df.format(((sellAnalysis.getSumMoney()-sellAnalysis.getLastMoney())/sellAnalysis.getSumMoney())*100)+"%");
			sellAnalysis.setWithThan(df.format(((sellAnalysis.getSumMoney()-sellAnalysis.getLastYearMoney())/sellAnalysis.getSumMoney())*100)+"%");
			sellAnalysis.setSumMoney(Double.parseDouble(df.format(sellAnalysis.getSumMoney()/10000)));
			sellAnalysiss.add(sellAnalysis);
		}
		return sellAnalysiss;
	}

	
	
}
