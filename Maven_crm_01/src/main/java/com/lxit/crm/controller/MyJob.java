package com.lxit.crm.controller;

import javax.servlet.http.HttpSession;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lxit.crm.service.OrderService;
import com.lxit.crm.weather.ArrayOfString;
import com.lxit.crm.weather.WeatherWS;
import com.lxit.crm.weather.WeatherWSSoap;

@Controller
@RequestMapping("/MyJob")
public class MyJob extends QuartzJobBean {
	
	//使用webservice调用天气接口
	@RequestMapping("/wetherWeb")
	public String wetherWeb(HttpSession session) {
		WeatherWSSoap ws = new WeatherWS().getWeatherWSSoap();
		ArrayOfString list = ws.getWeather("深圳", null);
		session.setAttribute("asd", list.getString().get(0));
		session.setAttribute("wen", list.getString().get(4));

		return "orderInquiry";
	}

	@Autowired
	private OrderService orderService;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		
	}

}
