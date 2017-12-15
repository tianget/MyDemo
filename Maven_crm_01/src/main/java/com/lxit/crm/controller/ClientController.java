package com.lxit.crm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class ClientController {
	@RequestMapping("/client_allot")
	public String client_allot(HttpSession session) {	
		session.removeAttribute("member");
		return "client_allot";
	}
	
	@RequestMapping("/client_plan")
	public String client_plan(HttpSession session) {	
		session.removeAttribute("plan");
		return "client_plan";
	}
	
	@RequestMapping("/client_cost")
	public String client_cost(HttpSession session) {
		session.removeAttribute("members");
		session.removeAttribute("orders");
		return "client_cost";
	}
	
	@RequestMapping("/client_satisficing")
	public String client_satisficing(HttpSession session) {
		session.removeAttribute("querymember");
		session.removeAttribute("samid");
		return "client_satisficing";
	}
	
	@RequestMapping("/client_grade")
	public String client_grade(HttpSession session) {	
		session.removeAttribute("orders");
		session.removeAttribute("cost");
		return "client_grade";
	}
	
	@RequestMapping("/client_loving")
	public String client_loving() {	
		return "client_loving";
	}
	
	@RequestMapping("/client_costInformation")
	public String client_costInformation() {	
		return "client_costInformation";
	}
	
	@RequestMapping("/client_member")
	public String client_member() {	
		return "client_member";
	}
	
	@RequestMapping("/client_member2")
	public String client_member2() {	
		return "client_member2";
	}
	
	@RequestMapping("/client_planadd")
	public String client_planadd() {	
		return "client_planadd";
	}
	
	@RequestMapping("/client_planQuery")
	public String client_planQuery() {	
		return "client_planQuery";
	}
	
	@RequestMapping("/client_satisficingadd")
	public String client_satisficingadd() {	
		return "client_satisficingadd";
	}
	
	@RequestMapping("/client_satisficingQuery")
	public String client_satisficingQuery() {	
		return "client_satisficingQuery";
	}
	
	@RequestMapping("/client_gradeQuery")
	public String client_gradeQuery() {	
		return "client_gradeQuery";
	}
	
	@RequestMapping("/client_allotD")
	public String client_allotD() {	
		return "client_allotD";
	}
	
	@RequestMapping("/client_lovings")
	public String client_lovings() {	
		return "client_lovings";
	}
	
	@RequestMapping("/client_lovingd")
	public String client_lovingd() {	
		return "client_lovingd";
	}
}
