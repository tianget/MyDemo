package com.lxit.crm.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.lxit.crm.entities.ClientLoving;
import com.lxit.crm.entities.ClientRemind;
import com.lxit.crm.entities.ClientScheme;
import com.lxit.crm.entities.Client_allot;
import com.lxit.crm.entities.Client_cost;
import com.lxit.crm.entities.Client_member;
import com.lxit.crm.entities.SellChance;
import com.lxit.crm.entities.Staff;
import com.lxit.crm.util.Pager;


public interface ClientLovingService {
	/**分页
	 * @param id
	 * @param pag
	 * @param rows
	 * @return
	 */
	public List<ClientLoving> getLovings(Map<String,Object> map);
	
	/**查询客户发展计划总条数
	 * @return
	 */
	public int getCount(int id);
	
	/**分页
	 * @param id
	 * @param pag
	 * @param rows
	 * @return
	 */
	public Pager<ClientLoving> getPlanss(int id, int pag, int rows);
	
	/**分页
	 * @param id
	 * @param pag
	 * @param rows
	 * @return
	 */
	public List<ClientRemind> getLovds(Map<String,Object> map);
	
	/**查询客户发展计划总条数
	 * @return
	 */
	public int getLovdCount(int id);
	
	/**
	 * @param id
	 * @param pag
	 * @param rows
	 * @return
	 */
	public Pager<ClientRemind> getPageLovd(int id, int pag, int rows);
	
	
	/**查询客户信息
	 * @param mid
	 * @return
	 */
	public Client_member getMember(int mid);
	
	/**分页
	 * @param id
	 * @param pag
	 * @param rows
	 * @return
	 */
	public List<ClientScheme> getLovdd(Map<String,Object> map);
	
	/**查询客户发展计划总条数
	 * @return
	 */
	public int getLovddCount(int id);

	
	/**
	 * @param id
	 * @param pag
	 * @param rows
	 * @return
	 */
	public Pager<ClientScheme> getPageLovdd(int id, int pag, int rows);
	
	/**增加关怀详情
	 * @param cs
	 * @return
	 */
	public int addLovd(ClientScheme cs);
	
	/**修改关怀详情
	 * @param cs
	 * @return
	 */
	public int updateLovd(ClientScheme cs);
	
	/**删除关怀详情
	 * @param scid
	 * @return
	 */
	public int delLovd(int scid);
}
