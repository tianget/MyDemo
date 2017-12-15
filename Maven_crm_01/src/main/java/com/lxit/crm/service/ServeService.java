package com.lxit.crm.service;

import java.util.List;
import java.util.Map;

import com.lxit.crm.entities.Client_member;
import com.lxit.crm.entities.Serve;
import com.lxit.crm.entities.Servereplenish;
import com.lxit.crm.entities.Staff;
import com.lxit.crm.util.Pager;

public interface ServeService {
	
	/**分页查询
	 * 
	 * @param pager
	 * @return
	 */
	public Pager<Serve> servicePage(int pageIndex,int pageSize,Serve serve,String status);
	
	/**得到serve表的总行数
	 * @return
	 */
	public int getServeCount();
	
	/**得到serve表的模糊查询总行数
	 * @return
	 */
	public int getServeLikeCount(Map<String,Object> map);
	
	/**创建服务单据
	 * @param servere
	 * @return
	 */
	public boolean create(Servereplenish servere);
	
	/**进行服务单据提交，修改状态
	 * @param sid
	 * @return
	 */
	public boolean updateServeStatus(Map<String, Object> map);
	
	/**查看详细信息
	 * @param sid
	 * @return
	 */
	public Servereplenish lookServeById(int sid);
	
	/**调用存储过程删除服务单据
	 * @param sid 
	 * 			主键
	 * @return
	 */
	public boolean deleteCallServe(int sid);
	
	/**服务分配,处理,反馈
	 * @param sallot
	 * @return
	 */
	public boolean updateServereplenish(Servereplenish servereplenish);
	
	/**查看所有的销售代表，用来分配
	 * @return
	 */
	public List<Staff> getAllStand(int sid);
	
	/**分配，修改人物（操作人）
	 * @param serve
	 * @return
	 */
	public boolean serveAllot(Serve serve);
	
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
	public Pager<Serve> serveRolePage(int pageIndex,int pageSize,Serve serve,String status);
	
	/**
	 * 得到serve表的模糊查询总行数
	 * @return
	 */
	public int getServeRoleCount(Map<String,Object> map);
}
