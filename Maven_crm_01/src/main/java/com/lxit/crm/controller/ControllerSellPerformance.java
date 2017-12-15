package com.lxit.crm.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lxit.crm.entities.Staff;
import com.lxit.crm.service.SellPerService;

@Controller
@RequestMapping("sellPer")
public class ControllerSellPerformance {

	private SellPerService sellPerService;
	
      	
	
	public SellPerService getSellPerService() {
		return sellPerService;
	}

	@Resource
	public void setSellPerService(SellPerService sellPerService) {
		this.sellPerService = sellPerService;
	}



	@RequestMapping("/goSellPer")
	public String goSellPer(){
		return "sellPer";
	}
	
	
	
	@ResponseBody
	@RequestMapping("/getPageData")
	public Map<String, Object>  getPageData(@RequestParam(value="page",required=false)int page,@RequestParam(value="rows",required=false)int rows,@RequestParam(value="like",required=false)String like,HttpSession session,Model model){
		Staff staff = (Staff) session.getAttribute("staff");
		Map<String, Object> map = sellPerService.pageQuery(page, rows, staff, like);
		return map;
	}
}
