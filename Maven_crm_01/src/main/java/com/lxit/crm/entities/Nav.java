package com.lxit.crm.entities;

public class Nav {

	private int id;
	private int nid;
	private String text;
	private String state;
	private String url;
	private String iconCls;

	public Nav() {
	}
	
	
	public Nav(int id, int nid, String text, String state, String url, String iconCls) {
		this.id = id;
		this.nid = nid;
		this.text = text;
		this.state = state;
		this.url = url;
		this.iconCls = iconCls;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	
	@Override
	public String toString() {
		return "Nav [id=" + id + ", nid=" + nid + ", text=" + text + ", state=" + state + ", url=" + url + ", iconCls="
				+ iconCls + ", getId()=" + getId() + ", getNid()=" + getNid() + ", getText()=" + getText()
				+ ", getState()=" + getState() + ", getUrl()=" + getUrl() + ", getIconCls()=" + getIconCls()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}
