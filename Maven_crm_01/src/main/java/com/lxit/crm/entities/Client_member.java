package com.lxit.crm.entities;


import java.util.Date;


public class Client_member {
    private int mid;
    private String encode;			//客户编码
    private String name;			//客户姓名
    private String sex;				//性别
    private String birth;			//生日
    private String recordDate;       //录入时间
    private String type;			//类型
    private String status;			//状态
    private String phone;			//电话号码
    private String workPhone;		//办公电话
    private String email;			//电子邮箱
    private String familyPhone;		//家庭
    private String address;			//联系地址
    private int sid;				//录入人
    
    
   
	private String remarks;			//备注信息


	private Staff staff;// 用户服务代表对象


	private String sname;


	public int getMid() {
		return mid;
	}


	public void setMid(int mid) {
		this.mid = mid;
	}


	public String getEncode() {
		return encode;
	}


	public void setEncode(String encode) {
		this.encode = encode;
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


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getBirth() {
		return birth;
	}


	public void setBirth(String birth) {
		this.birth = birth;
	}


	public String getRecordDate() {
		return recordDate;
	}


	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getWorkPhone() {
		return workPhone;
	}


	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFamilyPhone() {
		return familyPhone;
	}


	public void setFamilyPhone(String familyPhone) {
		this.familyPhone = familyPhone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getSid() {
		return sid;
	}


	public void setSid(int sid) {
		this.sid = sid;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public Staff getStaff() {
		return staff;
	}


	public void setStaff(Staff staff) {
		this.staff = staff;
	}


	public String getSname() {
		return sname;
	}


	public void setSname(String sname) {
		this.sname = sname;
	}


	@Override
	public String toString() {
		return "Client_member [mid=" + mid + ", encode=" + encode + ", name=" + name + ", sex=" + sex + ", birth="
				+ birth + ", recordDate=" + recordDate + ", type=" + type + ", status=" + status + ", phone=" + phone
				+ ", workPhone=" + workPhone + ", email=" + email + ", familyPhone=" + familyPhone + ", address="
				+ address + ", sid=" + sid + ", remarks=" + remarks + ", staff=" + staff + ", sname=" + sname + "]";
	}


	
	
}