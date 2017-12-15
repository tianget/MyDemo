package com.lxit.crm.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.lxit.crm.entities.Pact;
import com.lxit.crm.service.PactService;
import com.lxit.crm.service.PactfoundService;
import com.lxit.crm.util.Pager;


@Controller
@RequestMapping("/pact")
public class PactfoundController {
	@Autowired
	private  PactService pactService;
	
	@Autowired
	private  PactfoundService   pactfoundService;
	
	public PactService pactService(){
		return pactService;
	}
	
	public void setPactService (PactService pactService){
		this.pactService = pactService;
	}
	
	@RequestMapping("/pactfound")
	public String found(){
		return "pactfound";
	}
	
	@RequestMapping("/pactlook")
	public String look(){
		return "pactlook";
	}
	
	@RequestMapping("/pactmanage")
	public String manage(){
		return "pactmanage";
	}
	
	@RequestMapping("/pactfoundadd")
	public String foundadd(){
		return "pactfoundadd";
	}
	
	@RequestMapping("/pactfoundupdate")
	public String foundupdate(){
		return "pactfoundupdate";
	}
	
	@RequestMapping("/pactfoundquery")
	public String foundquery(){
		return "pactfoundquery";
	}
	
	@RequestMapping("/pactlookquery")
	public String lookquery(){
		return "pactlookquery";
	}
	
	@RequestMapping("/pactmanageexecute")
	public String manageexecute(){
		return "pactmanageexecute";
	}
	
	@RequestMapping("/pactmanagechange")
	public String managechange(){
		return "pactmanagechange";
	}
	
	@RequestMapping("/pactmanageassignment")
	public String manageassignment(){
		return "pactmanageassignment";
	}
	
	@RequestMapping("/pactmanageremove")
	public String manageremove(){
		return "pactmanageremove";
	}
	
	@RequestMapping("/pactmanagequery")
	public String managequery(){
		return "pactmanagequery";
	}
	
	
	@RequestMapping("/pact")
	public String intoPact(Pact pact){
		return "pact";
	}
	
	@ResponseBody
	@RequestMapping("/pmanagequery")
	public String selectpact(HttpSession session,int pid){
		session.setAttribute("pid", pid);
		return "true";
	}
	
	@ResponseBody
	@RequestMapping("/pfoundadd")
	public boolean insertpact(HttpSession  session ,Pact pact){
		Map<String,Object> map = new HashMap<>();
		map.put("state", true);
		if(pactService.insertpact(pact)){
			return true;
		}else{
			return  false;
		}
	}
	
	@ResponseBody
	@RequestMapping("/pfoundupdate")
	public Pact insertpactupdate(@RequestParam("pid") int pid){
		System.out.println("pid:"+pid);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("state", true);
		Pact pact = pactService.selectpact(pid);
		System.out.println("pact:"+pact);
		/*if(session.getAttribute("pact")!=null){
			session.removeAttribute("pact");
		}
		session.setAttribute("pact", pact);*/
		return pact;
	}
	
	/*@ResponseBody
	@RequestMapping("/pfoundquery")
	public String insertpactquery(HttpSession  session ,Pact pact){
		Map<String,Object> map = new HashMap<>();
		map.put("state", true);
		if(pactService.insertpact(pact)){
			return "true";
		}else{
			return  "false";
		}
	}*/
	
	@RequestMapping("/selectPactAll")
	@ResponseBody
	public  List<Pact>   getPactAll(HttpServletRequest   request){
		Pact  pa = new  Pact();
		List<Pact> listPa = pactfoundService.getPactAll(pa.getPid(),pa.getPname(),pa.getPtype(),pa.getPstate(),pa.getPlasttime(),pa.getPpeople());
		request.setAttribute("listPa", listPa);
		System.out.println("listPa"+listPa);
		return  listPa;
	}
	
	@ResponseBody
	@RequestMapping(value="/lookpactss",method=RequestMethod.POST)
	public String service_dian_service(HttpSession session,int pid){
		session.setAttribute("pid", pid);
		return "true";
	}
	
	@ResponseBody
	@RequestMapping(value="/pact_select",method=RequestMethod.POST)
	public List<Pact> service_update_service(HttpSession session){
		int pid = (int) session.getAttribute("pid");
		List<Pact> list = pactfoundService.selectPactId(pid);
		return  list;
	}
	
	
	@ResponseBody
	@RequestMapping("/getpactpage")
	public Map<String,Object> getpactpage(@RequestParam("page") int pageIndex,@RequestParam("rows")int pageSize,Pact pact){
		Map<String,Object> map = new HashMap<>();
		Pager<Pact> pager = pactService.servicePage(pageIndex, pageSize, pact);
		map.put("rows", pager.getData());
		map.put("total",pager.getSumSize());
		System.out.println("pageIndex"+pageIndex);
		System.out.println("pageSize"+pageSize);
		return map;
		
	}
}