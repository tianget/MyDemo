package com.lxit.crm.service;

import java.util.List;
import java.util.Map;

import com.lxit.crm.entities.OrderGoods;


public interface OrderGoodsService {
	/**
	 * 分页查询所有订单
	 * @return
	 */
	public List<OrderGoods> selectOrder(Map<String, Object> map);
	/**
	 * 模糊查询总条数
	 * @param title
	 * @return
	 */
	public int getTitleGout(String title);
	
	public int selCounts();
	
	/**
	 * 查询订单详细信息
	 * @param oid
	 * @return
	 */
	public OrderGoods selectAllOrder(int oid);
	
	public List<OrderGoods> glist();
	
	/**
	 * 根据订单id查询商品
	 * @param oid
	 * @return
	 */
	public List<OrderGoods> selectById(int oid);
	
	/**
	 * 增加商品订单中间表
	 * @param orderGoods
	 * @return
	 */
	public boolean addGoodsOrder(OrderGoods orderGoods);
	
	/**
	 * 根据id修改订单状态
	 * @param id
	 * @return
	 */
	public boolean updateSta(int id);
}
