package com.lxit.crm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lxit.crm.entities.Goods;
import com.lxit.crm.goods.GoodsServiceImpl;
import com.lxit.crm.goods.GoodsServiceImplService;
import com.lxit.crm.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {

	@RequestMapping("/orderGoods")
	public String orderGoods() {
		return "orderGoods";
	}

	@Autowired
	private GoodsService goodsService;

	@RequestMapping("/insertGoods")
	public String insertGoods(Goods goods) {
		goodsService.insertGoods(goods);
		return "orderGoods";
	}

	@RequestMapping("/deleteGoods")
	public String deleteGoods(int gid) {
		goodsService.deleteGoods(gid);
		return "orderGoods";
	}

	// 调用goods接口
	@ResponseBody
	@RequestMapping("/pageGoodsList")
	public Map<String, Object> pageGoodsList(@RequestParam("page") int page, @RequestParam("rows") int rows) {
		Map<String, Object> map = new HashMap<>();
		GoodsServiceImpl goodsIm = new GoodsServiceImplService().getGoodsServiceImplPort();
		int pageIndex = (page - 1) * rows;
		map.put("pageIndex", pageIndex);
		map.put("pageSize", rows);
		int count = goodsService.getGoodsCount();
		List<Goods> list = goodsService.pageGoodsList(map);
		Map<String, Object> maps = new HashMap<>();
		maps.put("rows", list);
		maps.put("total", count);
		return maps;
	}

	@ResponseBody
	@RequestMapping("/getSelectIdTe")
	public List<Goods> getSelectIdTe(String ts, String m, HttpSession session) {

		String ids[] = ts.split(",");
		String mm[] = m.split(",");
		List<Goods> good = new ArrayList<Goods>();
		double total = 0;
		for (int i = 0; i < ids.length; i++) {
			int id = Integer.parseInt(ids[i]);
			List<Goods> g = goodsService.getSelectId(id);
			Goods go = g.get(0);
			int t = Integer.parseInt(mm[i]);
			go.setPeopleNum(mm[i]);
			good.add(go);
			total += (go.getGprice() * t * 100);
		}

		session.setAttribute("to", total);
		session.setAttribute("good", good);
		return good;
	}

}
