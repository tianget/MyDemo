package com.lxit.crm.entities;

/**
 * 商品表
 * 
 * @author Administrator gid : 商品id gname : 商品名字 gtype : 商品类型 gprice: 商品价格
 *         gstock: 商品库存
 *
 */
public class Goods {

	private int gid;
	private String gname;
	private String gtype;
	private double gprice;
	private String gstock;
	private String peopleNum;

	public String getPeopleNum() {
		return peopleNum;
	}

	public void setPeopleNum(String peopleNum) {
		this.peopleNum = peopleNum;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		if (peopleNum == null) {
			peopleNum ="<input  name='min' id='min' type='button' onclick='minmin(this)' value='-' />"
					+"  "+ "<input type='text' id='goodsNumber" + gid
					+ "' style='width:20px' name='peopleNum' type='text' value='1' /> "
					+ "<input  name='add' id='add' type='button' onclick='add(this)' value='+' />";
		}
		this.gid = gid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getGtype() {
		return gtype;
	}

	public void setGtype(String gtype) {
		this.gtype = gtype;
	}

	public double getGprice() {
		return gprice;
	}

	public void setGprice(double gprice) {
		this.gprice = gprice;
	}

	public String getGstock() {
		return gstock;
	}

	public void setGstock(String gstock) {
		this.gstock = gstock;
	}

	@Override
	public String toString() {
		return "Goods [gid=" + gid + ", gname=" + gname + ", gtype=" + gtype + ", gprice=" + gprice + ", gstock="
				+ gstock + "]";
	}

}
