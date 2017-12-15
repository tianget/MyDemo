package com.lxit.crm.dao;

import java.util.List;
import java.util.Map;

import javax.swing.event.CellEditorListener;

import org.mybatis.spring.annotation.MapperScan;

import com.lxit.crm.entities.Client_member;
import com.lxit.crm.entities.Serve;
import com.lxit.crm.entities.Servereplenish;
import com.lxit.crm.entities.Staff;
import com.lxit.crm.util.Pager;

/**
 * @author LY
 * @date 2017年11月13日 上午9:45:55
 * @Description 服务管理模块-->服务单据管理
 */
@MapperScan
public interface ServeDao {
	
	/**
	 * @param 要增加的service对象
	 * @return 返回增加后的主键值
	 */
	public int createServe(Serve serve);
	
	/**
	 * @param 要增加的Servereplenish对象
	 * @return	
	 */
	public boolean createServeRe(Servereplenish servere);
	
	/**进行服务单据提交，修改状态
	 * @param sid
	 * @return
	 */
	public boolean updateServeStatus(Map<String, Object> map);
	
	/**
	 * 分页查询
	 * 
	 * @param pager
	 * @return
	 */
	public List<Serve> servePage(Map<String,Object> map);
	
	/**
	 * 得到serve表的总行数
	 * @return
	 */
	public int getServeCount();
	
	/**
	 * 得到serve表的模糊查询总行数
	 * @return
	 */
	public int getServeLikeCount(Map<String,Object> map);
	
	/**
	 * 查看详细信息
	 * @param sid
	 * @return
	 */
	public Servereplenish lookServeById(int sid);
	
	/**
	 * 调用存储过程删除服务单据
	 * @param sid 
	 * 			主键
	 * @return
	 */
	public void deleteCallServe(Map<String,Object> map);
	
	/**服务分配,处理,反馈
	 * @param sallot
	 * @return
	 */
	public boolean updateServereplenish(Servereplenish servereplenish);
	
	/**查看所有的销售代表，用来选择分配
	 * @return
	 */
	public List<Staff> getAllStand(int sid);
	
	/**分配，修改人物（操作人）
	 * @param serve
	 * @return
	 */
	public boolean serveAllot(Serve serve);
	
	public boolean updateServe(Servereplenish servereplenish);
	
	/**得到所有的客户资料信息
	 * @return
	 */
	public List<Client_member> getAllClient();
	
	/**二级联动
	 * @param mid
	 * 			用户主键
	 * @return
	 * 		用户电话号码
	 */
	public Client_member getClientPhone(int mid);
	
	/**得到销售经理，或者销售代表
	 * @return
	 */
	public List<Staff> getStaffRole();
	
	/**
	 * 分页查询
	 * 
	 * @param pager
	 * @return
	 */
	public List<Serve> serveRolePage(Map<String,Object> map);
	
	/**
	 * 得到serve表的模糊查询总行数
	 * @return
	 */
	public int getServeRoleCount(Map<String,Object> map);
}
