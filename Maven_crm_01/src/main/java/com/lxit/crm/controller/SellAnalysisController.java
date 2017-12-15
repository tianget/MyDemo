package com.lxit.crm.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lxit.crm.entities.SellAnalysis;
import com.lxit.crm.entities.Staff;
import com.lxit.crm.service.SellAnalysisService;

@Controller
@RequestMapping("sellAnalysis")
public class SellAnalysisController {

	private SellAnalysisService sellAnalysisService;
	
	
 	
	public SellAnalysisService getSellAnalysisService() {
		return sellAnalysisService;
	}



    @Resource
	public void setSellAnalysisService(SellAnalysisService sellAnalysisService) {
		this.sellAnalysisService = sellAnalysisService;
	}




	@RequestMapping("/goSellAnalysis")
	public String getSellAnalysis(){
		return "sellAnalysis";
	}
	
	@ResponseBody
	@RequestMapping("/getPageData")
	public Map<String,Object> getSellDate(@RequestParam("page")int page,@RequestParam("rows")int rows,@RequestParam(value="like",required=false)String like,HttpSession session){
		Staff staff = (Staff)session.getAttribute("staff");
		Map<String,Object> json = sellAnalysisService.pageQuery(page,rows,staff,like);
		return json;
	}
	
	@RequestMapping("/geSellAnalysisQuery")
	public String geSellAnalysisQuery(@RequestParam("month")String month,HttpSession session,Model model){
		model.addAttribute("month", month);
		Staff staff = (Staff)session.getAttribute("staff");
		if(staff.getRid()==4){
			model.addAttribute("field", "deptName");
			model.addAttribute("cfield", "部门");
		}else{
			model.addAttribute("field", "empName");
			model.addAttribute("cfield", "员工");
		}
		return "sellAnalysisQuery";
	}
	
	@ResponseBody
	@RequestMapping("/getDeptData")
	public List<SellAnalysis> getSellDate(@RequestParam(value="month",required=false)String month,HttpSession session,Model model){
		
		Staff staff = (Staff)session.getAttribute("staff");
		List<SellAnalysis> sas = null;
		if(staff.getRid()==4){
			sas = sellAnalysisService.queryDeptDate(month,-1);
		}else{
			sas = sellAnalysisService.queryDeptDate(month,staff.getDid());
		}
		
		return sas;
	}
	
	
}
