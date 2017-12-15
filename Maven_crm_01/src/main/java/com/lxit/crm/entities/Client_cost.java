package com.lxit.crm.entities;

public class Client_cost {
    private Integer mid;
    private String name;      //客户姓名
    private String sex;		  //客户性别
    private String type;	  //客户类型
    private int number;	 	  //已消费次数
    private String sum;		  //消费总额（万元）
    private String sid; 	  //负责人
	
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getSum() {
		return sum;
	}
	public void setSum(String sum) {
		this.sum = sum;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	@Override
	public String toString() {
		return "Client_cost [mid=" + mid + ", name=" + name + ", sex=" + sex + ", type=" + type + ", number=" + number
				+ ", sum=" + sum + ", sid=" + sid + "]";
	}
	
	
    
    
}
