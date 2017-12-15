package com.lxit.crm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxit.crm.dao.OrderGoodsDao;
import com.lxit.crm.entities.OrderGoods;
import com.lxit.crm.service.OrderGoodsService;
import com.whalin.MemCached.MemCachedClient;

@Service
public class OrderGoodsServiceImpl implements OrderGoodsService{

	@Autowired
	private OrderGoodsDao orderGoodsDao;
	
	/*@Autowired
	private MemCachedClient memCachedClient;*/

	@Override
	public List<OrderGoods> selectOrder(Map<String, Object> map) {
		/*int rows = (int) map.get("rows");
		int page = (int) map.get("page");
		String like = (String) map.get("like");
		*/
			return orderGoodsDao.selectOrder(map);
		
		
		
	}

	@Override
	public OrderGoods selectAllOrder(int oid) {
		return orderGoodsDao.selectAllOrder(oid);
	}

	@Override
	public List<OrderGoods> selectById(int oid) {
		return orderGoodsDao.selectById(oid);
	}

	@Override
	public List<OrderGoods> glist() {
		return orderGoodsDao.glist();
	}

	@Override
	public int selCounts() {
		return orderGoodsDao.selCounts();
	}

	@Override
	public boolean addGoodsOrder(OrderGoods orderGoods) {
		orderGoodsDao.addGoodsOrder(orderGoods);
		return true;
	}

	@Override
	public int getTitleGout(String title) {
		return orderGoodsDao.getTitleGout(title);
	}

	@Override
	public boolean updateSta(int id) {
		orderGoodsDao.updateSta(id);
		return true;
	}
}
