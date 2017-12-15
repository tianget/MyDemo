package com.lxit.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxit.crm.dao.PactfoundDao;
import com.lxit.crm.entities.Pact;
import com.lxit.crm.service.PactfoundService;

@Service
public class PactfoundServiceImpl implements PactfoundService {

	@Autowired
	private  PactfoundDao   pactfoundDao;
	
	@Override
	public List<Pact> getPactAll(int pid,String pname,String ptype,String pstate,String plasttime,String ppeople) {
		Pact  p = new  Pact();
		p.setPname(pname);
		p.setPtype(ptype);
		p.setPstate(pstate);
		p.setPlasttime(plasttime);
		p.setPpeople(ppeople);
		List<Pact>  list = pactfoundDao.getPactAll(p);
		return  list;
	}

	@Override
	public List<Pact> selectPactId(int pid) {
		return  pactfoundDao.selectPactId(pid);
	}

}
