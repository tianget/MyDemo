package com.lxit.crm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lxit.crm.entities.Staff;
import com.lxit.crm.service.LoginService;
import com.lxit.crm.service.ServeService;

/**
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/role")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private ServeService serveService;

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	
	@RequestMapping("/loginPost")
	public String loginPost(@RequestParam("nusername") String nusername,@RequestParam("password") String password,
			HttpSession session) {
		Staff staff = loginService.login(nusername, password);
		if (staff != null) {
			session.setAttribute("staff",staff);	
			List<Staff> liststaff = serveService.getStaffRole(); 
			for(Staff s:liststaff){
				if(s.getSid()==staff.getSid()){
					session.setAttribute("serverole", "销售用户");
				}
			}
			return "home";
		}
		return "login";
	}
	
	@RequestMapping("/signout")
	public String signout(HttpSession session){
		session.removeAttribute("staff");
		session.removeAttribute("serverole");
		return "login";
	}
}
