package com.lxit.crm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lxit.crm.dao.ServeDao;
import com.lxit.crm.entities.Client_member;
import com.lxit.crm.entities.Serve;
import com.lxit.crm.entities.Servereplenish;
import com.lxit.crm.entities.Staff;
import com.lxit.crm.service.ServeService;
import com.lxit.crm.util.Pager;

@Service("serveService")
public class ServeServiceImpl implements ServeService {
	
	@Resource
	ServeDao serveDao;
	public ServeDao getServeDao() {
		return serveDao;
	}
	public void setServeDao(ServeDao serveDao) {
		this.serveDao = serveDao;
	}

	@Override
	public Pager<Serve> servicePage(int pageIndex,int pageSize,Serve serve,String status) {
		Pager<Serve> page = new Pager<>();
		page.setPageIndex(pageIndex);
		page.setPageSize(pageSize);	
		Map<String,Object> map = new HashMap<>();
		map.put("pageIndex", (page.getPageIndex()-1)*page.getPageSize());
		map.put("pageSize", page.getPageSize());
		map.put("sname",serve.getSname());
		map.put("stype", serve.getStype());
		map.put("sstatus", serve.getSstatus());
		map.put("status", status);
		map.put("creater", serve.getScreater());
		page.setSumSize(getServeLikeCount(map));
		List<Serve> list = serveDao.servePage(map);
		page.setData(list);
		return page;
	}
	@Override
	public int getServeCount() {
		return serveDao.getServeCount();
	}
	@Override
	public int getServeLikeCount(Map<String,Object> map) {
		return serveDao.getServeLikeCount(map);
	}
	@Override
	public boolean create(Servereplenish servere) {
		serveDao.createServe(servere.getServe());
		return serveDao.createServeRe(servere);
	}
	@Override
	public Servereplenish lookServeById(int sid) {
		return serveDao.lookServeById(sid);
	}
	@Override
	public boolean deleteCallServe(int sid) {
		Map<String ,Object> map = new HashMap<>();
		map.put("id", sid);
		serveDao.deleteCallServe(map);
		return true;
	}
	@Override
	public boolean updateServeStatus(Map<String, Object> map) {
		return serveDao.updateServeStatus(map);
	}
	@Override
	public boolean updateServereplenish(Servereplenish servereplenish) {
		return serveDao.updateServereplenish(servereplenish);
	}
	@Override
	public List<Staff> getAllStand(int sid) {
		return serveDao.getAllStand(sid);
	}
	@Override
	public boolean serveAllot(Serve serve) {
		return serveDao.serveAllot(serve);
	}
	@Override
	public List<Client_member> getAllClient() {
		return serveDao.getAllClient();
	}
	@Override
	public Client_member getClientPhone(int mid) {
		return serveDao.getClientPhone(mid);
	}
	@Override
	public List<Staff> getStaffRole() {
		return serveDao.getStaffRole();
	}
	@Override
	public Pager<Serve> serveRolePage(int pageIndex,int pageSize,Serve serve,String status) {
		Pager<Serve> page = new Pager<>();
		page.setPageIndex(pageIndex);
		page.setPageSize(pageSize);	
		Map<String,Object> map = new HashMap<>();
		map.put("pageIndex", (page.getPageIndex()-1)*page.getPageSize());
		map.put("pageSize", page.getPageSize());
		map.put("sname",serve.getSname());
		map.put("stype", serve.getStype());
		map.put("sstatus", serve.getSstatus());
		map.put("status", status);
		page.setSumSize(getServeRoleCount(map));
		List<Serve> list = serveDao.serveRolePage(map);
		page.setData(list);
		return page;
	}
	@Override
	public int getServeRoleCount(Map<String, Object> map) {
		return serveDao.getServeRoleCount(map);
	}
	
}
