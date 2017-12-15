package com.lxit.crm.entities;

import java.util.Date;

public class ClientPlan {
    private int id;

    private String encode;      //计划编码

    private String name; 		//姓名

    private String month;		//月份

    private String initdate;		//创建时间

    private String finishdate;	//结束时间

    private String type;		//计划状态

    private String details;		//计划内容

    private int s_id;	//操作人   登录的用户
    
    private String s_name;

    public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month == null ? null : month.trim();
    }

    

	public String getInitdate() {
		return initdate;
	}

	public void setInitdate(String initdate) {
		this.initdate = initdate;
	}

	public String getFinishdate() {
		return finishdate;
	}

	public void setFinishdate(String finishdate) {
		this.finishdate = finishdate;
	}

	

	

	

	

	@Override
	public String toString() {
		return "ClientPlan [id=" + id + ", encode=" + encode + ", name=" + name + ", month=" + month + ", initdate="
				+ initdate + ", finishdate=" + finishdate + ", type=" + type + ", details=" + details + ", s_id=" + s_id
				+ ", s_name=" + s_name + "]";
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public String getEncode() {
		return encode;
	}

	public void setEncode(String encode) {
		this.encode = encode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	

	

  

   
}