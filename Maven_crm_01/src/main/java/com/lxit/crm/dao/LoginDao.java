package com.lxit.crm.dao;

import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import com.lxit.crm.entities.Staff;

/**
 * @author 作者 E-mail:506997606@qq.com
 * @version 创建时间 2017年11月12日 下午9:52:20 类说明:
 *
 */
@MapperScan
public interface LoginDao {
	/**
	 * 
	 * @param name 传入的用户名
	 * @param password 密码
	 * @return 
	 */
	public Staff login(Map<String,Object> map);
}
