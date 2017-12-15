package com.lxit.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lxit.crm.entities.Statistics;
import com.lxit.crm.service.StatisticsService;

@Controller
@RequestMapping("/statistics")
public class StatisticsController {
	
	
	
	@Autowired
	private StatisticsService  statisticsService;
	
	@RequestMapping("/goStatisticsQuery")
	public String goStatisticsQuery(String operation,Model model){
		String field = "";
		if("client".equals(operation)){
			field="客户数量";
		}else if("lsClient".equals(operation)){
			field="流失数量";
		}else if("contribute".equals(operation)){
			field="贡献业绩(万元)";
		}else if("serve".equals(operation)){
			field="服务数量";
		}
		model.addAttribute("operation", operation);
		model.addAttribute("field", field);
		
		return "statisticsQuery";
	}

	@RequestMapping("/clienteleFormation")
	public String goStatisticsQueryTu(@RequestParam("operation") String operation,Model model){
		model.addAttribute("operation", operation);
		return "clienteleFormation";
	}

	@ResponseBody
	@RequestMapping("/statisticsQuery")
	public List<Statistics> statisticsQuery(@RequestParam("operation") String operation){
		List<Statistics> stas = statisticsService.statistics(operation);
		return stas;
	}
}
