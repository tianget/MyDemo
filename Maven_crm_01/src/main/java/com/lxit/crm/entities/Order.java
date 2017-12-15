package com.lxit.crm.entities;

import java.io.Serializable;

/**
 * 订单表
 * 
 * @author Administrator oid:订单id otype:订单类型 ounm:订单编号 oprice:交易金额 opayment:支付方式
 *         otime:下单时间 oinvoice:发票类型 ostatus:̬订单状态 gid:商品id userid:员工id
 */
public class Order implements Serializable{

	private Integer oid;
	private String otype;
	private Integer onum;
	private String oprice;

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	private int count;
	private String tim;
	private String sumr;
	private String bas;
	private String finish;

	public String getFinish() {
		return finish;
	}

	public void setFinish(String finish) {
		this.finish = finish;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	private String opayment;
	private String otime;
	private String oinvoice;
	private String ostatus;

	private Integer gid;
	private Integer userid;

	private Client_member member;
	private String userName;
	private String gname;

	private String m_phone;
	private String m_address;

	public String getM_phone() {
		return m_phone;
	}

	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}

	public String getM_address() {
		return m_address;
	}

	public void setM_address(String m_address) {
		this.m_address = m_address;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getOtype() {
		return otype;
	}

	public void setOtype(String otype) {
		this.otype = otype == null ? null : otype.trim();
	}

	public Integer getOnum() {
		return onum;
	}

	public void setOnum(Integer onum) {
		this.onum = onum;
	}

	public String getOprice() {
		return oprice;
	}

	public void setOprice(String oprice) {
		this.oprice = oprice;
	}

	public String getOpayment() {
		return opayment;
	}

	public void setOpayment(String opayment) {
		this.opayment = opayment == null ? null : opayment.trim();
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
		this.oinvoice = oinvoice == null ? null : oinvoice.trim();
	}

	public String getOstatus() {
		return ostatus;
	}

	public void setOstatus(String ostatus) {
		this.ostatus = ostatus == null ? null : ostatus.trim();
	}

	public Client_member getMember() {
		return member;
	}

	public void setMember(Client_member member) {
		this.member = member;
	}

	private String num;
	private String sum;

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

	private String sname;

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	private int m_id;
	private String m_sex;
	private String m_type;
	private String m_status;

	public int getM_id() {
		return m_id;
	}

	public void setM_id(int m_id) {
		this.m_id = m_id;
	}

	public String getM_sex() {
		return m_sex;
	}

	public void setM_sex(String m_sex) {
		this.m_sex = m_sex;
	}

	public String getM_type() {
		return m_type;
	}

	public void setM_type(String m_type) {
		this.m_type = m_type;
	}

	public String getM_status() {
		return m_status;
	}

	public void setM_status(String m_status) {
		this.m_status = m_status;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getTim() {
		return tim;
	}

	public void setTim(String tim) {
		this.tim = tim;
	}

	public String getSumr() {
		return sumr;
	}

	public void setSumr(String sumr) {
		this.sumr = sumr;
	}

	public String getBas() {
		return bas;
	}

	public void setBas(String bas) {
		this.bas = bas;
	}

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", otype=" + otype + ", onum=" + onum + ", oprice=" + oprice + ", opayment="
				+ opayment + ", otime=" + otime + ", oinvoice=" + oinvoice + ", ostatus=" + ostatus + ", member="
				+ member + ", userName=" + userName + ", gname=" + gname + ", num=" + num + ", sum=" + sum + ", sname="
				+ sname + ", m_id=" + m_id + ", m_sex=" + m_sex + ", m_type=" + m_type + ", m_status=" + m_status + "]";
	}

}