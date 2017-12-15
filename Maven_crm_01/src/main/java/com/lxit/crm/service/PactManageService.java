package com.lxit.crm.service;

import java.util.Map;

import com.lxit.crm.entities.Pact;

public interface PactManageService {
	public Pact getPactById(int pid);
	
	/**通用修改状态和最后修改时间
	 * @param map
	 * @return
	 */
	public boolean updatePactStatus(Map<String, Object> map);
	
	public boolean pactInsepect(Map<String, Object> map);
}
