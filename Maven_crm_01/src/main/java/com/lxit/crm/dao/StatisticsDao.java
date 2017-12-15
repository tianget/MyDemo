package com.lxit.crm.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import com.lxit.crm.entities.Statistics;

@MapperScan
public interface StatisticsDao {

	//统计
	public List<Statistics> statistics(Map<String,Object> map);
}
