package com.lxit.crm.entities;

/**
 * @author 作者 E-mail:506997606@qq.com
 * @version 创建时间 2017年11月18日 上午8:39:28 类说明:
 *
 */
public class Notice_type {

	private int type_id;
	private String type_text;

	public Notice_type(int type_id, String type_text) {
		super();
		this.type_id = type_id;
		this.type_text = type_text;
	}

	public Notice_type() {
		super();
	}

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	public String getType_text() {
		return type_text;
	}

	public void setType_text(String type_text) {
		this.type_text = type_text;
	}

	@Override
	public String toString() {
		return "Notice_type [type_id=" + type_id + ", type_text=" + type_text + "]";
	}

}
