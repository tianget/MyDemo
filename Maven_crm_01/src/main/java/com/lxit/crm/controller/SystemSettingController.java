package com.lxit.crm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
 * @version 创建时间 2017年11月13日 下午3:24:49 类说明:所有的系统设置功能都在这个controller实现
 *
 */
@Controller
@RequestMapping("/system")
public class SystemSettingController {

	@Autowired
	private SystemSettingService systemSettingService;

	@RequestMapping("/roleManager")
	public String roleManager() {
		return "rolemanager";
	}

	@RequestMapping("/role_add")
	public String roleadd() {
		// Role role = new Role();
		// model.addAttribute("role", role);
		// List<Department> list = systemSettingService.getDepartment();
		// model.addAttribute("list",list);
		return "role_add";
	}

	@ResponseBody
	@RequestMapping("/getDepartment")
	public List<Department> getAll() {
		// Integer navsId = dnid == null ? 0 : dnid;
		List<Department> list = systemSettingService.getDepartment();
		return list;
	}

	@RequestMapping("/insertRole")
	public String insertRole(Role role, @RequestParam(value = "did") int department, HttpSession session) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = sdf.format(new Date());
		Staff staff = (Staff) session.getAttribute("staff");
		System.out.println(staff);
		role.setCzid(staff.getSid());
		role.setRdate(time);

