package com.lxit.crm.service;

import java.util.List;
import java.util.Map;

import com.lxit.crm.entities.Client_allot;
import com.lxit.crm.entities.Client_cost;
import com.lxit.crm.entities.Client_member;
import com.lxit.crm.entities.Client_order;
import com.lxit.crm.entities.Client_orders;
import com.lxit.crm.entities.Order;
import com.lxit.crm.util.Pager;

public interface ClientCostService {
	/**根据自己的权限查询出客户价值管理
	 * @return
	 */
    public List<Client_cost> getCosts(int sid);
    
    /**分页
	 * @param id
	 * @param pag
	 * @param rows
	 * @return
	 */
	public List<Client_cost> getPlans(Map<String,Integer> map);

	
	/**查询客户价值总条数
	 * @return
	 */
	public Long[] getPlanCount(int id);
	
	/**分页
	 * @param id
	 * @param pag
	 * @param rows
	 * @return
	 */
	public Pager<Client_cost> getPlanss(int id,int pag,int rows);
	
	/**根据客户mid查询客户信息
	 * @param mid
	 * @return
	 */
	public Client_member getMmember(int mid);
	
	/**根据客户mid查询客户所有的消费信息
	 * @param mid
	 * @return
	 */
	public List<Client_orders> getMorder(int mid);
}
