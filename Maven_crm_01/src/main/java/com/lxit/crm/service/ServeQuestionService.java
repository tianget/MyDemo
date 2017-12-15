package com.lxit.crm.service;

import java.util.List;
import java.util.Map;

import com.lxit.crm.entities.Question;
import com.lxit.crm.util.Pager;

public interface ServeQuestionService {
	/**
	 * 增加常见问题
	 * @param question
	 * @return
	 */
	public boolean createQuestion(Question question);
	
	/**
	 * 删除
	 * @param qid
	 * @return
	 */
	public boolean deleteQuestion(int qid);
	
	/**
	 * 根据主键查询
	 * @param qid
	 * @return
	 */
	public Question getQuestionById(int qid);
	
	/**修改问题
	 * 
	 * @param question
	 * @return
	 */
	public boolean modifiedQuestion(Question question);
	
	/**得到模糊查询的总条数
	 * 
	 * @param question
	 * @return
	 */
	public int getPageLikeCount(Question question);
	
	/**
	 * 模糊查询的数据
	 * @param map
	 * @return
	 */
	public Pager<Question> getPageLike(int pageIndex,int pageSize,Question question);
}
