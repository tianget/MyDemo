package com.lxit.crm.entities;

public class Staff {
	private Integer sid;

	private String name;

	private String sex;

	private String sstate;

	private Integer did;

	private Integer rid;

	private String password;

	private String sremark;

	private String sdate;

	private Integer czid;

	private String nusername;

	private int superiorId;

	private Role role;

	private String iphonenumber;

	private String caoName;

	private String departmentName;

	private String jName;

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
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

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSstate() {
		return sstate;
	}

	public void setSstate(String sstate) {
		this.sstate = sstate;
	}

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSremark() {
		return sremark;
	}

	public void setSremark(String sremark) {
		this.sremark = sremark;
	}



	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public Integer getCzid() {
		return czid;
	}

	public void setCzid(Integer czid) {
		this.czid = czid;
	}

	public String getNusername() {
		return nusername;
	}

	public void setNusername(String nusername) {
		this.nusername = nusername;
	}

	public int getSuperiorId() {
		return superiorId;
	}

	public void setSuperiorId(int superiorId) {
		this.superiorId = superiorId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}


	public String getIphonenumber() {
		return iphonenumber;
	}

    public String getSdate() {
    	if(null!=this.sdate){
	    	if(this.sdate.contains(".")){
	    		return sdate.substring(0,this.sdate.lastIndexOf("."));
	    	}
    	}
        return sdate;
    }


	public void setIphonenumber(String iphonenumber) {
		this.iphonenumber = iphonenumber;
	}

	public String getCaoName() {
		return caoName;
	}

	public void setCaoName(String caoName) {
		this.caoName = caoName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getjName() {
		return jName;
	}

	public void setjName(String jName) {
		this.jName = jName;
	}

	@Override
	public String toString() {
		return "Staff [sid=" + sid + ", name=" + name + ", sex=" + sex + ", sstate=" + sstate + ", did=" + did
				+ ", rid=" + rid + ", password=" + password + ", sremark=" + sremark + ", sdate=" + sdate + ", czid="
				+ czid + ", nusername=" + nusername + ", iphonenumber=" + iphonenumber + ", caoName=" + caoName
				+ ", departmentName=" + departmentName + ", jName=" + jName + ", role=" + role + "]";
	}

}