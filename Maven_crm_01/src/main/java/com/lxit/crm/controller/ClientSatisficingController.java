package com.lxit.crm.controller;

import java.text.DateFormat;
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

import com.lxit.crm.entities.ClientSatisficing;
import com.lxit.crm.entities.Client_allot;
import com.lxit.crm.entities.Client_member;
import com.lxit.crm.entities.Staff;
import com.lxit.crm.service.ClientSatisficingService;
import com.lxit.crm.util.Pager;

@Controller
@RequestMapping("/clientSatisficing")
public class ClientSatisficingController {
	@Autowired
    private ClientSatisficingService satisficingService;
	
	@ResponseBody
	@RequestMapping("/getSatisficing")
    public Map<String,Object> getSatisficing(HttpSession session,@RequestParam("page")int page,@RequestParam("rows")int rows){
		Staff staff=(Staff) session.getAttribute("staff");
		int id=staff.getSid();
		Pager<ClientSatisficing> pager=satisficingService.getPlanss(id,page,rows);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", pager.getData());
		map.put("total",pager.getSumSize());
    	return map;
    }
	
	@ResponseBody
	@RequestMapping("/updateSatisficing")
    public Map<String,Object> updateSatisficing(HttpSession session,int id,String take){
		Map<String, Object> map = new HashMap<String, Object>();
		ClientSatisficing satisficing=satisficingService.getSatisficing(id);
		String quality=satisficing.getQuality();
		String newQuality=quality.substring(0, quality.length()-1);
		satisficing.setQuality(newQuality);
		
		String serve=satisficing.getServe();
		String newServe=serve.substring(0, serve.length()-1);
		satisficing.setServe(newServe);
		
		String benefit=satisficing.getBenefit();
		String newBenefit=benefit.substring(0, benefit.length()-1);
		satisficing.setBenefit(newBenefit);
		
		String overall=satisficing.getOverall();
		String newOverall=overall.substring(0, overall.length()-1);
		satisficing.setOverall(newOverall);
		map.put("satisficing",satisficing);
		map.put("take",take);
    	return map;
    }
	
	@ResponseBody
	@RequestMapping("/addSatisficing")
    public Map<String,Object> addSatisficing(HttpSession session,String quality,String serve,String benefit,String overall,String feedback,int mid){
		Map<String, Object> map = new HashMap<String, Object>();
		ClientSatisficing satisficing2=new ClientSatisficing();
		satisficing2.setMid(mid);
		satisficing2.setQuality(quality+"%");
		satisficing2.setServe(serve+"%");
		satisficing2.setBenefit(benefit+"%");
		satisficing2.setOverall(overall+"%");
		satisficing2.setFeedback(feedback);
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String time=format.format(date);
		satisficing2.setTime(time);
		int i=satisficingService.addSatisficing(satisficing2);
		map.put("msg","增加成功！");
		return map;
    }
	
	@ResponseBody
	@RequestMapping("/deleteSatisficing")
    public Map<String,Object> deleteSatisficing(HttpSession session,int id){
		Map<String, Object> map = new HashMap<String, Object>();
		int i=satisficingService.deleteSatisficing(id);
		map.put("msg","删除成功！");
		return map;
    }
	
	@ResponseBody
	@RequestMapping("/queryMember")
    public Map<String,Object> queryMember(HttpSession session,String take){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Client_member> querymember = satisficingService.getMembers();
		session.setAttribute("querymember",querymember);
		map.put("take",take);
		return map;
    }
	
	@ResponseBody
	@RequestMapping("/queryMemberTwo")
    public ClientSatisficing queryMemberTwo(HttpSession session,int mid){
		ClientSatisficing sa=satisficingService.getMembersTwo(mid);
		session.setAttribute("samid",sa.getMid());
		return sa;
    }
	
	@ResponseBody
	@RequestMapping("/update")
    public Map<String,Object> update(HttpSession session,String quality,String serve,String benefit,String overall,String feedback,int mid){
		Map<String, Object> map = new HashMap<String, Object>();
		ClientSatisficing cs=new ClientSatisficing();
		cs.setQuality(quality+"%");
		cs.setServe(serve+"%");
		cs.setBenefit(benefit+"%");
		cs.setOverall(overall+"%");
		cs.setMid(mid);
		int i=satisficingService.updateSatisficing(cs);
		map.put("msg", "修改成功！");
		return map;
    }
	
	
}
