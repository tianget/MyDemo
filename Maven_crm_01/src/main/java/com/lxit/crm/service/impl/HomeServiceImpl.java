package com.lxit.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxit.crm.dao.HomeDao;
import com.lxit.crm.entities.Power;
import com.lxit.crm.service.HomeService;
@Service("homeService")
public class HomeServiceImpl implements HomeService {

	@Autowired
	private HomeDao homeDao;
	@Override
	public List<Power> selectAllPower(Integer nid,int sid) {
		
		return homeDao.selectAllPower(nid,sid);
	}
	
	
	
}
