package com.lxit.crm.entities;

public class Client_allot {
    private int id;
    private String name;      //客户姓名
    private String sex;		  //性别
    private String type;	  //客户类型
    private String condition; //客户状态
    private String allot;     //分配状态
    private String date;	  //录入时间
    private int sid;		  //分配给的人
    private int staffid;	  //录入人
    private String staff_id;   //录入人
    private int mid;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public int getStaffid() {
		return staffid;
	}
	public void setStaffid(int staffid) {
		this.staffid = staffid;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getAllot() {
		return allot;
	}
	public void setAllot(String allot) {
		this.allot = allot;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}
	@Override
	public String toString() {
		return "Client_allot [id=" + id + ", name=" + name + ", sex=" + sex + ", type=" + type + ", condition="
				+ condition + ", allot=" + allot + ", date=" + date + ", sid=" + sid + ", staffid=" + staffid
				+ ", staff_id=" + staff_id + ", mid=" + mid + "]";
	}
	
	
	
	
    
}
