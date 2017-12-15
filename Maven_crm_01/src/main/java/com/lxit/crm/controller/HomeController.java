package com.lxit.crm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lxit.crm.entities.Power;
import com.lxit.crm.entities.Staff;
import com.lxit.crm.service.HomeService;

@Controller
@RequestMapping("/power")
public class HomeController {

	@Autowired
	private HomeService homeService;

	@ResponseBody
	@RequestMapping("/powerList")
	public List<Power> getAllPower(Integer id,HttpSession session) {
		Integer navsId = id == null ? 0 : id;
		Staff staff = (Staff) session.getAttribute("staff");
		List<Power> list = homeService.selectAllPower(navsId,staff.getSid());
		return list;
	}
}
