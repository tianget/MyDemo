package com.lxit.crm.entities;

public class ClientLoving {
    private int mid;
    private String name;
    private String sex;
    private String type;
    private double count;
    private String overall;
    private int acount;
    private int ccount;
    private String scheme;
    private String abcd;
    
    
	public String getAbcd() {
		return abcd;
	}
	public void setAbcd(String abcd) {
		this.abcd = abcd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getMid() {
		return mid;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getCount() {
		return count;
	}
	public void setCount(double count) {
		this.count = count;
	}
	public String getOverall() {
		return overall;
	}
	public void setOverall(String overall) {
		this.overall = overall;
	}
	public int getAcount() {
		return acount;
	}
	public void setAcount(int acount) {
		this.acount = acount;
	}
	public int getCcount() {
		return ccount;
	}
	public void setCcount(int ccount) {
		this.ccount = ccount;
	}
	public String getScheme() {
		return scheme;
	}
	public void setScheme(String scheme) {
		this.scheme = scheme;
	}
	@Override
	public String toString() {
		return "ClientLoving [mid=" + mid + ", name=" + name + ", sex=" + sex + ", type=" + type + ", count=" + count
				+ ", overall=" + overall + ", acount=" + acount + ", ccount=" + ccount + ", scheme=" + scheme
				+ ", abcd=" + abcd + "]";
	}
	
	
    
}
