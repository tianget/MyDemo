package com.lxit.crm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxit.crm.dao.ClientLovingDao;
import com.lxit.crm.entities.ClientLoving;
import com.lxit.crm.entities.ClientRemind;
import com.lxit.crm.entities.ClientScheme;
import com.lxit.crm.entities.Client_allot;
import com.lxit.crm.entities.Client_cost;
import com.lxit.crm.entities.Client_member;
import com.lxit.crm.entities.SellChance;
import com.lxit.crm.entities.Staff;
import com.lxit.crm.service.ClientLovingService;
import com.lxit.crm.util.Pager;

@Service("lovingService")
public class ClientLovingServiceImpl implements ClientLovingService{
	@Autowired
	private ClientLovingDao lovingDao;
	
	@Override
	public Pager<ClientLoving> getPlanss(int id, int pag, int rows) {
		Pager<ClientLoving> page = new Pager<>();
		page.setPageIndex(pag);
		page.setPageSize(rows);
		page.setSumSize(getCount(id));
		Map<String,Object> map = new HashMap<>();
		map.put("pageIndex", (page.getPageIndex()-1)*page.getPageSize());
		map.put("pageSize", page.getPageSize());
		List<ClientLoving> list = lovingDao.getLovings(map);
		page.setData(list);
		return page;
	}
	
	@Override
	public Pager<ClientRemind> getPageLovd(int id, int pag, int rows) {
		Pager<ClientRemind> page = new Pager<>();
		page.setPageIndex(pag);
		page.setPageSize(rows);
		page.setSumSize(getLovdCount(id));
		Map<String,Object> map = new HashMap<>();
		map.put("mid", id);
		map.put("pageIndex", (page.getPageIndex()-1)*page.getPageSize());
		map.put("pageSize", page.getPageSize());
		List<ClientRemind> list = lovingDao.getLovds(map);
		page.setData(list);
		return page;
	}

	@Override
	public List<ClientLoving> getLovings(Map<String,Object> map){
		return lovingDao.getLovings(map);
	}

	@Override
	public int getCount(int id) {
		return lovingDao.getCount(id);
	}

	@Override
	public List<ClientRemind> getLovds(Map<String, Object> map) {
		return lovingDao.getLovds(map);
	}

	@Override
	public int getLovdCount(int id) {
		return lovingDao.getLovdCount(id);
	}

	@Override
	public Client_member getMember(int mid) {
		return lovingDao.getMember(mid);
	}

	@Override
	public List<ClientScheme> getLovdd(Map<String, Object> map) {
		return lovingDao.getLovdd(map);
	}

	@Override
	public int getLovddCount(int id) {
		return lovingDao.getLovddCount(id);
	}

	@Override
	public Pager<ClientScheme> getPageLovdd(int id, int pag, int rows) {
		Pager<ClientScheme> page = new Pager<>();
		page.setPageIndex(pag);
		page.setPageSize(rows);
		page.setSumSize(getLovddCount(id));
		Map<String,Object> map = new HashMap<>();
		map.put("mid", id);
		map.put("pageIndex", (page.getPageIndex()-1)*page.getPageSize());
		map.put("pageSize", page.getPageSize());
		List<ClientScheme> list = lovingDao.getLovdd(map);
		page.setData(list);
		return page;
	}

	@Override
	public int addLovd(ClientScheme cs) {
		return lovingDao.addLovd(cs);
	}

	@Override
	public int delLovd(int scid) {
		return lovingDao.delLovd(scid);
	}

	@Override
	public int updateLovd(ClientScheme cs) {
		return lovingDao.updateLovd(cs);
	}


}
