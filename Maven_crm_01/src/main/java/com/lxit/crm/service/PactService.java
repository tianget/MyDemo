package com.lxit.crm.service;

import com.lxit.crm.entities.Pact;
import com.lxit.crm.util.Pager;

public interface PactService {

	/**
	 * 分页
	 * @param pageIndex
	 * @param pageSize
	 * @param pact
	 * @return
	 */
	public Pager<Pact> servicePage(int pageIndex,int pageSize,Pact pact);

	public int getPactCount();
	
	public int getPactTableCount(Pact pact);

	public boolean insertpact(Pact pact);
	
	public Pact selectpact(int pid);

	public  Pact updatepact(int pid);

}
