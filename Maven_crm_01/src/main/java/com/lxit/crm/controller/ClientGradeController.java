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
import com.lxit.crm.entities.Client_grade;
import com.lxit.crm.entities.Client_order;
import com.lxit.crm.entities.Client_orders;
import com.lxit.crm.entities.Staff;
import com.lxit.crm.service.ClientGradeService;
import com.lxit.crm.util.Pager;

@Controller
@RequestMapping("clientGrade")
public class ClientGradeController {
	@Autowired
	private ClientGradeService gradeService;
    
	@ResponseBody
	@RequestMapping("getGrades")
	public Map<String,Object> getGrades(HttpSession session,@RequestParam("page")int page,@RequestParam("rows")int rows){
		Staff staff=(Staff) session.getAttribute("staff");
		int id=staff.getSid();
		Pager<Client_grade> pager=gradeService.getPlanss(id,page,rows);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", pager.getData());
		map.put("total",pager.getSumSize());
    	return map;
	}
	
	@ResponseBody
	@RequestMapping("get")
	public Map<String,Object> get(HttpSession session,int mid){
		Map<String, Object> map=new HashMap<String,Object>();
		Client_cost cost= gradeService.getMember(mid);
		List<Client_orders> orders=gradeService.getOrders(mid);
		for (Client_orders client_orders : orders) {
			String os=client_orders.getOstatus();
			if("0".equals(os)){
				client_orders.setOstatus("等待付款");
			}else if("1".equals(os)){
				client_orders.setOstatus("等待自提");
			}
			else if("2".equals(os)){
				client_orders.setOstatus("等待收货");
			}
			else if("3".equals(os)){
				client_orders.setOstatus("已完成");
			}else if("4".equals(os)){
				client_orders.setOstatus("已取消");
			}
		}
		map.put("cost", cost);
		session.setAttribute("cost", cost);
		map.put("orders",orders);
		session.setAttribute("orders", orders);
    	return map;
	}
}
