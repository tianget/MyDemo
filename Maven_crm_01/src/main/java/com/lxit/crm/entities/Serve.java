package com.lxit.crm.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 服务单据管理
 * 
 * @author LY
 *
 */
public class Serve {
    private Integer sid; //标识列
    private Integer id ;//sid 与Staff的标识列冲突

    private String sname; //服务单据名称（新建后不可更改）

    private String stype; //服务类型（业务咨询/投诉问题/售前问题/售后问题）

    private String sstatus; //服务单据状态（新创建/已提交/已分配/已反馈/已处理）
    
    private String screateTime; //单据创建时间

    private String slastTime; //最后操作时间

    private String screater; //创建人，外键
    
    private Staff staff;

    private String shandler; //操作人，外键

    private String sallot; //待处理人，外键

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public String getStype() {
        return stype;
    }

    public void setStype(String stype) {
        this.stype = stype == null ? null : stype.trim();
    }

    public String getSstatus() {
        return sstatus;
    }

    public void setSstatus(String sstatus) {
        this.sstatus = sstatus == null ? null : sstatus.trim();
    }

    public String getScreateTime() {
    	if(null!=this.screateTime){
	    	if(this.screateTime.contains(".")){
	    		return screateTime.substring(0,this.screateTime.lastIndexOf("."));
	    	}
    	}
        return screateTime;
    }

    public void setScreateTime(String screateTime) {
        this.screateTime = screateTime;
    }

    public String getSlastTime() {
    	if(null!=this.slastTime){
	    	if(this.slastTime.contains(".")){
	    		return slastTime.substring(0,this.slastTime.lastIndexOf("."));
	    	}
    	}
        return slastTime;
    }

    public void setSlastTime(String slastTime) {
        this.slastTime = slastTime;
    }

    public String getScreater() {
        return screater;
    }

    public void setScreater(String screater) {
        this.screater = screater;
    }

    public String getShandler() {
        return shandler;
    }

    public void setShandler(String shandler) {
        this.shandler = shandler;
    }

    public String getSallot() {
        return sallot;
    }

    public void setSallot(String sallot) {
        this.sallot = sallot;
    }
    
	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Serve [sid=" + sid + ", id=" + id + ", sname=" + sname + ", stype=" + stype + ", sstatus=" + sstatus
				+ ", screateTime=" + screateTime + ", slastTime=" + slastTime + ", screater=" + screater + ", shandler="
				+ shandler + ", sallot=" + sallot + "]";
	}
    
}