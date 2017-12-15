package com.lxit.crm.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lxit.crm.dao.ClientPlanDao;
import com.lxit.crm.entities.ClientPlan;
import com.lxit.crm.entities.Client_allot;
import com.lxit.crm.entities.Client_member;
import com.lxit.crm.entities.Serve;
import com.lxit.crm.entities.Staff;
import com.lxit.crm.service.ClientPlanService;
import com.lxit.crm.util.Pager;

@Controller
@RequestMapping("/clientPlan")
public class ClientPlanController {
	@Autowired
	private ClientPlanService planService;

	@ResponseBody
	@RequestMapping("/getPlans")
    public Map<String,Object> getPlans(HttpSession session,@RequestParam("page")int page,@RequestParam("rows")int rows){
		Staff staff=(Staff) session.getAttribute("staff");
		int id=staff.getSid();
		Pager<ClientPlan> pager=planService.getPlanss(id,page,rows);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", pager.getData());
		map.put("total",pager.getSumSize());
    	return map;
    }
	
	@ResponseBody
	@RequestMapping("/getDate")
    public List<ClientPlan> getDate(HttpSession session,String month){
		Staff staff=(Staff) session.getAttribute("staff");
		month=month.substring(0,7);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("id", staff.getSid());
		map.put("month", month);
		List<ClientPlan> plans=planService.getDate(map);
    	return null;
    }
	
	@ResponseBody
	@RequestMapping("/setPlan")
    public Map<String,Object> setPlan(HttpSession session,String encode,String name,String month,String details){
		Map<String,Object> map=new HashMap<String,Object>();
		if(name==""){
			map.put("msg","请填写计划人姓名！");
			return map;
		}
		ClientPlan plan=new ClientPlan();
		plan.setEncode(encode);
		plan.setName(name);
		plan.setMonth(month);
		plan.setDetails(details);
		plan.setType("已创建");
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		plan.setInitdate(time);
		plan.setFinishdate(time);
		Staff staff=(Staff) session.getAttribute("staff");
		plan.setS_id(staff.getSid());
		int i=planService.setPlan(plan);
		map.put("msg","增加成功！");
		return map;
    }
	
	@ResponseBody
	@RequestMapping("/updatePlan")
    public Map<String,Object> updatePlan(HttpSession session,int id){
		Map<String,Object> map=new HashMap<String,Object>();
		ClientPlan plan=planService.getPlan(id);
		session.setAttribute("plan", plan);
    	return map;
    }
	
	@ResponseBody
	@RequestMapping("/updatePlan2")
    public Map<String,Object> updatePlan2(HttpSession session,String encode,String name,String month,String details){
		Map<String,Object> map=new HashMap<String,Object>();
		ClientPlan plan2=(ClientPlan) session.getAttribute("plan");
		ClientPlan plan=new ClientPlan();
		plan.setId(plan2.getId());
		plan.setEncode(encode);
		plan.setName(name);
		plan.setMonth(month);
		plan.setDetails(details);
		int i=planService.updatePlan(plan);
    	return map;
    }
	
	@ResponseBody
	@RequestMapping("/delete")
    public Map<String,Object> delete(HttpSession session,int id){
		Map<String,Object> map=new HashMap<String,Object>();
		int i=planService.delete(id);
		map.put("msg","删除成功！");
    	return map;
    }
}
