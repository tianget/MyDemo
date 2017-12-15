package com.lxit.crm.entities;

import java.util.Date;

public class ClientRemind {
    private int id;				

    private String name;		//客户姓名

    private String time;			//提醒时间  格式2013-04-21 09:00:00

    private String type;		//提醒类型

    private String frequency;	//提醒频率

    private String scheme;		//方案
    
    private int mid;
    private int take;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public String getScheme() {
		return scheme;
	}
	public void setScheme(String scheme) {
		this.scheme = scheme;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getTake() {
		return take;
	}
	public void setTake(int take) {
		this.take = take;
	}
	@Override
	public String toString() {
		return "ClientRemind [id=" + id + ", name=" + name + ", time=" + time + ", type=" + type + ", frequency="
				+ frequency + ", scheme=" + scheme + ", mid=" + mid + ", take=" + take + "]";
	}

   
}