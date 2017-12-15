package com.lxit.crm.entities;

public class Statistics {

	private int client; //客户数量
	
	private int lsClient; //客户流失数量
	
	private double contribute; //客户贡献（万元）
	
	private int serve; //服务数量
	
	private String month; //月份
	
	private String withThan; //同比
	
	private String loopThan; //环比
	
/*	private int lastMonthMoney;//上个月
	
	private int lastYearMoney;*/

	

	
	
	public double getContribute() {
		return contribute;
	}

	public int getClient() {
		return client;
	}

	public void setClient(int client) {
		this.client = client;
	}

	public int getLsClient() {
		return lsClient;
	}

	public void setLsClient(int lsClient) {
		this.lsClient = lsClient;
	}

	public int getServe() {
		return serve;
	}

	public void setServe(int serve) {
		this.serve = serve;
	}

	public void setContribute(double contribute) {
		this.contribute = contribute;
	}



	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getWithThan() {
		return withThan;
	}

	public void setWithThan(String withThan) {
		this.withThan = withThan;
	}

	public String getLoopThan() {
		return loopThan;
	}

	public void setLoopThan(String loopThan) {
		this.loopThan = loopThan;
	}
	
	
	
	
}
