package com.lxit.crm.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxit.crm.dao.LoginDao;
import com.lxit.crm.entities.Staff;
import com.lxit.crm.service.LoginService;

/**
* @author 作者 E-mail:506997606@qq.com
* @version 创建时间 2017年11月12日 下午10:18:50
* 类说明:
*
*/
@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;
	@Override
	public Staff login(String name, String password) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", name);
		map.put("password", password);
		return loginDao.login(map);
	}

}
