package com.lxit.crm.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import com.lxit.crm.entities.Pact;

@MapperScan
public interface PactManageDao {
	
	public Pact getPactById(int pid);
	
	/**通用修改状态和最后修改时间
	 * @param map
	 * @return
	 */
	public boolean updatePactStatus(Map<String, Object> map);
	
	public boolean pactInsepect(Map<String, Object> map);
}
