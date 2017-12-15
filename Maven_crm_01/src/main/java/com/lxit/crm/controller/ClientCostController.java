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

import com.lxit.crm.entities.Client_allot;
import com.lxit.crm.entities.Client_cost;
import com.lxit.crm.entities.Client_member;
import com.lxit.crm.entities.Client_order;
import com.lxit.crm.entities.Client_orders;
import com.lxit.crm.entities.Order;
import com.lxit.crm.entities.Staff;
import com.lxit.crm.service.ClientCostService;
import com.lxit.crm.util.Pager;

@Controller
@RequestMapping("/clientCost")
public class ClientCostController {
	@Autowired
	private ClientCostService costService;
	
	@ResponseBody
	@RequestMapping("/getCosts")
    public Map<String,Object> getCosts(HttpSession session,@RequestParam("page")int page,@RequestParam("rows")int rows){
		Staff staff=(Staff) session.getAttribute("staff");
		int id=staff.getSid();
		Pager<Client_cost> pager=costService.getPlanss(id,page,rows);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", pager.getData());
		map.put("total",pager.getSumSize());
    	return map;
	}
	
	@ResponseBody
	@RequestMapping("/getMember")
    public Map<String,Object> getMember(HttpSession session,int mid){
		Client_member members=costService.getMmember(mid);
		List<Client_orders> orders=costService.getMorder(mid);
		for (Client_orders order : orders) {
			String os=order.getOstatus();
			if("0".equals(os)){
				order.setOstatus("等待付款");
			}else if("1".equals(os)){
				order.setOstatus("等待自提");
			}
			else if("2".equals(os)){
				order.setOstatus("等待收货");
			}
			else if("3".equals(os)){
				order.setOstatus("已完成");
			}else if("4".equals(os)){
				order.setOstatus("已取消");
			}
		}
		session.setAttribute("members", members);
		session.setAttribute("orders", orders);
		Map<String, Object> map = new HashMap<String, Object>();
    	return map;
	}
}
