package com.lxit.crm.service;


import java.util.List;

import com.lxit.crm.entities.Pact;

public interface PactfoundService {
	public List<Pact> getPactAll(int  pid,String pname,String ptype,String pstate,String plasttime,String ppeople) ;

	public   List<Pact>  selectPactId(int  pid);
}
