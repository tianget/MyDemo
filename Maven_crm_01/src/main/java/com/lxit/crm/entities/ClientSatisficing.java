package com.lxit.crm.entities;

import java.util.Date;

public class ClientSatisficing {
    private int id;
    
    
    private String encode;       //客户编码
    
    private int mid;
    
    private String name;		//客户姓名

    private String sex;			//客户性别

    private String type;		//客户类型

    private String status;		//客户状态

    private Integer number;		//消费次数

    private String quality;	//质量满意度

    private String serve;		//服务满意度

    private String benefit;	//性价比满意度

    private String overall;	//总体满意度

    private String feedback;	//客户 反馈

    private String time;			//调查时间  格式 2013-11-29

    public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
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

    public String getEncode() {
		return encode;
	}

	public void setEncode(String encode) {
		this.encode = encode;
	}

	public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    

    public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public String getServe() {
		return serve;
	}

	public void setServe(String serve) {
		this.serve = serve;
	}

	public String getBenefit() {
		return benefit;
	}

	public void setBenefit(String benefit) {
		this.benefit = benefit;
	}

	public String getOverall() {
		return overall;
	}

	public void setOverall(String overall) {
		this.overall = overall;
	}

	public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback == null ? null : feedback.trim();
    }

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "ClientSatisficing [id=" + id + ", encode=" + encode + ", mid=" + mid + ", name=" + name + ", sex=" + sex
				+ ", type=" + type + ", status=" + status + ", number=" + number + ", quality=" + quality + ", serve="
				+ serve + ", benefit=" + benefit + ", overall=" + overall + ", feedback=" + feedback + ", time=" + time
				+ "]";
	}


	

	

	

    
}