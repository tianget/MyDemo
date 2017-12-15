package com.lxit.crm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lxit.crm.entities.CompeteManager;
import com.lxit.crm.entities.Staff;
import com.lxit.crm.service.SellCompeteService;

@Controller
@RequestMapping("sellCompete")
public class SellCompeteController {

	private SellCompeteService sellCompeteService;
	
	
	
	
	public SellCompeteService getSellCompeteService() {
		return sellCompeteService;
	}



    @Resource
	public void setSellCompeteService(SellCompeteService sellCompeteService) {
		this.sellCompeteService = sellCompeteService;
	}




	@RequestMapping("/goSellCompete")
	public String goSellCompete(){
		return "sellCompete";
	}
	
	@ResponseBody
	@RequestMapping("/getPageData")
	public Map<String,Object> getPageData(@RequestParam("page")int page,@RequestParam("rows")int rows,@RequestParam(value="like",required=false)String like,HttpSession session){
		Map<String,Object> map = null;
		Staff staff = (Staff) session.getAttribute("staff");
		if(staff.getRid()==4){
			map = sellCompeteService.pageQuery(page, rows, like);
		}
		return map;
	}
	
	@RequestMapping("/goSellCompeteAU")
	public String goSellCompeteAU(@RequestParam(value="id",required=false)int id,@RequestParam(value="operation",required=false)String operation,Model model){
		CompeteManager sc = new CompeteManager();
		if(id!=0){
			sc = sellCompeteService.getSellComtepeById(id);
			sc.setType("0".equals(sc.getType())?"行业分析":"公司分析");
			sc.setState("0".equals(sc.getState())?"未归档":"已归档");
			if("query".equals(operation)){
				model.addAttribute("competeManager", sc);
				return "sellCompeteQuery";
			}
		}
		model.addAttribute("competeManager", sc);
		return "sellCompeteAU";
	}
	
	@ResponseBody
	@RequestMapping("/addSellCompetePost")
	public String addSellCompetePost(CompeteManager competeManager,@RequestParam(value="id",required=false)Integer id,HttpSession session){
		Staff staff = (Staff) session.getAttribute("staff");
		competeManager.setAnalysisDate(competeManager.getAnalysisDate().substring(0,competeManager.getAnalysisDate().lastIndexOf("-")));
		if(id!=null&&id>0){
			sellCompeteService.updateSellCompete(competeManager);
		}else{
			competeManager.setOperationManId(staff.getSid());
			competeManager.setGenerateDate(getDateTime());
			competeManager.setState(0+"");
			sellCompeteService.saveSellCompete(competeManager);
		}
		if("0".equals(competeManager.getType())){
        	competeManager.setAnalysisResult("近期由于世界经济还在缓慢复苏过程中，受世界经济影响，上游产业复苏乏力，本行业整体发展放缓。预计本月份销售额较上年度同期会有所下降。.......");
        }else if("1".equals(competeManager.getType())){
        	competeManager.setAnalysisResult("近期由于世界经济还在缓慢复苏过程中，受世界经济影响，上游产业复苏乏力，公司整体发展放缓。预计公司本月份销售额较上年度同期会有所下降。.......");
        }
		return "true";
	}
	
	@ResponseBody
	@RequestMapping("/fileSellCompete")
	public String fileSellCompete(@RequestParam(value="id",required=false)int id){
		CompeteManager sc = new CompeteManager();
		sc.setId(id);
		sc.setState(1+"");
		try {
			sellCompeteService.setState(sc);
		} catch (Exception e) {
			return "false";
		}
		return "true";
	}
	
	public String getDateTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = sdf.format(new Date());
		return time;
	}
}
