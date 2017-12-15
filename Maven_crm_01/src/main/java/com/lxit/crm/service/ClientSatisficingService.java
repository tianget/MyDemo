package com.lxit.crm.service;

import java.util.List;
import java.util.Map;

import com.lxit.crm.entities.ClientSatisficing;
import com.lxit.crm.entities.Client_allot;
import com.lxit.crm.entities.Client_grade;
import com.lxit.crm.entities.Client_member;
import com.lxit.crm.util.Pager;

public interface ClientSatisficingService {
	/**分页
	 * @param id
	 * @param pag
	 * @param rows
	 * @return
	 */
	public Pager<ClientSatisficing> getPlanss(int id, int pag, int rows);
    
    /**分页
	 * @param id
	 * @param pag
	 * @param rows
	 * @return
	 */
	public List<ClientSatisficing> getPlans(Map<String,Integer> map);
	
	/**查询客户发展计划总条数
	 * @return
	 */
	public int getPlanCount(int id);
	
	/**根据客户id查询客户满意度
	 * @param id
	 * @return
	 */
	public ClientSatisficing getSatisficing(int id);
	
	/**修改客户满意度
	 * @param clientSatisficing
	 * @return
	 */
	public int updateSatisficing(ClientSatisficing clientSatisficing);
	
	/**根据客户id删除客户满意度信息
	 * @param id
	 * @return
	 */
	public int deleteSatisficing(int id);
	
	/**查询所有客户信息
	 * @return
	 */
	public List<Client_member> getMembers();
	
	/**查询客户信息
	 * @return
	 */
	public ClientSatisficing getMembersTwo(int mid);
	
	/**增加客户满意度信息
	 * @return
	 */
	public int addSatisficing(ClientSatisficing cl);
}
