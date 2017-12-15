package com.lxit.crm.entities;

/**
 * 订单商品表 id:订单商品id order_number:商品数量 order_money:商品金额 order:订单id goods:商品id
 * 
 * @author Administrator
 *
 */
public class OrderGoods {

	private int id;
	private int order_number;
	private String order_money;
	private Order order;
	private Goods goods;
	private int oid;

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	private int gid;

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	private int o_oid;
	private String o_otype;
	private int o_onum;
	private String g_gname;
	private String c_cname;
	private String o_otime;
	private String o_ostatus;

	private String o_opayment;
	private String c_email;
	private String c_address;
	private String c_familyPhone;
	private String c_workPhone;
	private String c_phone;
	private String o_oinvoice;

	public String getO_opayment() {
		return o_opayment;
	}

	public void setO_opayment(String o_opayment) {
		this.o_opayment = o_opayment;
	}

	public String getC_email() {
		return c_email;
	}

	public void setC_email(String c_email) {
		this.c_email = c_email;
	}

	public String getC_address() {
		return c_address;
	}

	public void setC_address(String c_address) {
		this.c_address = c_address;
	}

	public String getC_familyPhone() {
		return c_familyPhone;
	}

	public void setC_familyPhone(String c_familyPhone) {
		this.c_familyPhone = c_familyPhone;
	}

	public String getC_workPhone() {
		return c_workPhone;
	}

	public void setC_workPhone(String c_workPhone) {
		this.c_workPhone = c_workPhone;
	}

	public String getC_phone() {
		return c_phone;
	}

	public void setC_phone(String c_phone) {
		this.c_phone = c_phone;
	}

	public String getO_oinvoice() {
		return o_oinvoice;
	}

	public void setO_oinvoice(String o_oinvoice) {
		this.o_oinvoice = o_oinvoice;
	}

	private String g_gtype;
	private String xiao;

	public String getXiao() {
		return xiao;
	}

	public void setXiao(String xiao) {
		this.xiao = xiao;
	}

	public String getG_gtype() {
		return g_gtype;
	}

	public void setG_gtype(String g_gtype) {
		this.g_gtype = g_gtype;
	}

	public int getO_oid() {
		return o_oid;
	}

	public void setO_oid(int o_oid) {
		this.o_oid = o_oid;
	}

	public String getO_otype() {
		return o_otype;
	}

	public void setO_otype(String o_otype) {
		this.o_otype = o_otype;
	}

	public int getO_onum() {
		return o_onum;
	}

	public void setO_onum(int o_onum) {
		this.o_onum = o_onum;
	}

	public String getG_gname() {
		return g_gname;
	}

	public void setG_gname(String g_gname) {
		this.g_gname = g_gname;
	}

	public String getC_cname() {
		return c_cname;
	}

	public void setC_cname(String c_cname) {
		this.c_cname = c_cname;
	}

	public String getO_otime() {
		return o_otime;
	}

	public void setO_otime(String o_otime) {
		this.o_otime = o_otime;
	}

	public String getO_ostatus() {
		return o_ostatus;
	}

	public void setO_ostatus(String o_ostatus) {
		this.o_ostatus = o_ostatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {

		this.id = id;
	}

	public int getOrder_number() {
		return order_number;
	}

	public void setOrder_number(int order_number) {
		this.order_number = order_number;
	}

	public String getOrder_money() {
		return order_money;
	}

	public void setOrder_money(String order_money) {
		this.order_money = order_money;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	@Override
	public String toString() {
		return "OrderGoods [id=" + id + ", order_number=" + order_number + ", order_money=" + order_money + ", order="
				+ order + ", goods=" + goods + ", o_oid=" + o_oid + ", o_otype=" + o_otype + ", o_onum=" + o_onum
				+ ", g_gname=" + g_gname + ", c_cname=" + c_cname + ", o_otime=" + o_otime + ", o_ostatus=" + o_ostatus
				+ ", o_opayment=" + o_opayment + ", c_email=" + c_email + ", c_address=" + c_address
				+ ", c_familyPhone=" + c_familyPhone + ", c_workPhone=" + c_workPhone + ", c_phone=" + c_phone
				+ ", o_oinvoice=" + o_oinvoice + ", g_gtype=" + g_gtype + ", xiao=" + xiao + "]";
	}

}
