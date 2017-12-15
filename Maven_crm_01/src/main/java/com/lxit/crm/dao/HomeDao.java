package com.lxit.crm.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.lxit.crm.entities.Power;

@MapperScan
public interface HomeDao {

	public List<Power> selectAllPower(int nid,int sid);
}
