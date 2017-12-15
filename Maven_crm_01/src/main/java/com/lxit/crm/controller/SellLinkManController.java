package com.lxit.crm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lxit.crm.entities.Linkman;
import com.lxit.crm.entities.SellPlan;
import com.lxit.crm.entities.Staff;
import com.lxit.crm.service.SellLinkManService;

@Controller
@RequestMapping("sellLinkMan")
public class SellLinkManController {

	private SellLinkManService linkManService;

	private Staff staff;
	
	public SellLinkManService getLinkManService() {
		return linkManService;
	}
	

	@Resource
	public void setLinkManService(SellLinkManService linkManService) {
		this.linkManService = linkManService;
	}
	
	@ResponseBody
	@RequestMapping("/getPageData")
	public Map<String,Object> checkCoding(@RequestParam("page")int page,@RequestParam("rows")int rows,@RequestParam(value="like",required=false)String like,HttpSession session){
		staff = (Staff) session.getAttribute("staff");
		Map<String,Object> pages = new HashMap<String,Object>();
		pages.put("page", page);
		pages.put("row", rows);
		pages.put("like", like);
		pages.put("eid", staff.getSid());
		pages = linkManService.pageQuery(pages);
	

		return pages;
		
	}
	
	
	@RequestMapping("/goSellLinkMan")
	public String goSellPlan(){
		return "sellLinkMan";
	}
	
	@RequestMapping("/addSellLinkMan")
	public String goAdd(@RequestParam(value="id",required=false)int id,@RequestParam(value="operation",required=false)String operation,Model model){
		Linkman lm = new Linkman();
		if(id!=0){
			
			lm = linkManService.getLinkMan(id);
			if("query".equals(operation)){
				model.addAttribute("linkMan", lm);
				return "sellLinkManQuery";
			}
		}
		model.addAttribute("linkMan", lm);
		return "sellLinkManAdd";
		
	}
	
	@RequestMapping("/addSellLinkManPost")
	public String addPost(Linkman linkman,HttpSession session){
		staff = (Staff) session.getAttribute("staff");
		if(null!=linkman.getId()&&linkman.getId()>0){
			try {
				linkManService.update(linkman);
			} catch (Exception e) {
				return "false";
			}
			return "true";
		}else{
			linkman.setEnteringManId(staff.getSid());
			linkman.setEnteringDate(getDateTime());
			int lid = linkManService.save(linkman);
			if(lid>0){
				return "true";
			}
			return "false";
		}
		
		
	}
	
	
	@RequestMapping("/delSellLinkMan")
	public String del(@RequestParam(value="id",required=false)int id){
		try {
			linkManService.delete(id);
		} catch (Exception e) {
			return "false";
		}
		return "true";		
	}
	
	
	/*@RequestMapping("/updateSellLinkMan")
	public String goUpdate(@RequestParam("id")int id,Model model){
		Linkman lm = linkManService.getLinkMan(id);
		model.addAttribute("linkMan", lm);
		return "sellLinkManAdd";
	}*/
	
	
	public String getDateTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = sdf.format(new Date());
		return time;
	}
}
