package com.lxit.crm.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import com.lxit.crm.entities.ClientPlan;
import com.lxit.crm.util.Pager;

@MapperScan
public interface ClientPlanDao {
    /**查询所有客户发展计划
     * @param id
     * @return
     */
    public List<ClientPlan> getPlans(Map<String,Integer> map);
    /**根据权限查询所有客户发展计划
     * @param id
     * @return
     */
    public List<ClientPlan> rgetPlans(Map<String,Integer> map);
    
    /**根据月份查询所有客户发展计划
     * @param id
     * @param month
     * @return
     */
    public List<ClientPlan> getDate(Map<String,Object> map);
    
    /**查询客户发展计划总条数
     * @return
     */
    public int getPlanCount(int id);
    
    /**根据权限查询客户发展计划总条数
     * @return
     */
    public int rgetPlanCount(int id);
    
    /**根据登录用户id查询权限范围
	 * @param id
	 * @return
	 */
	public String getRname(int id);
	
	/**增加客户发展计划
	 * @param plan
	 * @return
	 */
	public int setPlan(ClientPlan plan);
	
	/**根据id查询客户发展计划
	 * @param id
	 * @return
	 */
	public ClientPlan getPlan(int id);
	
	/**修改客户发展计划
	 * @param plan
	 * @return
	 */
	public int updatePlan(ClientPlan plan);
	
	/**根据客户计划id删除客户计划
	 * @param id
	 * @return
	 */
	public int delete(int id);
}