		systemSettingService.insertRole(role);
		return "rolemanager";
	}

	@RequestMapping("/deleteRole")
	public String deleteRole(int rid) {
		systemSettingService.deleteRoleById(rid);
		return "rolemanager";
	}

	// 通过id找到要修改的role对象
	@ResponseBody
	@RequestMapping("/updateRoleById")
	public Role updateRoleById(int rid, Map<String, Object> map) {
		Role role = new Role();
		role = systemSettingService.selectRoleById(rid);
		map.put("rcoding", role.getRcoding());
		return role;
	}

	@RequestMapping("/update")
	public String update(Role role, HttpSession session) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = sdf.format(new Date());
		role.setRdate(time);
		Staff staff = (Staff) session.getAttribute("staff");
		role.setCzid(staff.getCzid());
		systemSettingService.updateRole(role);
		return "rolemanager";
	}

	@ResponseBody
	@RequestMapping("/getAllRole")
	public Map<String, Object> getAllRole(@RequestParam("page") int page, @RequestParam("rows") int rows,
			@RequestParam(value = "conteTitle", required = false) String conteTitle) {
		// Integer pageIndex =pageNumber== null ?0:pageNumber;
		// Integer pageSize2 =pageSize== null ?5:pageSize;
		Map<String, Object> map = new HashMap<String, Object>();
		// 总条数
		int count = systemSettingService.getRoleCount();
		int pageIndex = (page - 1) * rows;
		map.put("pageIndex", pageIndex);
		map.put("pageSize", rows);
		Map<String, Object> maps = new HashMap<String, Object>();
		if (conteTitle != "" && conteTitle != null) {
			String title = "%" + conteTitle + "%";
			System.out.println(title);
			map.put("title", title);
			int count2 = systemSettingService.getRoleCountByTitle(title);
			List<Role> list = systemSettingService.getAllRole(map);
			maps.put("rows", list);
			maps.put("total", count2);

		} else {
			List<Role> list = systemSettingService.getAllRole(map);
			maps.put("rows", list);
			maps.put("total", count);
		}
		return maps;
	}

	// 树形菜单 授权用
	@ResponseBody
	@RequestMapping("/powerImpowerList")
	public List<Power> getAllPower(Integer id) {
		Integer navsId = id == null ? 0 : id;
		List<Power> list = systemSettingService.selectPower(navsId);
		return list;
	}

	@ResponseBody
	@RequestMapping("/newInpower")
	public int newInpowerGetId(int rid, HttpSession session) {
		session.setAttribute("inpowerId", rid);
		return rid;
	}

	// 给角色授权
	@RequestMapping("/impowerStart")
	public String impowerStart(String str, HttpSession session) {
		int rid = (int) session.getAttribute("inpowerId");
		systemSettingService.deleteRid(rid);
		String[] st = str.split(",");
		for (String string : st) {
			int id = Integer.parseInt(string);
			systemSettingService.insertImpower(rid, id);
		}
		return "rolemanager";
	}

	// 组织结构开始
	// 首先跳转到页面
	@RequestMapping("/organization")
	public String organization() {
		return "organization_structure";
	}

	// 查询出所有的部门
	@ResponseBody
	@RequestMapping("/getAllorganization")
	public Map<String, Object> getAllOrg(@RequestParam("page") int page, @RequestParam("rows") int rows,
			@RequestParam(value = "conteTitle", required = false) String conteTitle) {
		Map<String, Object> map = new HashMap<>();
		// 总条数
		int departmentCount = systemSettingService.getDepartmentCount();
		int pageIndex = (page - 1) * rows;
		map.put("pageIndex", pageIndex);
		map.put("pageSize", rows);
		Map<String, Object> maps = new HashMap<String, Object>();
		if (conteTitle != "" && conteTitle != null) {
			String title = "%" + conteTitle + "%";
			System.out.println(title);
			map.put("title", title);
			int count2 = systemSettingService.getDePartmentCountByTitle(title);
			List<Department> list = systemSettingService.getAllDepartment(map);

			maps.put("rows", list);
			maps.put("total", count2);

		} else {
			List<Department> list = systemSettingService.getAllDepartment(map);
			maps.put("rows", list);
			maps.put("total", departmentCount);
		}
		return maps;
	}

	// 增加部门
	@RequestMapping("/insertDepartment")
	public String insertDepartment(Department department, @RequestParam(value = "dnid") int dnid, HttpSession session) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = sdf.format(new Date());
		Staff staff = (Staff) session.getAttribute("staff");
		department.setDdate(time);
		department.setCzid(staff.getSid());
		department.setDnid(dnid);
		systemSettingService.insertDepartment(department);
		return "organization_structure";
	}

	// 删除部门
	@RequestMapping("/deleteDepartment")
	public String deleteDepartment(int did) {
		systemSettingService.deleteDepartmentById(did);
		return "organization_structure";
	}

	// 先找到我要修改的对象
	@ResponseBody
	@RequestMapping("/updateDepartmentById")
	public Department updateById(int did) {
		Department department = new Department();
		department = systemSettingService.updateDepartmentById(did);
		return department;
	}

	// 修改部门
	@RequestMapping("/updateDepartment")
	public String updateDepartment(Department department, HttpSession session) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = sdf.format(new Date());
		department.setDdate(time);
		Staff staff = (Staff) session.getAttribute("staff");
		department.setCzid(staff.getSid());
		systemSettingService.updateDepartment(department);
		return "organization_structure";
	}

	// 跳进详细信息页面
	@RequestMapping("/personal")
	public String personal() {
		return "personal_details";
	}

	// 修改用户名
	@RequestMapping("/updateUserName")
	public String updateUserName(String name, HttpSession session) {
		Staff staff = (Staff) session.getAttribute("staff");
		Map<String, Object> map = new HashMap<>();
		map.put("name", name);
		map.put("id", staff.getSid());
		systemSettingService.updateStaffNusername(map);
		return "personal_details";
	}

	// 修改电话号码
	@RequestMapping("/updateIphone")
	public String updateNumber(String number, HttpSession session) {
		Staff staff = (Staff) session.getAttribute("staff");
		Map<String, Object> map = new HashMap<>();
		map.put("number", number);
		map.put("id", staff.getSid());
		systemSettingService.updateStaffIphone(map);
		return "personal_details";
	}

	// 验证密码
	@ResponseBody
	@RequestMapping("/selectPwd")
	public boolean selecPasswword(String password, HttpSession session) {
		/*Staff staff = new Staff();
		Staff staff2 = (Staff) session.getAttribute("staff");
		Map<String, Object> map = new HashMap<>();
		map.put("password", password);
		map.put("id", staff2.getSid());*/
		Staff staff2 = (Staff) session.getAttribute("staff");
		if(password.equals(staff2.getPassword())){
			return true;
		}
		//staff = systemSettingService.selectPassword(map);
		/*if (staff != null) {
			return staff;
		}*/
		return false;
	}

	// 修改密码
	@ResponseBody
	@RequestMapping("/updatePwd")
	public Map<String, Object> updateMima(String newPassword, HttpSession session) {
		Staff staff2 = (Staff) session.getAttribute("staff");
		Map<String, Object> map = new HashMap<>();
		map.put("password", newPassword);
		map.put("id", staff2.getSid());
		systemSettingService.updatePassword(map);
		return map;
	}

	// 员工管理开始
	// 首先进入他的页面
	@RequestMapping("/staffmanager")
	public String staffManager() {
		return "staff_manager";
	}

	// 查询出他们的数据
	@ResponseBody
	@RequestMapping("/getAllStaff")
	public Map<String, Object> getStaff(@RequestParam("page") int page, @RequestParam("rows") int rows,
			@RequestParam(value = "conteTitle", required = false) String conteTitle) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 总条数
		int count = systemSettingService.getStaffCount();
		int pageIndex = (page - 1) * rows;
		map.put("pageIndex", pageIndex);
		map.put("pageSize", rows);
		Map<String, Object> maps = new HashMap<String, Object>();
		
		if (conteTitle != "" && conteTitle != null) {
			String title = "%" + conteTitle + "%";
			map.put("title", title);
			int count2 = systemSettingService.getStaffCountByTitle(title);
			List<Staff> list = systemSettingService.selectAllStaff(map);
			maps.put("rows", list);
			maps.put("total", count2);
			
		} else {
			List<Staff> list = systemSettingService.selectAllStaff(map);
			maps.put("rows", list);
			maps.put("total", count);
		}
		return maps;
	}
	//增加员工
	@RequestMapping("/insertAllStaff")
	public String insertIntoStaff(Staff staff,HttpSession session){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String time = sdf.format(new Date());
			staff.setSdate(time);
			Staff staff2 = (Staff) session.getAttribute("staff");
			staff.setCzid(staff2.getSid());
			systemSettingService.insertStaff(staff);
			return "staff_manager";
	}
	//删除员工
	@RequestMapping("/deleteStaff")
	public String deleteStaffById(int sid){
		systemSettingService.deleteStaff(sid);
		return "staff_manager";
	}
	//修改员工找到修改的员工对象
	@ResponseBody
	@RequestMapping("/updateStaffById")
	public Staff updateStafforId(int sid){
		Staff staff = new Staff();
		staff = systemSettingService.updateStaffById(sid);
		return staff;
	}
	//开始修改
	@RequestMapping("/updateStaffStart")
	public String updateStaff(Staff staff,HttpSession session){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = sdf.format(new Date());
		staff.setSdate(time);
		Staff staff2 = (Staff) session.getAttribute("staff");
		staff.setCzid(staff2.getSid());
		systemSettingService.updateStaff(staff);
		return "staff_manager";
	}
	//查看页面
	@RequestMapping("/staffDDD")
	public String stt(){
		return "staff_details";
	}
	
	@RequestMapping("/staffDetails")
	public String staffDetails(@RequestParam("sid") int sid,HttpSession session){
		Staff staff = new Staff();
		staff = systemSettingService.seeStaffById(sid);
		session.setAttribute("staffSee", staff);
	
		return "staff_details";
	}
	//返回用
	@RequestMapping("/staff_manager")
	public String staffffmanager(){
		return "staff_manager";
	}
	//给员工授权角色
	//先跳到页面
	@RequestMapping("/staff_impower")
	public String staffImpower(){
		return "staff_impower";
	}
	//给员工授权
	@RequestMapping("/staffImpowerPlace")
	public String staffImpowerPlace(int rid,HttpSession session){
		Staff staff = new Staff();
		staff= (Staff) session.getAttribute("staffSee");
		systemSettingService.updateRid(rid,staff.getSid());
		return "staff_impower";
	}
	//开始跳转到公告页面
	@RequestMapping("/noticeManager")
	public String noticeMag(){
		return "notice_manager";
	}
	
	//公告的分页
	@ResponseBody
	@RequestMapping("/getAllnotice")
	public Map<String,Object> getAllNotice(@RequestParam("page") int page, @RequestParam("rows") int rows,
			@RequestParam(value = "conteTitle", required = false) String conteTitle){
		Map<String, Object> map = new HashMap<String, Object>();
		// 总条数
		int count = systemSettingService.getNoticeCount();
		int pageIndex = (page - 1) * rows;
		map.put("pageIndex", pageIndex);
		map.put("pageSize", rows);
		Map<String, Object> maps = new HashMap<String, Object>();
		
		if (conteTitle != "" && conteTitle != null) {
			String title = "%" + conteTitle + "%";
			map.put("title", title);
			int count2 = systemSettingService.getNoticeCountByTitle(title);
			List<Notice> list = systemSettingService.getAllNoticeList(map);
			maps.put("rows", list);
			maps.put("total", count2);
			
		} else {
			List<Notice> list = systemSettingService.getAllNoticeList(map);

			maps.put("rows", list);
			maps.put("total", count);
		}
		return maps;
	}
	
	//公告的类型
	@ResponseBody
	@RequestMapping("/getNoticeType")
	public List<Notice_type> getAllNoticeType(){
		List<Notice_type> list = systemSettingService.getAllNoticeType();	
		return list;
	}
	//增加公告
	@RequestMapping("/insertNotice")
	public String insertNo(Notice notice,@RequestParam(value="type_id") int type_id,HttpSession session){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = sdf.format(new Date());
		Staff staff = (Staff) session.getAttribute("staff");
		System.out.println(staff);
		notice.setSid(staff.getSid());
		notice.setNoticeTime(time);
		notice.setNoticeType(type_id);
		systemSettingService.insertNoticeAll(notice);
		return "notice_manager";
	}
	//删除公告
	@RequestMapping("/deleteNotice")
	public String deleteNotice(int noticeId){
		systemSettingService.deleteNoticeById(noticeId);
		return "notice_manager";
	}
	//
	@RequestMapping("/notice_de")
	public String notice_de(){
		return "notice_details";
	}
	
	@RequestMapping("/noticeDetails")
	public String noticeDeta(int noticeId,HttpSession session){
		Notice notice = new Notice();
		notice = systemSettingService.seeNoticeById(noticeId);
		session.setAttribute("notice",notice);
		return "notice_details";
	}
	//
	@ResponseBody
	@RequestMapping("/updateNoticeById")
	public Notice getNoticeById(int noticeId){
		Notice notice=systemSettingService.seeNoticeById(noticeId);
		return notice;
	}
	//修改公告
	@RequestMapping("/updateNoticeStart")
	public String updateNotice(Notice notice,HttpSession session){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = sdf.format(new Date());
		notice.setNoticeTime(time);
		systemSettingService.updateNoticeStart(notice);
		return "notice_manager";
	}
	
	//基础信息
	@RequestMapping("/baseManager")
	public String baseManager(){
		return "base_manager";
	}
	
	//基础信息分页
	@ResponseBody
	@RequestMapping("/getAllbase")
	public Map<String,Object> getAllBases(@RequestParam("page") int page, @RequestParam("rows") int rows,
			@RequestParam(value = "conteTitle", required = false) String conteTitle){
		Map<String, Object> map = new HashMap<String, Object>();
		// 总条数
		int count = systemSettingService.getBaseCount();
		int pageIndex = (page - 1) * rows;
		map.put("pageIndex", pageIndex);
		map.put("pageSize", rows);
		Map<String, Object> maps = new HashMap<String, Object>();
		
		if (conteTitle != "" && conteTitle != null) {
			String title = "%" + conteTitle + "%";
			map.put("title", title);
			int count2 = systemSettingService.getBaseCountByTitle(title);
			List<Base> list = systemSettingService.getAllBaseList(map);
			maps.put("rows", list);
			maps.put("total", count2);
			
		} else {
			List<Base> list = systemSettingService.getAllBaseList(map);
			maps.put("rows", list);
			maps.put("total", count);
		}
		return maps;
	}
	//增加基础信息
	@RequestMapping("/insertBase")
	public String insertBases(Base base,HttpSession session){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = sdf.format(new Date());
		Staff staff = (Staff) session.getAttribute("staff");
		base.setSid(staff.getSid());
		base.setBasetime(time);
		systemSettingService.insertBases(base);
		return "base_manager";
	}
	//删除基础信息
	@RequestMapping("/deleteBase")
	public String deleteBases(int baseid){
		systemSettingService.deleteBases(baseid);
		return "base_manager";
	}
	
	//先找到要修改的对象
	@ResponseBody
	@RequestMapping("/updateBaseById")
	public Base updateBaseId(int baseid){
		Base base = systemSettingService.updateBaseById(baseid);
		return base;
	}
	//开始修改
	@RequestMapping("/updateBaseStart")
	public String updateBaseStarts(Base base,HttpSession session){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = sdf.format(new Date());
		Staff staff = (Staff) session.getAttribute("staff");
		base.setBasetime(time);
		base.setSid(staff.getSid());
		systemSettingService.updateBase(base);
		return "base_manager";
	}
	
	//调到数据字典页面
	@RequestMapping("/data_dictionary_manager")
	public String data_dict(){
		return "data_dictionary_manager";
	}
	//数据字典分页
	@ResponseBody
	@RequestMapping("/getAllDataDictionary")
	public Map<String,Object> getAllData(@RequestParam("page") int page, @RequestParam("rows") int rows,
			@RequestParam(value = "conteTitle", required = false) String conteTitle){
		Map<String, Object> map = new HashMap<String, Object>();
		// 总条数
		int count = systemSettingService.getDataCount();
		int pageIndex = (page - 1) * rows;
		map.put("pageIndex", pageIndex);
		map.put("pageSize", rows);
		Map<String, Object> maps = new HashMap<String, Object>();
		
		if (conteTitle != "" && conteTitle != null) {
			String title = "%" + conteTitle + "%";
			map.put("title", title);
			int count2 = systemSettingService.getDataCountByTitle(title);
			List<Data_dictionary> list = systemSettingService.getAllDataList(map);
			maps.put("rows", list);
			maps.put("total", count2);
			
		} else {
			List<Data_dictionary> list = systemSettingService.getAllDataList(map);
			maps.put("rows", list);
			maps.put("total", count);
		}
		return maps;
	}
	//增加数据字典
	@RequestMapping("/insertData")
	public String insertDatas(Data_dictionary data_dictionary,HttpSession session){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = sdf.format(new Date());
		Staff staff = (Staff) session.getAttribute("staff");
		data_dictionary.setDatatime(time);
		data_dictionary.setSid(staff.getSid());
		systemSettingService.insertData(data_dictionary);
		return "data_dictionary_manager";
	}
	
	//删除数据字典
	@RequestMapping("/deleteData")
	public String deleteDatas(int dataid){
		systemSettingService.deleteData(dataid);
		return "data_dictionary_manager";
	}
	
	//修改前先拿到对象
	@ResponseBody
	@RequestMapping("/updateDataById")
	public Data_dictionary updateDataByIds(int dataid){
		Data_dictionary data_dictionary=systemSettingService.updateDataById(dataid);
		return data_dictionary;
	}
	
	//开始修改
	@RequestMapping("/updateDataStart")
	public String updateDataStarts(Data_dictionary data_dictionary,HttpSession session){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = sdf.format(new Date());
		Staff staff = (Staff) session.getAttribute("staff");
		data_dictionary.setDatatime(time);
		data_dictionary.setSid(staff.getSid());
		systemSettingService.updateData(data_dictionary);
		return "data_dictionary_manager";
	}
}














