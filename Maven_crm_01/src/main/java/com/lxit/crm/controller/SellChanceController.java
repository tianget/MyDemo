package com.lxit.crm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lxit.crm.entities.Linkman;
import com.lxit.crm.entities.SellChance;
import com.lxit.crm.entities.SellPlan;
import com.lxit.crm.entities.Staff;
import com.lxit.crm.service.SellChanceService;
import com.lxit.crm.service.SellLinkManService;

@Controller
@RequestMapping("sellChance")
public class SellChanceController {

	private SellChanceService sellChanceService;

	private Staff staff;
	
	
	
	public SellChanceService getSellChanceService() {
		return sellChanceService;
	}

    @Resource
	public void setSellChanceService(SellChanceService sellChanceService) {
		this.sellChanceService = sellChanceService;
	}
    
    @RequestMapping("/goSellChance")
	public String goSellPlan(){
		return "sellChance";
	}

    @ResponseBody
    @RequestMapping("/getPageData")
	public Map<String,Object> getData(@RequestParam("page")int page,@RequestParam("rows")int rows,@RequestParam(value="like",required=false)String like,HttpSession session){
		staff = (Staff) session.getAttribute("staff");
	
		Map<String,Object> pages = sellChanceService.pageQuery(page,rows,like,staff);

		return pages;
		
	}
    
    @RequestMapping("/addSellChanceAU")
	public String goAdd(@RequestParam(value="id",required=false)int id,@RequestParam(value="operation",required=false)String operation,HttpSession session,Model model){
    	staff = (Staff) session.getAttribute("staff");
    	SellChance sc = new SellChance();
		if(id!=0){
			sc = sellChanceService.getSellChance(id);
			if(!"update".equals(operation)){
				if(staff.getRid()==3&&"allot".equals(operation)){
					List<Staff> sts = sellChanceService.queryStaffs(staff.getSid());
					model.addAttribute("staffs", sts);
				}
				model.addAttribute("sellChance", sc);
				return "sellChanceQuery";
			}
		}
		model.addAttribute("sellChance", sc);
		return "sellChanceAU";
	}
    
    @ResponseBody
    @RequestMapping("/addSellChancePost")
	public String addPost(SellChance sellChance,HttpSession session){
		staff = (Staff) session.getAttribute("staff");
		sellChance.setLastUpdateManId(staff.getSid());
		sellChance.setLastUpdateDate(getDateTime());
		if(null!=sellChance.getId()&&sellChance.getId()>0){
			try {
				sellChanceService.update(sellChance);
			} catch (Exception e) {
				return "false";
			}
			return "true";
		}else{
			sellChance.setEnteringManId(staff.getSid());
			sellChance.setEnteringDate(getDateTime());
			sellChance.setState(0);
			int lid = sellChanceService.save(sellChance);
			if(lid>0){
				return "true";
			}
			return "false";
		}
		
		
	}
	@ResponseBody
    @RequestMapping("/allotSellChance")
    public String allotSellChance(@RequestParam(value="id",required=false)int id,@RequestParam(value="sid",required=false)int sid,HttpSession session){
    	staff = (Staff) session.getAttribute("staff");
    	SellChance sc = new SellChance();
    	sc.setId(id);
    	sc.setLastUpdateDate(getDateTime());
    	sc.setLastUpdateManId(staff.getSid());
    	sc.setState(1);
    	sc.setSid(sid);
    	sellChanceService.allotChance(sc);
    	return "true";
    }
	
	
	public String getDateTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = sdf.format(new Date());
		return time;
	}
}
