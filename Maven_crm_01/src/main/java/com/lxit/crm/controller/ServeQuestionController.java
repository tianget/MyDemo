package com.lxit.crm.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lxit.crm.entities.Question;
import com.lxit.crm.entities.Serve;
import com.lxit.crm.entities.Staff;
import com.lxit.crm.service.ServeQuestionService;
import com.lxit.crm.util.Pager;

@Controller
@RequestMapping("/serve")
public class ServeQuestionController {
	
	@Autowired
	private ServeQuestionService serveQuestionService;
	
	@RequestMapping("/question")
	public String intoQuestion(){
		return "serveQuestion";
	}
	
	@RequestMapping("/serveQuestionCreate")
	public String intocreate(){
		return "serveQuestionCreate";
	}
	
	@ResponseBody
	@RequestMapping("/getQuestionPage")
	public Map<String,Object> questionpage(@RequestParam("page") int pageIndex,@RequestParam("rows")int pageSize,Question question,HttpSession session){
		Map<String, Object> map = new HashMap<>();
		Staff staff = (Staff) session.getAttribute("staff");
		question.setStaff(staff);
		Pager<Question> pager = serveQuestionService.getPageLike(pageIndex, pageSize, question);
		map.put("rows", pager.getData());
		map.put("total",pager.getSumSize());
		return map;
	}
	
	@ResponseBody
	@RequestMapping("/saveServeQuestion")
	public boolean savequestion(Question question,HttpSession session){
		Staff staff = (Staff) session.getAttribute("staff");
		boolean flag = false;
		if(staff != null){
			question.setStaff(staff);
			flag=serveQuestionService.createQuestion(question);
		}
		return flag;
	}
	
	@ResponseBody
	@RequestMapping("/getQuestionById")
	public Question getQuestionById(int qid){
		return serveQuestionService.getQuestionById(qid);
	}
	
	@ResponseBody
	@RequestMapping("/updateQuestion")
	public boolean updateQuestion(Question question){
		return serveQuestionService.modifiedQuestion(question);
	}
	
	@ResponseBody
	@RequestMapping("/deleteQuestion")
	public boolean deleteQuestion(@RequestParam int[] ids){
		for(int i=0;i<ids.length;i++){
			serveQuestionService.deleteQuestion(ids[i]);
		}
		return true;
	}
	
	@ResponseBody
	@RequestMapping("/lookQuestion")
	public Question lookQuestionById(String qid){
		return serveQuestionService.getQuestionById(Integer.parseInt(qid));
	}
	
}
