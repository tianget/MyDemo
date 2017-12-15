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

import com.lxit.crm.entities.ClientLoving;
import com.lxit.crm.entities.ClientRemind;
import com.lxit.crm.entities.ClientScheme;
import com.lxit.crm.entities.Client_allot;
import com.lxit.crm.entities.Client_order;
import com.lxit.crm.entities.Staff;
import com.lxit.crm.service.ClientLovingService;
import com.lxit.crm.util.Pager;

@Controller
@RequestMapping("clientLoving")
public class ClientLovingController {
	@Autowired
    private ClientLovingService lovingService;
	
	@ResponseBody
	@RequestMapping("/getLoving")
	public Map<String,Object> getAllots(HttpSession session,@RequestParam("page")int page,@RequestParam("rows")int rows){
		Staff staff=(Staff) session.getAttribute("staff");
		int id=staff.getSid();
		Pager<ClientLoving> pager=lovingService.getPlanss(id,page,rows);
		List<ClientLoving> lovings=pager.getData();
		for (ClientLoving clientLoving : lovings) {
			if(clientLoving.getCount()<100000){
				clientLoving.setCount(1);
			}else if(100000<clientLoving.getCcount()&&clientLoving.getCount()<=200000){
				clientLoving.setCount(2);
			}
			else if(200000<clientLoving.getCcount()&&clientLoving.getCount()<=300000){
				clientLoving.setCount(3);
			}
			else if(300000<clientLoving.getCcount()&&clientLoving.getCount()<=400000){
				clientLoving.setCount(4);
			}
			else if(400000<clientLoving.getCcount()&&clientLoving.getCount()<=500000){
				clientLoving.setCount(5);
			}else{
				clientLoving.setCount(6);
			}
			
			if("".equals(clientLoving.getScheme())||clientLoving.getScheme()==""||clientLoving.getScheme()==null){
				clientLoving.setScheme("无");
			}
			if("".equals(clientLoving.getOverall())||clientLoving.getOverall()==""||clientLoving.getOverall()==null){
				clientLoving.setOverall("无");
			}
			
			String abcd="";
			double count=(clientLoving.getCcount()*1.0)/((clientLoving.getAcount()+clientLoving.getCcount())*1.0);
				if(count<0.2){
					abcd="A";
				}else if(count>=0.2&&count<=0.6){
					abcd="B";
				}else if(count>0.6&&count<=0.8){
					abcd="C";
				}else{
					abcd="D";
				}
			if("A".equals(abcd)||"B".equals(abcd)||"C".equals(abcd)||"D".equals(abcd)){
			}else{
				abcd="A";
			}
			clientLoving.setAbcd(abcd);
			
			
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", lovings);
		map.put("total",pager.getSumSize());
    	return map;
    }
	
	@ResponseBody
	@RequestMapping("/getLovs")
	public Map<String,Object> getLovs(HttpSession session,@RequestParam("page")int page,@RequestParam("rows")int rows){
		System.out.println("```````````1`````````");
		int mid=(int) session.getAttribute("lovMid");
		Pager<ClientRemind> pager=lovingService.getPageLovd(mid,page,rows);
		List<ClientRemind> lovings=pager.getData();
		for (ClientRemind clientRemind : lovings) {
			System.out.println("clientRemind:"+clientRemind);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", lovings);
		map.put("total",pager.getSumSize());
    	return map;
    }
	
	@ResponseBody
	@RequestMapping("/getLovd")
	public Map<String,Object> getLovd(HttpSession session,@RequestParam("page")int page,@RequestParam("rows")int rows){
		int mid=(int) session.getAttribute("lovMid");
		Pager<ClientScheme> pager=lovingService.getPageLovdd(mid,page,rows);
		List<ClientScheme> lovings=pager.getData();
		for (ClientScheme clientRemind : lovings) {
			System.out.println("ClientScheme:"+clientRemind);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", lovings);
		map.put("total",pager.getSumSize());
    	return map;
    }
	
	
	@ResponseBody
	@RequestMapping("/getMid")
	public Map<String,Object> getMid(HttpSession session,int mid,String name,String sex,String type,String count,String overall,String abcd){
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("mid:"+mid+",name:"+name+",sex:"+sex+",type:"+type+",count:"+count+",overall:"+overall+",abcd:"+abcd);
		session.setAttribute("lovMid", mid);
		session.setAttribute("lovName", name);
		session.setAttribute("lovSex", sex);
		session.setAttribute("lovType", type);
		session.setAttribute("lovCount", count);
		session.setAttribute("lovOverall", overall);
		session.setAttribute("lovAbcd", abcd);
    	return map;
    }
	
	@ResponseBody
	@RequestMapping("/addLovd")
	public Map<String,Object> addLovd(HttpSession session,int mid,String name,String time,String fa,String jg,String xx){
		Map<String, Object> map = new HashMap<String, Object>();
		ClientScheme cs=new ClientScheme();
		cs.setMid(mid);
		cs.setName(name);
		cs.setDate(time);
		cs.setScheme(fa);
		cs.setFinallys(jg);
		cs.setRemark(xx);
		System.out.println(cs);
		int i=lovingService.addLovd(cs);
		System.out.println("i:"+i);
		map.put("msg","增加成功！");
    	return map;
    }
	
	@ResponseBody
	@RequestMapping("/update")
	public Map<String,Object> update(HttpSession session,int mid,int scid,String name,String time,String fa,String jg,String xx){
		Map<String, Object> map = new HashMap<String, Object>();
		ClientScheme cs=new ClientScheme();
		cs.setScid(scid);
		cs.setMid(mid);
		cs.setName(name);
		cs.setDate(time);
		cs.setScheme(fa);
		cs.setFinallys(jg);
		cs.setRemark(xx);
		int i=lovingService.updateLovd(cs);
		System.out.println("i:"+i);
		map.put("msg","修改成功！");
		map.put("cs",cs);
    	return map;
    }
	
	@ResponseBody
	@RequestMapping("/del")
	public Map<String,Object> del(HttpSession session,int scid){
		Map<String, Object> map = new HashMap<String, Object>();
		int i=lovingService.delLovd(scid);
		System.out.println("i:"+i);
		map.put("msg","删除成功！");
    	return map;
    }
}
