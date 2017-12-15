package com.lxit.crm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxit.crm.dao.GoodsDao;
import com.lxit.crm.entities.Goods;
import com.lxit.crm.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService{
	
	@Autowired
	private GoodsDao goodsDao;


	@Override
	public Goods selectByGid(int id) {
		return goodsDao.selectByGid(id);
	}

	@Override
	public void insertGoods(Goods goods) {
		goodsDao.insertGoods(goods);
	}

	@Override
	public int deleteGoods(int id) {
		return goodsDao.deleteGoods(id);
	}

	@Override
	public List<Goods> pageGoodsList(Map<String, Object> map) {
		return goodsDao.pageGoodsList(map);
	}

	@Override
	public int getGoodsCount() {
		return goodsDao.getGoodsCount();
	}

	@Override
	public List<Goods> getSelectId(int id) {
		return goodsDao.getSelectId(id);
	}

}
