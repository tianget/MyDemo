package com.lxit.crm.service;

import java.util.List;
import java.util.Map;

import com.lxit.crm.entities.Order;
/**
 * 订单管理
 * @author Administrator
 *
 */
public interface OrderService {	
	

	/**
	 * 查询总条数
	 * @return
	 */
	public int getCount();
	
	/**
	 * 分页查询
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public List<Order> pageList(Map<String,Object> map);
	
	/**
	 * 模糊查询总条数
	 * @param title
	 * @return
	 */
	public int getTitleCount(String title);
	/**
	 * 根据id查询客户消费信息
	 * @param m_id
	 * @return
	 */
	public  Order getAllOr(int m_id);
	
	/**
	 * 增加订单	
	 * @return
	 */
	public int addOrder(Order order);
	
	/**
	 * 统计查询
	 * @return
	 */
	public List<Order> selectStatis(Map<String,Object> map);
	public int getFinish();
	
	
	
}
