package com.lxit.crm.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lxit.crm.entities.Pact;
import com.lxit.crm.service.PactManageService;

@Controller
@RequestMapping("/pact")
public class PactManageCotroller {
	@Autowired
	private PactManageService pactManageService;
	
	@RequestMapping("/pactManage")
	public String intoLook(){
		return "pactmanageexecute";
	}
	
	@ResponseBody
	@RequestMapping("/getPactById")
	public Pact getPactById(int pid){
		Pact p = pactManageService.getPactById(pid);
		return p;
	}
	
	@ResponseBody
	@RequestMapping("/pactInsepect")
	public boolean pactInsepect(String pid,String pexamine){
		Map<String, Object> map = new HashMap<>();
		map.put("pid", pid.toString());
		map.put("pexamine", pexamine);
		map.put("pstate", "已审批");
		boolean flag = true;
		// 第一步，修改 审批意见
		if(pactManageService.pactInsepect(map)){
			// 第二部，修改合同状态[已审批]，最后修改时间
			if(!pactManageService.updatePactStatus(map)){
				flag = false;
			};
		}
		System.out.println("map:"+map);
		return flag;
	}
	
}
