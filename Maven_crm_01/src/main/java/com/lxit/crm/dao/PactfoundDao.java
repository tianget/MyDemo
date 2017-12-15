package com.lxit.crm.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import com.lxit.crm.entities.Pact;

@MapperScan
public interface PactfoundDao {
	
	public  List<Pact>  getPactAll(Pact   pa);
	
	public List<Pact> pactPage(Map<String,Object> map);
	
	public int getPactCound();
	
	public int getPactTableCount(Pact pact);
	
	public boolean insertpact(Pact pact);
	
	public List<Pact> selectPactId(int pid);
	
	public Pact selectpact(int pid);
	
	public Pact updatepact(int pid);
}
