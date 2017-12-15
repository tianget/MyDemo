package com.lxit.crm.service;

import java.util.List;
import java.util.Map;

import com.lxit.crm.entities.Base;
import com.lxit.crm.entities.Data_dictionary;
import com.lxit.crm.entities.Department;
import com.lxit.crm.entities.Notice;
import com.lxit.crm.entities.Notice_type;
import com.lxit.crm.entities.Power;
import com.lxit.crm.entities.Role;
import com.lxit.crm.entities.Staff;

/**
 * @author 作者 E-mail:506997606@qq.com
 * @version 创建时间 2017年11月13日 下午9:01:35 类说明:
 *
 */
public interface SystemSettingService {
	/**
	 * 查询出所有的部门
	 * 
	 * @return
	 */
	public List<Department> getDepartment();

	/**
	 * 
	 * @param role
	 *            传进来的role对象
	 * @return
	 */
	public int insertRole(Role role);

	/**
	 * 
	 * @param role 传进来的role对象
	 * @return
	 */
	public int updateRole(Role role);
	
	/**
	 * 将所有的角色查询出来
	 * 
	 * @return
	 */
	public List<Role> getAllRole(Map map);

	/**
	 * 根据id删除所选中的角色
	 * 
	 * @param rid
	 * @return
	 */
	public int deleteRoleById(int rid);

	/**
	 * 通过传入的id找到我要修改的role对象
	 * 
	 * @param rid
	 * @return 一个包含role对象
	 */    
	public Role selectRoleById(int rid);
	
	/**
	 * 授权用的树形菜单
	 * @param nid
	 * @return
	 */
	public List<Power> selectPower(int nid);
	
	/**
	 *给角色授权
	 * @param rid 角色id
	 * @param str 树形菜单的id
	 * @return
	 */
	public int insertImpower(int rid,int id);
	
	/**
	 * 分页总条数
	 * @return
	 */
	public int getRoleCount();
	
	/**
	 * 分页总条数 带模糊条件
	 * @return
	 */
	public int getRoleCountByTitle(String title);
	
	/**
	 * 查询出所有的部门
	 * @return
	 */
	public List<Department> getAllDepartment(Map map);
	
	/**
	 * 分页总条数
	 * @return
	 */
	public int getDepartmentCount();
	
	/**
	 * 分页总条数 带模糊条件
	 * @return
	 */
	public int getDePartmentCountByTitle(String title);
	
	/**
	 * 增加部门
	 * @param department
	 * @return
	 */
	public int insertDepartment(Department department);
	
	/**
	 * 通过id删除部门
	 * @param did
	 * @return
	 */
	public int deleteDepartmentById(int did);
	
	/**
	 * 通过id找到我要修改的部门对象
	 * @param did
	 * @return
	 */
	public Department updateDepartmentById(int did);
	
	/**
	 * 修改部门
	 * @param department
	 * @return
	 */
	public int updateDepartment(Department department);
	
	/**
	 * 修改用户的登录名
	 * @param map
	 * @return
	 */
	public int updateStaffNusername(Map map);
	
	/**
	 * 修改用户的电话号码
	 * @param map
	 * @return
	 */
	public int updateStaffIphone(Map map);
	
	/**
	 * 修改密码判断是否正确
	 * @param password
	 * @return
	 */
	public Staff selectPassword(Map map);
	
	/**
	 * 修改密码
	 * @param password
	 * @return
	 */
	public int updatePassword(Map map);
	
	/**
	 * 查询出所有的员工
	 * @param map
	 * @return
	 */
	public List<Staff> selectAllStaff(Map map);
	
	/**
	 * 员工的总条数
	 * @return
	 */
	public int getStaffCount();
	
	/**
	 * 员工分页的总条数
	 * @param title
	 * @return
	 */
	public int getStaffCountByTitle(String title);
	
	/**
	 * 增加员工
	 * @param saff
	 * @return
	 */
	public int insertStaff(Staff saff);
	
