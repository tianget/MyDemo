package com.lxit.crm.entities;

import java.util.Date;

import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public class Pact {
	private Integer pid;		//合同id

	private String pname;		//合同名称

	private String ptype;		//合同类型

	private String pstate;		//合同状态

	private String plasttime;	//最后操作时间

	private String ppeople;		//待处理人
	
	private Integer pmoney;		//合同金额

	private String pjia;		//合同甲方

	private String pyi;			//合同乙方

	private String poperatejia;	//甲方企业经营许可号

	private String poperateyi;	//乙方企业经营许可号

	private String pcontent;	//合同内容

	private String premarks;	//备注信息

	private String pchange;		//变更原因

	private String premove;		//解除原因

	private String passignment;	//转让原因
	
	private String poperator; //创建人
	
	private String pcreateTime; //创建时间
	
	private String pexamine;    //审批意见
	

	/*public Pact() {
		super();
	}*/
	
	
	
	public Integer getPid() {
		return pid;
	}

	public String getPexamine() {
		return pexamine;
	}

	public void setPexamine(String pexamine) {
		this.pexamine = pexamine;
	}

	public String getPcreateTime() {
		if(null!=this.pcreateTime){
	    	if(this.pcreateTime.contains(".")){
	    		return pcreateTime.substring(0,this.pcreateTime.lastIndexOf("."));
	    	}
    	}
		return pcreateTime;
	}

	public void setPcreateTime(String pcreateTime) {
		this.pcreateTime = pcreateTime;
	}

	public String getPoperator() {
		return poperator;
	}

	public void setPoperator(String poperator) {
		this.poperator = poperator;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname == null ? null : pname.trim();
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype == null ? null : ptype.trim();
	}

	public String getPstate() {
		return pstate;
	}

	public void setPstate(String pstate) {
		this.pstate = pstate == null ? null : pstate.trim();
	}

	public String getPlasttime() {
		return plasttime;
	}

	public void setPlasttime(String plasttime) {
		this.plasttime = plasttime;
	}

	public String getPpeople() {
		return ppeople;
	}

	public void setPpeople(String ppeople) {
		this.ppeople = ppeople == null ? null : ppeople.trim();
	}

	public Integer getPmoney() {
		return pmoney;
	}

	public void setPmoney(Integer pmoney) {
		this.pmoney = pmoney;
	}

	public String getPjia() {
		return pjia;
	}

	public void setPjia(String pjia) {
		this.pjia = pjia;
	}

	public String getPyi() {
		return pyi;
	}

	public void setPyi(String pyi) {
		this.pyi = pyi;
	}

	public String getPoperatejia() {
		return poperatejia;
	}

	public void setPoperatejia(String poperatejia) {
		this.poperatejia = poperatejia;
	}

	public String getPoperateyi() {
		return poperateyi;
	}

	public void setPoperateyi(String poperateyi) {
		this.poperateyi = poperateyi;
	}

	public String getPcontent() {
		return pcontent;
	}

	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}

	public String getPremarks() {
		return premarks;
	}

	public void setPremarks(String premarks) {
		this.premarks = premarks;
	}

	public String getPchange() {
		return pchange;
	}

	public void setPchange(String pchange) {
		this.pchange = pchange;
	}

	public String getPremove() {
		return premove;
	}

	public void setPremove(String premove) {
		this.premove = premove;
	}

	public String getPassignment() {
		return passignment;
	}

	public void setPassignment(String passignment) {
		this.passignment = passignment;
	}
	
	
	
	
	

	@Override
	public String toString() {
		return "Pact [pid=" + pid + ", pname=" + pname + ", ptype=" + ptype + ", pstate=" + pstate + ", plasttime="
				+ plasttime + ", ppeople=" + ppeople + ", pmoney=" + pmoney + ", pjia=" + pjia + ", pyi=" + pyi
				+ ", poperatejia=" + poperatejia + ", poperateyi=" + poperateyi + ", pcontent=" + pcontent
				+ ", premarks=" + premarks + ", pchange=" + pchange + ", premove=" + premove + ", passignment="
				+ passignment + ", poperator=" + poperator + ", pcreateTime=" + pcreateTime + ", pexamine=" + pexamine
				+ "]";
	}

	
	
	
}