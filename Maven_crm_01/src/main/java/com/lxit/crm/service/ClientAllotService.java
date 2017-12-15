package com.lxit.crm.service;

import java.util.List;
import java.util.Map;

import com.lxit.crm.entities.ClientPlan;
import com.lxit.crm.entities.Client_allot;
import com.lxit.crm.entities.Client_member;
import com.lxit.crm.entities.Staff;
import com.lxit.crm.util.Pager;

public interface ClientAllotService {
	/**根据自己的权限查询出客户资源管理
	 * @return
	 */
	public List<Client_allot> getAllots(int sid);
	
	/**分页
	 * @param id
	 * @param pag
	 * @param rows
	 * @return
	 */
	public List<Client_allot> getPlans(Map<String,Integer> map);
	
	/**根据权限差分页
	 * @param id
	 * @param pag
	 * @param rows
	 * @return
	 */
	public List<Client_allot> rgetPlans(Map<String,Integer> map);
	
	
	/**查询客户发展计划总条数
	 * @return
	 */
	public int getPlanCount(int id);
	
	/**根据权限查询客户发展计划总条数
	 * @return
	 */
	public int rgetPlanCount(int id);
	
	/**分页
	 * @param id
	 * @param pag
	 * @param rows
	 * @return
	 */
	public Pager<Client_allot> getPlanss(int id,int pag,int rows);
	
	/**根据登录用户id查询权限范围
	 * @param id
	 * @return
	 */
	public String getRname(int id);
	
	/**增加客户
	 * 
	 */
	public int setMember(Client_member member);
	
	/**根据id查询客户信息
	 * @param mid
	 * @return
	 */
	public Client_member getMember(int mid);
	
	/**修改客户信息
	 * @return
	 */
	public int updateMember(Client_member member);
	
	/**增加allot关系
	 * @return
	 */
	public int addAllot(Client_allot all);
	
	/**根据录入时间查询客户信息
	 * @param enteringDate
	 * @return
	 */
	public Client_member getMember2(String enteringDate);
	
	/**查询所有员工
	 * @return
	 */
	public List<Staff> getStaff();
	
	/**分配权限
	 * @return
	 */
	public int setAllotd(Client_allot allot);
}
