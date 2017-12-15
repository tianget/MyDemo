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

import com.lxit.crm.entities.Client_allot;
import com.lxit.crm.entities.Client_member;
import com.lxit.crm.entities.Staff;
import com.lxit.crm.service.ClientAllotService;
import com.lxit.crm.util.Pager;

@Controller
@RequestMapping("/clientAllot")
public class ClientAllotController {
	@Autowired
	private ClientAllotService allotService;


	@ResponseBody
	@RequestMapping("/getAllots")
    public Map<String,Object> getAllots(HttpSession session,@RequestParam("page")int page,@RequestParam("rows")int rows){
		Staff staff=(Staff) session.getAttribute("staff");
		int id=staff.getSid();
		Pager<Client_allot> pager=allotService.getPlanss(id,page,rows);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", pager.getData());
		map.put("total",pager.getSumSize());
    	return map;
    }
	
	@ResponseBody
	@RequestMapping("/getAllotsQuery")
    public Map<String,Object> getAllotsQuery(HttpSession session,@RequestParam("page")int page,@RequestParam("rows")int rows){
		Staff staff=(Staff) session.getAttribute("staff");
		int id=staff.getSid();
		Pager<Client_allot> pager=allotService.getPlanss(id,page,rows);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", pager.getData());
		map.put("total",pager.getSumSize());
    	return map;
    }
	
	@ResponseBody
	@RequestMapping("/setMember")
    public String setMember(HttpSession session,String encode,String name,String sex,String birth,String type,String status,String phone,String workPhone,String email,String familyPhone,String address,String remarks){
		Map<String,Object> map=new HashMap<String,Object>();
		if(name==""){
			map.put("msg","请填写客户姓名！");
			return "请填写客户姓名！";
		}
		Client_member member=new Client_member();
		member.setEncode(encode);
		member.setName(name);
		member.setSex(sex);
		member.setBirth(birth);
		member.setType(type);
		member.setStatus(status);
		member.setPhone(phone);
		member.setWorkPhone(workPhone);
		member.setFamilyPhone(familyPhone);
		member.setEmail(email);
		member.setAddress(address);
		member.setRemarks(remarks);
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		member.setRecordDate(time);
		Staff sta=(Staff) session.getAttribute("staff");
		member.setSid(sta.getSid());
		allotService.setMember(member);
		Client_member me=allotService.getMember2(time);
		Client_allot all=new Client_allot();
		all.setMid(me.getMid());
		all.setStaffid(me.getSid());
		all.setCondition(me.getStatus());
		all.setAllot("未分配");
		all.setDate(time);
		allotService.addAllot(all);
		map.put("msg","增加成功");
		return "增加成功";
    }
	
	@ResponseBody
	@RequestMapping("/updateMember")
    public Map<String,Object> updateMember(HttpSession session,int mid){
		Map<String,Object> map=new HashMap<String,Object>();
		Client_member member=allotService.getMember(mid);
		session.setAttribute("member", member);
		return map;
    }
	
	@ResponseBody
	@RequestMapping("/updateMemberTwo")
    public Map<String,Object> updateMemberTwo(HttpSession session,int mid,String encode,String name,String sex,String birth,String type,String status,String phone,String workPhone,String email,String familyPhone,String address,String remarks){
		Map<String,Object> map=new HashMap<String,Object>();
		if(name==""){
			map.put("msg","客户姓名不能为空！");
			return map;
		}
		Client_member member=new Client_member();
		member.setMid(mid);
		member.setEncode(encode);
		member.setName(name);
		member.setSex(sex);
		member.setBirth(birth);
		member.setType(type);
		member.setStatus(status);
		member.setPhone(phone);
		member.setWorkPhone(workPhone);
		member.setFamilyPhone(familyPhone);
		member.setEmail(email);
		member.setAddress(address);
		member.setRemarks(remarks);
		int i=allotService.updateMember(member);
		session.removeAttribute("member");
		map.put("msg","修改成功");
		return map;
    }
	
	@ResponseBody
	@RequestMapping("/allotd")
    public Map<String,Object> allotd(HttpSession session,int mid){
		Map<String,Object> map=new HashMap<String,Object>();
		Staff st=(Staff) session.getAttribute("staff");
		int rid=st.getRid();
		if(rid==2){
			map.put("msg","权限不够！");
			return map;
		}
		session.setAttribute("mid", mid);
		return map;
    }
	
	@ResponseBody
	@RequestMapping("/getAllotd")
    public List<Staff> getAllotd(HttpSession session){
		List<Staff> sts=allotService.getStaff();
		return sts;
    }
	
	@ResponseBody
	@RequestMapping("/setAllotd")
    public int setAllotd(HttpSession session,int sid){
		int mid=(int) session.getAttribute("mid");
		Client_allot allot=new Client_allot();
		allot.setSid(sid);
		allot.setMid(mid);
		int i=allotService.setAllotd(allot);
		return i;
    }
}
