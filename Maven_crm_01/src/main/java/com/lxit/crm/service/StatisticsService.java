package com.lxit.crm.service;

import java.util.List;

import com.lxit.crm.entities.Statistics;

public interface StatisticsService {

	//统计
		public List<Statistics> statistics(String operation);
}
