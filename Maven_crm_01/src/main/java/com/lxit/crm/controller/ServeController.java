package com.lxit.crm.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lxit.crm.entities.Client_member;
import com.lxit.crm.entities.Serve;
import com.lxit.crm.entities.Servereplenish;
import com.lxit.crm.entities.Staff;
import com.lxit.crm.service.ServeService;
import com.lxit.crm.util.Pager;

@Controller
@RequestMapping("/serve")
public class ServeController {
	
	@Resource
	ServeService serveService;
	public ServeService getServeService() {
		return serveService;
	}
	public void setServeService(ServeService serveService) {
		this.serveService = serveService;
	}

	@RequestMapping("/serve")
	public String create(){
		return "serve";
	}
	@RequestMapping("/allot")
	public String allot(){//除了新创建以外的都可以查，要是自己部门自己创建和代表创建
		return "serveAllot";
	}
	@RequestMapping("/handle")
	public String handle(){//得到服务分配的销售代表，还要判断用户
		return "serveHandle";
	}
	@RequestMapping("/tickling")
	public String tickling(){//要判断待处理人的自己才可以
		return "serveTickling";
	}
	@RequestMapping("/file")
	public String file(){// 销售代表  销售经理
		return "serveFile";
	}
	
	/*
	 * 服务管理分页
	 */
	@ResponseBody
	@RequestMapping("/getServePage")
	public Map<String,Object> getServePage(@RequestParam("page") int pageIndex,@RequestParam("rows")int pageSize,
			Serve serve,String status,HttpSession session){
		//非销售代表和销售经理，可以查看所有，只有查看功能
		Staff staff = (Staff) session.getAttribute("staff");
		String serverole = (String) session.getAttribute("serverole");
		Map<String, Object> map = new HashMap<>();
		if(staff != null){
			serve.setScreater(staff.getSid().toString());;
		}
		
		Pager<Serve> pager = null;
		System.out.println("serverole:"+serverole);
		if("销售用户".equals(serverole)){
			pager = serveService.servicePage(pageIndex, pageSize,serve,status);
		}else{
			pager = serveService.serveRolePage(pageIndex, pageSize,serve,status);
		}
		List<Serve> list = pager.getData();
		map.put("rows", list);
		map.put("total",pager.getSumSize());
		serve=null;
		return map;
	}
	
	@RequestMapping("/serveCreate")
	public String intoServecreate(Servereplenish servereplenish){
		return "serveCreate";
	}
	
	/*
	 * 新增服务单据
	 */
	@ResponseBody
	@RequestMapping("/saveServeCreate")
	public Map<String,Object> saveServecreate(Servereplenish servereplenish,HttpSession session){
		Staff staff = (Staff) session.getAttribute("staff");
		servereplenish.getServe().setStaff(staff);
		boolean flag=true;
		Client_member client=serveService.getClientPhone(Integer.parseInt(servereplenish.getSclient()));
		servereplenish.setSclient(client.getName());
		if(!serveService.create(servereplenish)){
			flag=false;
		}
		Map<String, Object> map = new HashMap<>();
		map.put("status", flag);
		return map;
	}
	
	/*
	 * 提交服务单据
	 */
	@ResponseBody
	@RequestMapping("/submitServe")
	public boolean submitServe(@RequestParam int[] ids){
		boolean flag=true;
		Map<String, Object> map = new HashMap<>();
		map.put("status", "已提交");
		for(int i=0;i<ids.length;i++){
			map.put("sid", ids[i]);
			flag=serveService.updateServeStatus(map);
		}
		return true;
	}
	
	/*
	 * 查看服务单据信息
	 */
	@ResponseBody
	@RequestMapping("/serveLookInfo")
	public Map<String,Object> testServeLook(String sid){
		Servereplenish servereplenish = serveService.lookServeById(Integer.parseInt(sid));
		Map<String, Object> map = new HashMap<>();
		map.put("data", servereplenish);
		return map;
	}
	
