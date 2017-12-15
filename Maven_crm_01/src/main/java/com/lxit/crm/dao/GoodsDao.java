package com.lxit.crm.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import com.lxit.crm.entities.Goods;

/**
 * 商品管理
 * @author Administrator
 *
 */
@MapperScan
public interface GoodsDao {


	/**
	 * 分页查询
	 * @param map
	 * @return
	 */
	public List<Goods> pageGoodsList(Map<String,Object> map);
	
	/**
	 * 查询总条数
	 * @return
	 */
	public int getGoodsCount();
	
	/**
	 * 根据id查询商品
	 * @param id
	 * @return
	 */
	public Goods selectByGid(int id);
	
	/**
	 * 增加商品
	 * @param goods
	 * @return
	 */
	public void insertGoods(Goods goods);
	
	/**
	 * 删除商品
	 * @param id
	 * @return
	 */
	public int deleteGoods(int id);
	
	/**
	 * 根据id查询商品信息
	 * @param id
	 * @return
	 */
	public List<Goods> getSelectId(int id);
	

	
	
}
