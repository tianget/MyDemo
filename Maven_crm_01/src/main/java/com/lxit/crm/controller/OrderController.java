package com.lxit.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lxit.crm.entities.Client_member;
import com.lxit.crm.entities.Order;
import com.lxit.crm.service.ClientMemberService;
import com.lxit.crm.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private ClientMemberService clientMemberService;

	@RequestMapping("/orderOf")
	public String orderOf() {
		return "orderOf";
	}

	@RequestMapping("/orderMember")
	public String orderMember() {
		return "orderMember";
	}

	@RequestMapping("/orderInquiry")
	public String orderInquiry() {
		return "orderInquiry";
	}

	@RequestMapping("/orderStatistics")
	public String orderStatistics() {
		return "orderStatistics";
	}

	@RequestMapping("/orderPlace")
	public String orderPlace() {
		return "orderPlace";
	}

	@RequestMapping("/orderFinal")
	public String orderFinal() {
		return "orderFinal";
	}

	@RequestMapping("/orderSelect")
	public String orderSelect() {
		return "orderSelect";
	}

	@RequestMapping("/orderStutas")
	public String orderStutas() {
		return "orderStutas";
	}

	// 分页查询
	@ResponseBody
	@RequestMapping("/pageList")
	public Map<String, Object> pageList(@RequestParam("page") int page, @RequestParam("rows") int rows,
			@RequestParam(value = "conteTitle", required = false) String conteTitle) {
		Map<String, Object> map = new HashMap<>();
		int pageIndex = (page - 1) * rows;
		map.put("pageIndex", pageIndex);
		map.put("pageSize", rows);
		Map<String, Object> maps = new HashMap<>();
		if (conteTitle != "" && conteTitle != null) {
			String title = "%" + conteTitle + "%";
			int count1 = orderService.getTitleCount(title);
			map.put("title", title);
			List<Order> list1 = orderService.pageList(map);
			maps.put("rows", list1);
			maps.put("total", count1);
		} else {
			int count = orderService.getCount();
			List<Order> list = orderService.pageList(map);
			maps.put("rows", list);
			maps.put("total", count);
		}
		return maps;
	}

	@RequestMapping("/getAllMember")
	public String getAllMember(@RequestParam("m_id") int id, HttpSession session) {
		Client_member member = clientMemberService.getAllMember(id);
		session.setAttribute("list", member);
		return "orderMember";
	}

	@RequestMapping("/getAllOr")
	public String getOrderAllTest(@RequestParam("m_id") int mid, HttpSession session) {
		Order order = orderService.getAllOr(mid);
		session.setAttribute("list", order);
		return "orderPlace";
	}

	// 订单统计
	@ResponseBody
	@RequestMapping("/getBaseSta")
	public Map<String, Object> getBaseSta(@RequestParam("page") int page, @RequestParam("rows") int rows,
			@RequestParam(value = "conteTitle", required = false) String conteTitle) {
		Map<String, Object> map = new HashMap<>();
		int pageIndex = (page - 1) * rows;
		map.put("pageIndex", pageIndex);
		map.put("pageSize", rows);
		Map<String, Object> maps = new HashMap<>();
		if (conteTitle != "" && conteTitle != null) {
			String title = conteTitle.substring(0, conteTitle.lastIndexOf("-"));
			map.put("title1", title);
			List<Order> list1 = orderService.selectStatis(map);
			int count1 = list1.size();
			maps.put("rows", list1);
			maps.put("total", count1);
		} else {
			List<Order> list = orderService.selectStatis(map);
			int count = list.size();
			maps.put("rows", list);
			maps.put("total", count);
		}
		return maps;
	}

	/**
	 * Map<String, Object> maps = new HashMap<>(); if (conteTitle != "" &&
	 * conteTitle != null) { System.out.println("conteTitle----" + conteTitle);
	 * String title = "%" + conteTitle + "%"; map.put("title", title); List
	 * <Order> list1 = orderService.selectStatis(map); maps.put("rows", list1);
	 * maps.put("total", list1.size()); } else { List<Order> list =
	 * orderService.selectStatis(map); int count = list.size(); maps.put("rows",
	 * list); maps.put("total", count); }
	 */
}
