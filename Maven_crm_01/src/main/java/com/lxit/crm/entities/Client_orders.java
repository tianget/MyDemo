package com.lxit.crm.entities;

public class Client_orders {
    private int oid;
    private int onum;
    private String otype;
    private String opayment;
    private Double oprice;
    private String otime;
    private String oinvoice;
    private String ostatus;
    private String mname;
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getOnum() {
		return onum;
	}
	public void setOnum(int onum) {
		this.onum = onum;
	}
	public String getOtype() {
		return otype;
	}
	public void setOtype(String otype) {
		this.otype = otype;
	}
	public String getOpayment() {
		return opayment;
	}
	public void setOpayment(String opayment) {
		this.opayment = opayment;
	}
	public Double getOprice() {
		return oprice;
	}
	public void setOprice(Double oprice) {
		this.oprice = oprice;
	}
	public String getOtime() {
		return otime;
	}
	public void setOtime(String otime) {
		this.otime = otime;
	}
	public String getOinvoice() {
		return oinvoice;
	}
	public void setOinvoice(String oinvoice) {
		this.oinvoice = oinvoice;
	}
	public String getOstatus() {
		return ostatus;
	}
	public void setOstatus(String ostatus) {
		this.ostatus = ostatus;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	@Override
	public String toString() {
		return "Client_orders [oid=" + oid + ", onum=" + onum + ", otype=" + otype + ", opayment=" + opayment
				+ ", oprice=" + oprice + ", otime=" + otime + ", oinvoice=" + oinvoice + ", ostatus=" + ostatus
				+ ", mname=" + mname + "]";
	}
	
    
}
