package com.lxit.crm.service;

import java.util.List;

import com.lxit.crm.entities.Power;

public interface HomeService {
	public List<Power> selectAllPower(Integer nid,int sid);
}
