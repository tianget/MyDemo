package com.lxit.crm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lxit.crm.entities.SellPlan;
import com.lxit.crm.entities.Staff;
import com.lxit.crm.service.SellPlanService;

@Controller
@RequestMapping("sell")
public class SellPlanController {
       
	private SellPlanService sellPlanService;
	
	 Staff staff = null;
	
	@RequestMapping("/goSellPlan")
	public String goSellPlan(){
		return "sellPlan";
	}
	
	@RequestMapping("/delSellPlan")
	public String delSellPlan( @RequestParam("id") int id){
		try {
			sellPlanService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
	   return "true";
	}
	
	@RequestMapping("/updateSellPlanPost")
	public String updateSellPlanPost(SellPlan sellPlan){
		sellPlan.setLastOperationDate(getDateTime());
		try {
			sellPlanService.update(sellPlan);
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
	   return "true";
	}
	
	@RequestMapping("/goUpdateSellPlan")
	public String updateSellPlan(@RequestParam("coding") String coding,@RequestParam("oparation")String oparation,Model model){
		SellPlan sellPlan = sellPlanService.getPlanCoding(coding);
		model.addAttribute("sellPlan", sellPlan);
		if("update".equals(oparation)){
			return "sellPlanUpdate";
		}else{
			return "sellPlanQuery";
		}
	   
	}
	
	@ResponseBody
	@RequestMapping("/getPageData")
	public Map<String,Object> checkCoding(@RequestParam("page")int page,@RequestParam("rows")int rows,@RequestParam(value="myPlan",required=false)String myPlan,@RequestParam(value="like",required=false)String like,HttpSession session){
		
		staff = (Staff) session.getAttribute("staff");
	   Map<String,Object> json = sellPlanService.pageQuery(page, rows, staff,myPlan,like);
	
		return json;
		
	}
	
	
	@RequestMapping("/addSellPlan")
	public String goAdd(Model model){
		SellPlan sp = new SellPlan();
		model.addAttribute("sellPlan", sp);
		return "sellPlanAdd";
	}
	
	@RequestMapping("/addSellPlanPost")
	public String addPost(SellPlan sellPlan,HttpSession session){
		sellPlan.setPlanMonth(sellPlan.getPlanMonth().substring(0, sellPlan.getPlanMonth().lastIndexOf("-")));
		sellPlan.setState("已创建");
		
		sellPlan.setLastOperationDate(getDateTime());
		sellPlan.setOperationManId(staff.getSid());
		sellPlan.setPlanManId(staff.getSid());
		int sid = sellPlanService.save(sellPlan);
		if(sid>0){
			return "true";
		}
		return "false";
	}
	
	@ResponseBody
	@RequestMapping("/checkCoding")
	public String checkCoding(@RequestParam("coding") String coding){
		
		SellPlan sellPlan = sellPlanService.getPlanCoding(coding);
		if(sellPlan==null){
			return "true";
		}
		return "false";
		
	}
	
	@RequestMapping("/submitSellPlan")
	public String submitPost(@RequestParam("id")int id,HttpSession session){
		SellPlan sp = new SellPlan();
		sp.setPlanId(id);
		sp.setLastOperationDate(getDateTime());
		staff = (Staff) session.getAttribute("staff");
		sp.setPlanManId(staff.getSid());
		sp.setState("已提交");
		sellPlanService.setState(sp);
		return "true";
	}
	
	@RequestMapping("/examineSellPlan")
	public String examineSellPlanPost(@RequestParam("id")int id){
		SellPlan sp = new SellPlan();
		sp.setPlanId(id);
		sp.setLastOperationDate(getDateTime());
		sp.setState("已通过");
		try {
			sellPlanService.setState(sp);
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
		return "true";
	}
	
	@RequestMapping("/playReturnSellPlan")
	public String playReturnPost(@RequestParam("id")int id){
		SellPlan sp = new SellPlan();
		sp.setPlanId(id);
		sp.setLastOperationDate(getDateTime());
		sp.setState("已创建");
		try {
			sellPlanService.setState(sp);
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
		return "true";
	}

	public String getDateTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = sdf.format(new Date());
		return time;
	}
	
	public SellPlanService getSellPlanService() {
		return sellPlanService;
	}

	@Resource
	public void setSellPlanService(SellPlanService sellPlanService) {
		this.sellPlanService = sellPlanService;
	}
	
	
	
}
