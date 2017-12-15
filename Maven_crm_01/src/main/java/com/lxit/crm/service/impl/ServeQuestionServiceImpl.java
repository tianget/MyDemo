package com.lxit.crm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxit.crm.dao.ServeQuestionDao;
import com.lxit.crm.entities.Question;
import com.lxit.crm.entities.Serve;
import com.lxit.crm.service.ServeQuestionService;
import com.lxit.crm.util.Pager;

@Service("serveQuestionService")
public class ServeQuestionServiceImpl implements ServeQuestionService {
	
	@Autowired
	private ServeQuestionDao serveQuestionDao;
	
	@Override
	public boolean createQuestion(Question question) {
		return serveQuestionDao.createQuestion(question);
	}

	@Override
	public boolean deleteQuestion(int qid) {
		 
		 return serveQuestionDao.deleteQuestion(qid);
	}

	@Override
	public Question getQuestionById(int qid) {
		return serveQuestionDao.getQuestionById(qid);
	}

	@Override
	public boolean modifiedQuestion(Question question) {
		return serveQuestionDao.modifiedQuestion(question);
	}

	@Override
	public int getPageLikeCount(Question question) {
		return serveQuestionDao.getPageLikeCount(question);
	}

	@Override
	public Pager<Question> getPageLike(int pageIndex,int pageSize,Question question) {
		Pager<Question> page = new Pager<>();
		page.setPageIndex(pageIndex);
		page.setPageSize(pageSize);
		page.setSumSize(getPageLikeCount(question));
		Map<String,Object> map = new HashMap<>();
		map.put("pageIndex", (page.getPageIndex()-1)*page.getPageSize());
		map.put("pageSize", page.getPageSize());
		map.put("qtitle",question.getQtitle());
		map.put("qtype", question.getQtype());
		map.put("creater", question.getStaff().getSid());
		List<Question> list = serveQuestionDao.getPageLike(map);
		page.setData(list);
		return page;
	}

	
}
