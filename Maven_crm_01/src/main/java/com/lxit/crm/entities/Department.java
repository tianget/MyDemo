package com.lxit.crm.entities;

import java.util.Date;

public class Department {
	private Integer did;

	private String dcoding;

	private String dshortname;

	private String ddate;

	private Integer czid;

	private String dallname;

	private String dintro;

	private String dremark;

	private int dnid;

	private String caoName;

	public String getCaoName() {
		return caoName;
	}

	public void setCaoName(String caoName) {
		this.caoName = caoName;
	}

	public int getDnid() {
		return dnid;
	}

	public void setDnid(int dnid) {
		this.dnid = dnid;
	}

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public String getDcoding() {
		return dcoding;
	}

	public void setDcoding(String dcoding) {
		this.dcoding = dcoding == null ? null : dcoding.trim();
	}

	public String getDshortname () {
		return dshortname;
	}

	public void setDshortname(String dshortname) {
		this.dshortname = dshortname == null ? null : dshortname.trim();
	}

	public String getDdate() {
		if (null != this.ddate) {
			if (this.ddate.contains(".")) {
				return ddate.substring(0, this.ddate.lastIndexOf("."));
			}
		}

		return ddate;
	}

	public void setDdate(String ddate) {
		this.ddate = ddate;
	}

	public String getDallname() {
		return dallname;
	}

	public void setDallname(String dallname) {
		this.dallname = dallname == null ? null : dallname.trim();
	}

	public String getDintro() {
		return dintro;
	}

	public void setDintro(String dintro) {
		this.dintro = dintro == null ? null : dintro.trim();
	}

	public String getDremark() {
		return dremark;
	}

	public void setDremark(String dremark) {
		this.dremark = dremark == null ? null : dremark.trim();
	}

	public Integer getCzid() {
		return czid;
	}

	public void setCzid(Integer czid) {
		this.czid = czid;
	}

	@Override
	public String toString() {
		return "Department [did=" + did + ", dcoding=" + dcoding + ", dshortname=" + dshortname + ", ddate=" + ddate
				+ ", czid=" + czid + ", dallname=" + dallname + ", dintro=" + dintro + ", dremark=" + dremark
				+ ", dnid=" + dnid + ", caoName=" + caoName + "]";
	}

}