package com.lxit.crm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lxit.crm.entities.Order;
import com.lxit.crm.entities.OrderGoods;
import com.lxit.crm.service.OrderGoodsService;
import com.lxit.crm.service.OrderService;

@Controller
@RequestMapping("/orderGoods")
public class OrderGoodsController {

	@Autowired
	private OrderGoodsService orderGoodsService;

	@Autowired
	private OrderService orderService;

	// 查询所有订单
	@ResponseBody
	@RequestMapping("/getAllOrder")
	public Map<String, Object> getAllOrder(@RequestParam("page") int page, @RequestParam("rows") int rows,
			@RequestParam(value = "conteTitle", required = false) String conteTitle,
			@RequestParam(value = "ts", required = false) Integer ts,
			@RequestParam(value = "begin", required = false) String begin) {
		Map<String, Object> map = new HashMap<String, Object>();
		int pageIndex = (page - 1) * rows;
		map.put("pageIndex", pageIndex);
		map.put("pageSize", rows);
		Map<String, Object> maps = new HashMap<>();
		if (conteTitle != "" && conteTitle != null) {
			String title = "%" + conteTitle + "%";

			map.put("title", title);
			List<OrderGoods> orderList1 = orderGoodsService.selectOrder(map);
			maps.put("rows", orderList1);
			maps.put("total", orderList1.size());
		} else if (begin != "" && begin != null) {
			String tst = "%" + begin + "%";

			map.put("tst", tst);
			List<OrderGoods> orderList2 = orderGoodsService.selectOrder(map);
			maps.put("rows", orderList2);
			maps.put("total", orderList2.size());
		} else if (ts != null) {
			int me = ts;

			map.put("me", me);
			List<OrderGoods> orderList3 = orderGoodsService.selectOrder(map);
			maps.put("rows", orderList3);
			maps.put("total", orderList3.size());
		} else {

			int count = orderGoodsService.selCounts();
			List<OrderGoods> orderList = orderGoodsService.selectOrder(map);
			maps.put("rows", orderList);
			maps.put("total", count);

		}
		return maps;
	}

	// 根据id查询订单的详细信息
	@RequestMapping("/getGoodsAll")
	public String getGoodsAll(@RequestParam("id") int id, HttpSession session) {

		OrderGoods goods = orderGoodsService.selectAllOrder(id);
		session.setAttribute("list", goods);

		return "orderSelect";
	}

	// 根据id查询订单的详细信息
	@RequestMapping("/getGoodsStutas")
	public String getGoodsStutas(@RequestParam("id") int id, HttpSession session) {
		orderGoodsService.updateSta(id);
		Order order = new Order();
		order.setOstatus(3 + "");
		System.out.println("------" + order.getOstatus());
		session.setAttribute("list", order);
		return "orderSelect";
	}

	@ResponseBody
	@RequestMapping("/getAll")
	public List<OrderGoods> getAll() {
		List<OrderGoods> orderList = orderGoodsService.glist();
		return orderList;
	}

	// 根据id查某个订单内的商品
	@ResponseBody
	@RequestMapping("/getGoodsOrderByid")
	public List<OrderGoods> getGoodsOrderByid(@RequestParam("id") int o_id, HttpSession session) {
		List<OrderGoods> list = orderGoodsService.selectById(o_id);
		return list;
	}

	@ResponseBody
	@RequestMapping("/getGoodsOrderAll")
	public boolean getGoodsOrderAll(String opayment, String otype, String oinvoice, int m_id, int gid, int order_number,
			String order_money, HttpSession session) {
		Order order = new Order();
		int number = (int) (11111111 + Math.random() * (999999999 - 1 + 1));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = sdf.format(new Date());
		order.setOtime(time);
		order.setOtype(otype);
		order.setOinvoice(oinvoice);
		order.setOpayment(opayment);
		order.setOstatus(1 + "");
		order.setUserid(m_id);
		order.setOnum(number);
		int oid = orderService.addOrder(order);

		OrderGoods goodsOrder = new OrderGoods();
		goodsOrder.setOrder_money(order_money);
		goodsOrder.setOrder_number(order_number);
		goodsOrder.setGid(gid);
		goodsOrder.setOid(order.getOid());
		orderGoodsService.addGoodsOrder(goodsOrder);

		return true;
	}
}
