package com.lxit.crm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxit.crm.dao.SystemSettingDao;
import com.lxit.crm.entities.Base;
import com.lxit.crm.entities.Data_dictionary;
import com.lxit.crm.entities.Department;
import com.lxit.crm.entities.Notice;
import com.lxit.crm.entities.Notice_type;
import com.lxit.crm.entities.Power;
import com.lxit.crm.entities.Role;
import com.lxit.crm.entities.Staff;
import com.lxit.crm.service.SystemSettingService;

/**
 * @author 作者 E-mail:506997606@qq.com
 * @version 创建时间 2017年11月13日 下午9:02:27 类说明:
 *
 */
@Service("systemSettingService")
public class SystemSettingServiceImpl implements SystemSettingService {

	@Autowired
	private SystemSettingDao systemSettingDao;

	@Override
	public List<Department> getDepartment() {

		return systemSettingDao.getDepartment();
	}

	@Override
	public List<Role> getAllRole(Map map) {

		return systemSettingDao.getAllRole(map);
	}

	@Override
	public int insertRole(Role role) {

		return systemSettingDao.insertRole(role);

	}

	@Override
	public int deleteRoleById(int rid) {
		
		return systemSettingDao.deleteRoleById(rid);
	}

	@Override
	public Role selectRoleById(int rid) {
		
		return systemSettingDao.selectRoleById(rid);
	}

	@Override
	public int updateRole(Role role) {
		
		return systemSettingDao.updateRole(role);
	}

	@Override
	public List<Power> selectPower(int nid) {
		
		return systemSettingDao.selectPower(nid);
	}

	@Override
	public int insertImpower(int rid, int id) {
		
		return systemSettingDao.insertImpower(rid, id);
	}

	@Override
	public int getRoleCount() {
		return systemSettingDao.getRoleCount();
	}

	@Override
	public int getRoleCountByTitle(String title) {
		
		return systemSettingDao.getRoleCountByTitle(title);
	}

	@Override
	public List<Department> getAllDepartment(Map map) {
		
		return systemSettingDao.getAllDepartment(map);
	}

	@Override
	public int getDepartmentCount() {
		
		return systemSettingDao.getDepartmentCount();
	}

	@Override
	public int getDePartmentCountByTitle(String title) {
		
		return systemSettingDao.getDePartmentCountByTitle(title);
	}

	@Override
	public int insertDepartment(Department department) {
		
		return systemSettingDao.insertDepartment(department);
	}

	@Override
	public int deleteDepartmentById(int did) {
		
		return systemSettingDao.deleteDepartmentById(did);
	}

	@Override
	public Department updateDepartmentById(int did) {
		
		return systemSettingDao.updateDepartmentById(did);
	}

	@Override
	public int updateDepartment(Department department) {
		
		return systemSettingDao.updateDepartment(department);
	}

	@Override
	public int updateStaffNusername(Map map) {
		
		return systemSettingDao.updateStaffNusername(map);
	}

	@Override
	public int updateStaffIphone(Map map) {
		
		return systemSettingDao.updateStaffIphone(map);
	}

	@Override
	public Staff selectPassword(Map map) {
		
		return systemSettingDao.selectPassword(map);
	}

	@Override
	public int updatePassword(Map map) {
		
		return systemSettingDao.updatePassword(map);
	}

	@Override
	public List<Staff> selectAllStaff(Map map) {
		
		return systemSettingDao.selectAllStaff(map);
	}

	@Override
	public int getStaffCount() {
		
		return systemSettingDao.getStaffCount();
	}

	@Override
	public int getStaffCountByTitle(String title) {
		
		return systemSettingDao.getStaffCountByTitle(title);
	}

	@Override
	public int insertStaff(Staff saff) {
		
		return systemSettingDao.insertStaff(saff);
	}

	@Override
	public int deleteStaff(int sid) {
		
		return systemSettingDao.deleteStaff(sid);
	}

	@Override
	public Staff updateStaffById(int sid) {
		
		return systemSettingDao.updateStaffById(sid);
	}

	@Override
	public int updateStaff(Staff staff) {
		
		return systemSettingDao.updateStaff(staff);
	}

	@Override
	public Staff seeStaffById(int sid) {
	
		return systemSettingDao.seeStaffById(sid);
	}

	@Override
	public int updateRid(int rid, int sid) {
		
		return systemSettingDao.updateRid(rid, sid);
	}

	@Override
	public List<Notice> getAllNoticeList(Map map) {
		
		return systemSettingDao.getAllNoticeList(map);
	}

	@Override
	public int getNoticeCount() {
		
		return systemSettingDao.getNoticeCount();
	}

	@Override
	public int getNoticeCountByTitle(String title) {
		
		return systemSettingDao.getNoticeCountByTitle(title);
	}

	@Override
	public List<Notice_type> getAllNoticeType() {
		
		return systemSettingDao.getAllNoticeType();
	}

	@Override
	public int insertNoticeAll(Notice notice) {
		
		return systemSettingDao.insertNoticeAll(notice);
	}

	@Override
	public int deleteNoticeById(int noticeId) {
		
		return systemSettingDao.deleteNoticeById(noticeId);
	}

	@Override
	public Notice seeNoticeById(int noticeId) {
		
		return systemSettingDao.seeNoticeById(noticeId);
	}

	@Override
	public Notice updateNoticeById(int noticeId) {
		
		return systemSettingDao.updateNoticeById(noticeId);
	}

	@Override
	public int updateNoticeStart(Notice notice) {
		
		return systemSettingDao.updateNoticeStart(notice);
	}

	@Override
	public int getBaseCount() {
		
		return systemSettingDao.getBaseCount();
	}

	@Override
	public int getBaseCountByTitle(String title) {
		
		return systemSettingDao.getBaseCountByTitle(title);
	}

	@Override
	public List<Base> getAllBaseList(Map map) {
		
		return systemSettingDao.getAllBaseList(map);
	}

	@Override
	public int insertBases(Base base) {
		
		return systemSettingDao.insertBases(base);
	}

	@Override
	public int deleteBases(int baseid) {
		
		return systemSettingDao.deleteBases(baseid);
	}

	@Override
	public Base updateBaseById(int baseid) {
		
		return systemSettingDao.updateBaseById(baseid);
	}

	@Override
	public int updateBase(Base base) {
		
		return systemSettingDao.updateBase(base);
	}

	@Override
	public List<Data_dictionary> getAllDataList(Map map) {
		
		return systemSettingDao.getAllDataList(map);
	}

	@Override
	public int getDataCount() {
		
		return systemSettingDao.getDataCount();
	}

	@Override
	public int getDataCountByTitle(String title) {
		
		return systemSettingDao.getBaseCountByTitle(title);
	}

	@Override
	public int insertData(Data_dictionary data) {
		
		return systemSettingDao.insertData(data);
	}

	@Override
	public int deleteData(int dataid) {
		
		return systemSettingDao.deleteData(dataid);
	}

	@Override
	public Data_dictionary updateDataById(int dataid) {
		
		return systemSettingDao.updateDataById(dataid);
	}

	@Override
	public int updateData(Data_dictionary data) {
		
		return systemSettingDao.updateData(data);
	}

	@Override
	public int deleteRid(int rid) {
		return systemSettingDao.deleteRid(rid);
	}

}
