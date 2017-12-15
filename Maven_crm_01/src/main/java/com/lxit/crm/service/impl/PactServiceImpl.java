package com.lxit.crm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxit.crm.dao.PactfoundDao;
import com.lxit.crm.entities.Pact;
import com.lxit.crm.service.PactService;
import com.lxit.crm.util.Pager;

@Service("pactService")
public class PactServiceImpl implements PactService{

	@Autowired
	private  PactfoundDao pactfoundDao;
	public PactfoundDao getPactfoundDao(){
		return pactfoundDao;
	}
	public void setPactfoundDao(PactfoundDao pactfoundDao){
		this.pactfoundDao = pactfoundDao;
	}

	@Override
	public Pager<Pact> servicePage(int pageIndex, int pageSize, Pact pact) {
		Pager<Pact> pa = new Pager<>();
		pa.setPageIndex(pageIndex);
		pa.setPageSize(pageSize);
		pa.setSumSize(getPactTableCount(pact));
		Map<String,Object> map = new HashMap<>();
		map.put("pageIndex",(pa.getPageIndex()-1)*pa.getPageSize());
		map.put("pageSize",pa.getPageSize());
		map.put("pname",pact.getPname());
		map.put("ptype",pact.getPtype());
		map.put("pstate",pact.getPstate());
		List<Pact> list = pactfoundDao.pactPage(map);
		pa.setData(list);
		return pa;
	}
	
	@Override
	public int getPactCount(){
		return pactfoundDao.getPactCound();
	}
	
	@Override
	public int getPactTableCount(Pact pact){
		return pactfoundDao.getPactTableCount(pact);
	}
	
	@Override
	public boolean insertpact(Pact pact){
		return pactfoundDao.insertpact(pact);
	}
	

	@Override
	public Pact selectpact(int pid) {
		return pactfoundDao.selectpact(pid);
	}

	
	@Override
	public Pact updatepact(int pid){
		return pactfoundDao.updatepact(pid);
	}
	

}
