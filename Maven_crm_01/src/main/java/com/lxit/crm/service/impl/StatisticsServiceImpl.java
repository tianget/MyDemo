package com.lxit.crm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxit.crm.dao.StatisticsDao;
import com.lxit.crm.entities.Statistics;
import com.lxit.crm.service.StatisticsService;
@Service
public class StatisticsServiceImpl implements StatisticsService {

	@Autowired
	private StatisticsDao statisticsDao;
	
	
	@Override
	public List<Statistics> statistics(String operation) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("operation", operation);
		return statisticsDao.statistics(map);
	}

}
