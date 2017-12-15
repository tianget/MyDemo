package com.lxit.crm.entities;

/**
 * @author 作者 E-mail:506997606@qq.com
 * @version 创建时间 2017年11月18日 下午4:20:55 类说明:
 *
 */
public class Data_dictionary {
	private int dataid;
	private String dataname;
	private String datacoding;
	private String datavalue;
	private String dataremark;
	private String datatime;
	private int sid;
	private String sname;

	public Data_dictionary() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Data_dictionary(int dataid, String dataname, String datacoding, String datavalue, String dataremark,
			String datatime, int sid, String sname) {
		super();
		this.dataid = dataid;
		this.dataname = dataname;
		this.datacoding = datacoding;
		this.datavalue = datavalue;
		this.dataremark = dataremark;
		this.datatime = datatime;
		this.sid = sid;
		this.sname = sname;
	}

	public int getDataid() {
		return dataid;
	}

	public void setDataid(int dataid) {
		this.dataid = dataid;
	}

	public String getDataname() {
		return dataname;
	}

	public void setDataname(String dataname) {
		this.dataname = dataname;
	}

	public String getDatacoding() {
		return datacoding;
	}

	public void setDatacoding(String datacoding) {
		this.datacoding = datacoding;
	}

	public String getDatavalue() {
		return datavalue;
	}

	public void setDatavalue(String datavalue) {
		this.datavalue = datavalue;
	}

	public String getDataremark() {
		return dataremark;
	}

	public void setDataremark(String dataremark) {
		this.dataremark = dataremark;
	}

	public String getDatatime() {
		if (this.datatime.contains(".")) {
			return datatime.substring(0, this.datatime.lastIndexOf("."));
		}
		return datatime;
	}

	public void setDatatime(String datatime) {
		this.datatime = datatime;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	@Override
	public String toString() {
		return "Data_dictionary [dataid=" + dataid + ", dataname=" + dataname + ", datacoding=" + datacoding
				+ ", datavalue=" + datavalue + ", dataremark=" + dataremark + ", datatime=" + datatime + ", sid=" + sid
				+ ", sname=" + sname + "]";
	}

}
