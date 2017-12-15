package com.lxit.crm.entities;

/**
 * @author 作者 E-mail:506997606@qq.com
 * @version 创建时间 2017年11月18日 上午11:45:01 类说明:
 *
 */
public class Base {
	private int baseid;
	private String basecoding;
	private String basevalue;
	private String basedesc;
	private String baseremark;
	private int sid;
	private String tname;
	private String basetime;

	public Base() {
		super();
	}

	public Base(int baseid, String basecoding, String basevalue, String basedesc, String baseremark, int sid,
			String tname, String basetime) {
		super();
		this.baseid = baseid;
		this.basecoding = basecoding;
		this.basevalue = basevalue;
		this.basedesc = basedesc;
		this.baseremark = baseremark;
		this.sid = sid;
		this.tname = tname;
		this.basetime = basetime;
	}

	public int getBaseid() {
		return baseid;
	}

	public void setBaseid(int baseid) {
		this.baseid = baseid;
	}

	public String getBasecoding() {
		return basecoding;
	}

	public void setBasecoding(String basecoding) {
		this.basecoding = basecoding;
	}

	public String getBasevalue() {
		return basevalue;
	}

	public void setBasevalue(String basevalue) {
		this.basevalue = basevalue;
	}

	public String getBasedesc() {
		return basedesc;
	}

	public void setBasedesc(String basedesc) {
		this.basedesc = basedesc;
	}

	public String getBaseremark() {
		return baseremark;
	}

	public void setBaseremark(String baseremark) {
		this.baseremark = baseremark;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getBasetime() {
		if(this.basetime.contains(".")&&this.basetime!=null){
    		return basetime.substring(0,this.basetime.lastIndexOf("."));
    	}
        return basetime;
	}

	public void setBasetime(String basetime) {
		this.basetime = basetime;
	}

	@Override
	public String toString() {
		return "Base [baseid=" + baseid + ", basecoding=" + basecoding + ", basevalue=" + basevalue + ", basedesc="
				+ basedesc + ", baseremark=" + baseremark + ", sid=" + sid + ", tname=" + tname + ", basetime="
				+ basetime + "]";
	}

}
