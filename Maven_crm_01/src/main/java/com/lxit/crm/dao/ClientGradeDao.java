package com.lxit.crm.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import com.lxit.crm.entities.Client_cost;
import com.lxit.crm.entities.Client_grade;
import com.lxit.crm.entities.Client_member;
import com.lxit.crm.entities.Client_order;
import com.lxit.crm.entities.Client_orders;
import com.lxit.crm.entities.Order;

@MapperScan
public interface ClientGradeDao {
	/**根据自己的权限查询出客户价值管理
	 * @return
	 */
    public List<Client_grade> getCosts(int sid);
    
    /**分页
	 * @param id
	 * @param pag
	 * @param rows
	 * @return
	 */
	public List<Client_grade> getPlans(Map<String,Integer> map);

	
	/**查询客户价值总条数
	 * @return
	 */
	public Long[] getPlanCount(int id);
	
	/**查询出所有已退款的订单
	 * @return
	 */
	public List<Client_order> getRefundCount();
	
	/**查询出所有已退款的订单
	 * @return
	 */
	public List<Client_order> getFulfillCount(Map<String, Integer> map);
	
	/**根据客户id查询客户信息
	 * @param mid
	 * @return
	 */
	public Client_cost getMember(int mid);
	
	/**根据客户id查询消费清单
	 * @return
	 */
	public List<Client_orders> getOrders(int mid);
}