	/**
	 * 通过id删除员工
	 * @param sid
	 * @return
	 */
	public int deleteStaff(int sid);
	
	/**
	 * 根据id找到我们要修改的staff对象
	 * @param sid
	 * @return
	 */
	public Staff updateStaffById(int sid);
	
	/**
	 * 开始修改Staff
	 * @param staff 传入的员工对象
	 * @return
	 */
	public int updateStaff(Staff staff);
	
	/**
	 * 通过id查看到staff
	 * @param sid
	 * @return
	 */
	public Staff seeStaffById(int sid);
	
	/**
	 * 给员工授权角色
	 * @param rid
	 * @param sid
	 * @return
	 */
	public int updateRid(int rid,int sid);
	
	/**
	 * 查询出所有的公告
	 * @param map
	 * @return
	 */
	public List<Notice> getAllNoticeList(Map map);
	
	/**
	 * 公告的总条数
	 * @return
	 */
	public int getNoticeCount();
	
	/**
	 * 公告分页模糊的总条数
	 * @param title
	 * @return
	 */
	public int getNoticeCountByTitle(String title);
	
	/**
	 * 查询出所有的公告类型
	 * @return
	 */
	
	public List<Notice_type> getAllNoticeType();
	
	/**
	 * 增加公告
	 * @param notice
	 * @return
	 */
	public int insertNoticeAll(Notice notice);
	
	/**
	 * 删除公告
	 * @param noticeId
	 * @return
	 */
	public int deleteNoticeById(int noticeId);
	
	/**
	 * 通过id查看公告的详细信息
	 * @param noticeId
	 * @return
	 */
	public Notice seeNoticeById(int noticeId);
	
	/**
	 * 通过id查看公告的详细信息
	 * @param noticeId
	 * @return
	 */
	public Notice updateNoticeById(int noticeId);
	
	/**
	 * 修改notice
	 * @param notice
	 * @return
	 */
	public int updateNoticeStart(Notice notice);
	
	/**
	 * 获取基础信息的总条数
	 * @return
	 */
	public int getBaseCount();
	
	/**
	 * 带模糊查询的基础信息的总条数
	 * @param title
	 * @return
	 */
	public int getBaseCountByTitle(String title);
	
	/**
	 * 所有的基础信息
	 * @param map
	 * @return
	 */
	public List<Base> getAllBaseList(Map map);
	
	/**
	 * 增加基础信息
	 * @param base
	 * @return
	 */
	public int insertBases(Base base);
	/**
	 * 通过id删除基础信息
	 * @param baseid
	 * @return
	 */
	public int deleteBases(int baseid);
	/**
	 * 通过id找到我要修改的基础信息对象
	 * @param baseid
	 * @return
	 */
	public Base updateBaseById(int baseid);
	
	/**
	 * 修改基础信息
	 * @param base
	 * @return
	 */
	public int updateBase(Base base);
	
	/**
	 * 数据字典分页
	 * @param map
	 * @return
	 */
	public List<Data_dictionary> getAllDataList(Map map);
	
	/**
	 * 数据字典的总条数
	 * @return
	 */
	public int getDataCount();
	
	/**
	 * 数据字典的总条数加模糊查询
	 * @param title
	 * @return
	 */
	public int getDataCountByTitle(String title);
	
	/**
	 * 数据字典的增加
	 * @param data
	 * @return
	 */
	public int insertData(Data_dictionary data);
	
	/**
	 * 数据字典的删除
	 * @param dataid
	 * @return
	 */
	public int deleteData(int dataid);
	
	/**
	 * 根据传入的id找到我要修改的data
	 * @param dataid
	 * @return
	 */
	public Data_dictionary updateDataById(int dataid);
	
	/**
	 * 开始修改
	 * @param data
	 * @return
	 */
	public int updateData(Data_dictionary data);
	
	/**
	 * 授权之前删除中间表中的记录
	 * @param rid
	 * @return
	 */
	public int deleteRid(int rid);
}