	@RequestMapping("/serveLook")
	public String intoServelook(){
		return "serveLook";
	}
	
	/*
	 * 修改服务单据，标题，客户不可修改
	 */
	@ResponseBody
	@RequestMapping("/updateServe")
	public boolean updateServe(Servereplenish servereplenish,Serve serve){
		Map<String, Object> map = new HashMap<>();
		map.put("stype", serve.getStype());
		map.put("sid", serve.getSid());
		serveService.updateServeStatus(map);
		servereplenish.setServe(serve);
		serveService.updateServereplenish(servereplenish);
		return true;
	}
	
	/*
	 * 删除服务单据
	 */
	@ResponseBody
	@RequestMapping("/deleteServe")
	public Map<String,Object> deleteServe(@RequestParam int[] ids){	
		for(int i=0;i<ids.length;i++){
			serveService.deleteCallServe(ids[i]);
		}
		Map<String,Object> map = new HashMap<>();
		map.put("status", true);
		map.put("num", ids.length);
		return map;
	}
	
	/*
	 * 服务归档
	 */
	
	@ResponseBody
	@RequestMapping("/serveFile")
	public boolean serveFile(@RequestParam int[] ids){
		boolean flag=true;
		Map<String, Object> map = new HashMap<>();
		map.put("status", "已归档");
		for(int i=0;i<ids.length;i++){
			map.put("sid", ids[i]);
			flag=serveService.updateServeStatus(map);
		}
		return true;
	}
	
	/*
	 * 服务反馈
	 */
	@ResponseBody
	@RequestMapping("/serveTickling")
	public boolean serveTickling(Servereplenish servereplenish,@RequestParam String sid){
		boolean flag=true;
		Serve serve = new Serve();
		if(!sid.equals("")){
			serve.setSid(Integer.parseInt(sid));
		}
		servereplenish.setServe(serve);
		if(serveService.updateServereplenish(servereplenish)){
			Map<String, Object> map = new HashMap<>();
			map.put("status", "已反馈");
			map.put("sid", sid);
			flag=serveService.updateServeStatus(map);
		}
		return flag;
	}
	
	/*
	 * 服务处理
	 */
	@ResponseBody
	@RequestMapping("/serveHandle")
	public boolean serveHandle(Servereplenish servereplenish,String sid){
		boolean flag=true;
		Serve serve = new Serve();
		serve.setSid(Integer.parseInt(sid));
		servereplenish.setServe(serve);
		if(serveService.updateServereplenish(servereplenish)){
			Map<String, Object> map = new HashMap<>();
			map.put("status", "已处理");
			map.put("sid", servereplenish.getServe().getSid());
			flag=serveService.updateServeStatus(map);
		}
		return flag;
	}
	
	/*
	 * 服务分配
	 */
	@ResponseBody
	@RequestMapping("/getAllStand")
	public List<Staff> getAllStand(HttpSession session){
		Staff staff=(Staff)session.getAttribute("staff");
		return serveService.getAllStand(staff.getSid());
	}
	
	@ResponseBody
	@RequestMapping("/serveAllot")
	public boolean serveAllot(Serve serve,HttpSession session){
		Staff staff = (Staff) session.getAttribute("staff");
		if(staff != null){
			serve.setShandler(staff.getSid().toString());
		}
		Map<String, Object> map = new HashMap<>();
		map.put("status", "已分配");
		map.put("sid", serve.getSid());
		if(serveService.serveAllot(serve)){
			return serveService.updateServeStatus(map);
		}else{
			return false;
		}
	}
	
	/*
	 * 客户  与    联系电话   二级联动
	 */
	@ResponseBody
	@RequestMapping("/getAllClient")
	public List<Client_member> getAllClient(){
		return serveService.getAllClient();
	}
	
	@ResponseBody
	@RequestMapping("/getClientPhone")
	public Client_member getClientPhone(@RequestParam int mid){
		return serveService.getClientPhone(mid);
	}
	
}
