package com.lxit.crm.entities;

import java.util.Date;

public class ClientScheme {
    private int scid;

    private String name;		//关怀名称

    private String date;			//执行时间   格式2013-06-17 11:05:25

    private String scheme;		//执行方案
    
    private String finallys;	//执行结果

    private String remark;		//备注信息
    
    private int mid;
 
    



	

	public int getScid() {
		return scid;
	}

	public void setScid(int scid) {
		this.scid = scid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getScheme() {
		return scheme;
	}

	public void setScheme(String scheme) {
		this.scheme = scheme;
	}

	public String getFinallys() {
		return finallys;
	}

	public void setFinallys(String finallys) {
		this.finallys = finallys;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	@Override
	public String toString() {
		return "ClientScheme [scid=" + scid + ", name=" + name + ", date=" + date + ", scheme=" + scheme + ", finallys="
				+ finallys + ", remark=" + remark + ", mid=" + mid + "]";
	}

	

	

	
   
}