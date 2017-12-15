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

import com.lxit.crm.entities.Department;
import com.lxit.crm.entities.SellForecast;
import com.lxit.crm.entities.Staff;
import com.lxit.crm.service.SellChanceService;
import com.lxit.crm.service.SellForecastService;

@Controller
@RequestMapping("sellForecast")
public class SellForecastController {

	
	private SellForecastService sellForecastService;
	
	private SellChanceService sellChanceService;
	
	
	
	
	
	public SellChanceService getSellChanceService() {
		return sellChanceService;
	}

	@Resource
	public void setSellChanceService(SellChanceService sellChanceService) {
		this.sellChanceService = sellChanceService;
	}

	public SellForecastService getSellForecastService() {
		return sellForecastService;
	}

    @Resource
	public void setSellForecastService(SellForecastService sellForecastService) {
		this.sellForecastService = sellForecastService;
	}





	@RequestMapping("/goSellForecast")
	public String  goSellForecast(){
		
		return "sellForecast";
	}
	
	@ResponseBody
	@RequestMapping("/getPageDate")
	public Map<String,Object> getPageDate(@RequestParam(value="page",required=false)int page,@RequestParam(value="rows",required=false)int rows,@RequestParam(value="like",required=false)String like,HttpSession session){
		Staff staff = (Staff) session.getAttribute("staff");
		Map<String,Object> map =sellForecastService.pageQuery(page, rows, like, staff);
		return map;
	}
	
	
	
	@RequestMapping("/goAddSellForecast")
	public String getSellForecastType(@RequestParam("id")int typeId,Model model,HttpSession session){
		SellForecast sf = new SellForecast();
		Staff staff = (Staff) session.getAttribute("staff");
		Map<String,Object> map = new HashMap<String,Object>();
		//month = month.substring(0,month.lastIndexOf("-"));
		//map.put("month", month);
		session.setAttribute("state", typeId);
		if(typeId==0){
			//int empCount = sellForecastService.getEmpCount(map);
			//model.addAttribute("empCount", empCount);
		}else if(typeId==1){
			map.put("did", staff.getDid());
			List<Department> des = sellForecastService.getSonDept(staff.getDid());
			//int empCount = sellForecastService.getEmpCount(map);
			model.addAttribute("depts", des);
			//model.addAttribute("empCount", empCount);
			model.addAttribute("field", "部门");
		}else if(typeId==2){
			List<Staff> staffs =sellChanceService.queryStaffs(staff.getSid());
			map.put("sid", staff.getSid());
			model.addAttribute("staffs", staffs);
			model.addAttribute("field", "员工");
		}
		
		//int clientCount = sellForecastService.getClientCount(map);
		//model.addAttribute("clientCount", clientCount);
		model.addAttribute("state",typeId);
		model.addAttribute("sellForecast", sf);
		return "sellForecastAdd";
	}
	
	@ResponseBody
	@RequestMapping("/addSellForecastPost")
	public String addSellForecastPost(SellForecast sellForecast,@RequestParam("id")int id,@RequestParam("clientCount")int clientCount,@RequestParam(value="empCount",required=false)int empCount,HttpSession session){
		Staff staff = (Staff) session.getAttribute("staff");
		int state =  (int) session.getAttribute("state");
		String month  = sellForecast.getMonth();
		month = month.substring(0,month.lastIndexOf("-"));
		sellForecast.setMonth(month);
		if(state==2){
			sellForecast.setEmpId(id);
			sellForecast.setForecastResult("目前该该共有客户"+clientCount+"人，目前行业正处于销售旺季，预计目标时间内销售额约为"+((clientCount*10000)/10000)+"万元!");
		}else if(state==1){
			sellForecast.setDid(id);
			sellForecast.setForecastResult("目前该部门共有客户"+clientCount+"人，员工"+empCount+"人，目前行业正处于销售旺季，预计目标时间内销售额约为"+((clientCount*10000)+(empCount*10000))/10000+"万元!");
		}else if(state==0){
			sellForecast.setForecastResult("目前公司共有客户"+clientCount+"人，销售部员工"+empCount+"人，目前行业正处于销售旺季，预计目标时间内销售额约为"+((clientCount*10000)+(empCount*10000))/10000+"万元!");
		}
		sellForecast.setType(state+"");
		sellForecast.setGenerateDate(getDateTime());
		sellForecast.setOperationManId(staff.getSid());
		sellForecastService.saveSellForecast(sellForecast);
		return "true";
	}
	
	
	@RequestMapping("/goSellForecastQuery")
	public String goSellForecastQuery(@RequestParam("id")int id,Model model,HttpSession session){
		SellForecast sellForecast = sellForecastService.getSellForecasById(id);
		if(sellForecast.getDid()!=0){
			model.addAttribute("field", "部门");
		}else if(sellForecast.getEmpId()!=0){
			model.addAttribute("field", "员工");
		}else{
			model.addAttribute("field", null);
		}
		model.addAttribute("sellForecast", sellForecast);
		return "sellForecastQuery";
	}
	
	
	public String getDateTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = sdf.format(new Date());
		return time;
	}
}
