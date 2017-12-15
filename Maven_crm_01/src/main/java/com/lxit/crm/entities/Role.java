package com.lxit.crm.entities;

import java.util.Date;

public class Role {
	private Integer rid;

	private String rcoding;

	private String rname;

	private Integer czid;

	private Integer did;

	private String rdate;

	private String rremark;

	private Department department;

	private String departmentName;

	private String caozuoName;

	public String getCaozuoName() {
		return caozuoName;
	}

	public void setCaozuoName(String caozuoName) {
		this.caozuoName = caozuoName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getRcoding() {
		return rcoding;
	}

	public void setRcoding(String rcoding) {
		this.rcoding = rcoding == null ? null : rcoding.trim();
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname == null ? null : rname.trim();
	}

	public Integer getCzid() {
		return czid;
	}

	public void setCzid(Integer czid) {
		this.czid = czid;
	}

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public String getRdate() {
		if (null != this.rdate) {
			if (this.rdate.contains(".")) {
				return rdate.substring(0, this.rdate.lastIndexOf("."));
			}
		}
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public String getRremark() {
		return rremark;
	}

	public void setRremark(String rremark) {
		this.rremark = rremark == null ? null : rremark.trim();
	}

	@Override
	public String toString() {
		return "Role [rid=" + rid + ", rcoding=" + rcoding + ", rname=" + rname + ", czid=" + czid + ", did=" + did
				+ ", rdate=" + rdate + ", rremark=" + rremark + ", department=" + department + ", departmentName="
				+ departmentName + ", caozuoName=" + caozuoName + "]";
	}

}