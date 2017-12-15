package com.lxit.crm.entities;

public class Client_order {
	private int mid;			//客户id	
    private String name;		//客户姓名
    private String sex;         //性别
    private String type;        //客户类型
    private String ostatus;		//订单状态
    private int count;			//订单数量
	
	public int getMid() {
		return mid;
	}
	public String getSex() {
		return sex;
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
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOstatus() {
		return ostatus;
	}
	public void setOstatus(String ostatus) {
		this.ostatus = ostatus;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Client_order [mid=" + mid + ", name=" + name + ", ostatus=" + ostatus + ", count=" + count + "]";
	}
	
    
}
