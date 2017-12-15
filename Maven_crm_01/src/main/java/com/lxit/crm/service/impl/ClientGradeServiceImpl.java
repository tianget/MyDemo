package com.lxit.crm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxit.crm.dao.ClientGradeDao;
import com.lxit.crm.entities.Client_cost;
import com.lxit.crm.entities.Client_grade;
import com.lxit.crm.entities.Client_member;
import com.lxit.crm.entities.Client_order;
import com.lxit.crm.entities.Client_orders;
import com.lxit.crm.service.ClientGradeService;
import com.lxit.crm.util.Pager;

@Service("gradeService")
public class ClientGradeServiceImpl implements ClientGradeService{
	@Autowired
    private ClientGradeDao gradeDao;
	
	@Override
	public List<Client_grade> getCosts(int sid) {
		return gradeDao.getCosts(sid);
	}

	@Override
	public List<Client_grade> getPlans(Map<String, Integer> map) {
		return gradeDao.getPlans(map);
	}

	@Override
	public Long[] getPlanCount(int id) {
		return gradeDao.getPlanCount(id);
	}

	@Override
	public Pager<Client_grade> getPlanss(int id, int pag, int rows) {
		Pager<Client_grade> page = new Pager<>();
		page.setPageIndex(pag);
		page.setPageSize(rows);
		List<Client_order> RefundCount=this.getRefundCount();
		Map<String,Integer> map = new HashMap<>();
		map.put("pageIndex", (page.getPageIndex()-1)*page.getPageSize());
		map.put("pageSize", page.getPageSize());
		List<Client_order> FulfillCount=this.getFulfillCount(map);
		List<Client_grade> gradeList=new ArrayList<Client_grade>();
		for (Client_order order : FulfillCount) {
			Client_grade grade=new Client_grade();
			grade.setId(order.getMid());
			grade.setName(order.getName());
			grade.setSex(order.getSex());
			grade.setType(order.getType());
			grade.setNumber(order.getCount());
			String abcd="";
			for (Client_order order2 : RefundCount) {
				if(order.getMid()==order2.getMid()){
					double count=(order2.getCount()*1.0)/(order.getCount()*1.0);
					if(count<0.2){
						abcd="A";
					}else if(count>=0.2&&count<=0.6){
						abcd="B";
					}else if(count>0.6&&count<=0.8){
						abcd="C";
					}else{
						abcd="D";
					}
				}
			}
			if("A".equals(abcd)||"B".equals(abcd)||"C".equals(abcd)||"D".equals(abcd)){
			}else{
				abcd="A";
			}
			grade.setGrade(abcd);
			gradeList.add(grade);
		}	
		page.setSumSize(getPlanCount(id).length);
		page.setData(gradeList);
		return page;
	}

	@Override
	public List<Client_order> getRefundCount() {
		return gradeDao.getRefundCount();
	}

	@Override
	public List<Client_order> getFulfillCount(Map<String, Integer> map) {
		return gradeDao.getFulfillCount(map);
	}

	@Override
	public Client_cost getMember(int mid) {
		return gradeDao.getMember(mid);
	}

	@Override
	public List<Client_orders> getOrders(int mid) {
		return gradeDao.getOrders(mid);
	}
	
	
}
