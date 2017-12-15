package com.lxit.crm.service.impl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxit.crm.dao.OrderDao;
import com.lxit.crm.entities.Order;
import com.lxit.crm.service.OrderService;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;



/**
 * 订单管理
 * 
 * @author Administrator
 *
 */

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;

	@Override
	public int getCount() {
		return orderDao.getCount();
	}

	@Override
	public List<Order> pageList(Map<String, Object> map) {
		return orderDao.pageList(map);
	}

	@Override
	public int getTitleCount(String title) {
		return orderDao.getTitleCount(title);
	}

	@Override
	public Order getAllOr(int m_id) {
		return orderDao.getAllOr(m_id);
	}

	@Override
	public int addOrder(Order order) {

		return orderDao.addOrder(order);
	}

	@Autowired
	private MemcachedClient memcachedClient;

	//使用缓存
	@Override
	public List<Order> selectStatis(Map<String, Object> map) {		
		int rows = (int) map.get("pageIndex");
		int tatle = (int) map.get("pageSize");
		String conteTitle = (String) map.get("title1");
		conteTitle = conteTitle==null?"%%":"%"+conteTitle+"%";
		String key1 = "order"+rows+conteTitle+tatle;
		
		List<Order> orlist = null;
		try {
			orlist = memcachedClient.get(key1);
			if(orlist==null){
				orlist = orderDao.selectStatis(map);
				/*for (Order order : orlist) {
					if(order.getTim().contains(conteTitle)){
						
					}
				}*/
				memcachedClient.set(key1, 900, orlist);
			}
			
		} catch (TimeoutException e) {			
			e.printStackTrace();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		} catch (MemcachedException e) {			
			e.printStackTrace();
		}		
		return orlist;		
	}

	@Override
	public int getFinish() {
		return orderDao.getFinish();
	}

}
