package com.lxit.crm.entities;

public class Servereplenish {
    private Integer srid; //标识列

    private String sclient; //服务客户,（一旦创建不可更改）

    private String clientPhone; //联系电话（客户的电话）

    private String scontent; //服务内容

    private String sremark; //备注信息

    private String handleResult;//处理结果

    private String handleExplain;//处理说明

    private String ticklingResult;//反馈结果

    private String ticklingExplain;//反馈说明

   // private Integer sid;
    private Serve serve;
	public Integer getSrid() {
		return srid;
	}
	public void setSrid(Integer srid) {
		this.srid = srid;
	}
	public String getSclient() {
		return sclient;
	}
	public String getClientPhone() {
		return clientPhone;
	}
	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}
	public void setSclient(String sclient) {
		this.sclient = sclient;
	}
	public String getScontent() {
		return scontent;
	}
	public void setScontent(String scontent) {
		this.scontent = scontent;
	}
	public String getSremark() {
		return sremark;
	}
	public void setSremark(String sremark) {
		this.sremark = sremark;
	}
	public String getHandleResult() {
		return handleResult;
	}
	public void setHandleResult(String handleResult) {
		this.handleResult = handleResult;
	}
	public String getHandleExplain() {
		return handleExplain;
	}
	public void setHandleExplain(String handleExplain) {
		this.handleExplain = handleExplain;
	}
	public String getTicklingResult() {
		return ticklingResult;
	}
	public void setTicklingResult(String ticklingResult) {
		this.ticklingResult = ticklingResult;
	}
	public String getTicklingExplain() {
		return ticklingExplain;
	}
	public void setTicklingExplain(String ticklingExplain) {
		this.ticklingExplain = ticklingExplain;
	}
	public Serve getServe() {
		return serve;
	}
	public void setServe(Serve serve) {
		this.serve = serve;
	}

	@Override
	public String toString() {
		return "Servereplenish [srid=" + srid + ", sclient=" + sclient + ", clientPhone=" + clientPhone + ", scontent="
				+ scontent + ", sremark=" + sremark + ", handleResult=" + handleResult + ", handleExplain="
				+ handleExplain + ", ticklingResult=" + ticklingResult + ", ticklingExplain=" + ticklingExplain
				+ ", serve=" + serve + "]";
	}
    
}