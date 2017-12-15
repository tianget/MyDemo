package com.lxit.crm.entities;

import java.util.Date;

/**
 * 常见问题管理
 * 
 * @author LY
 *
 */
public class Question {
    private Integer qid; //标识列

    private String qtitle; //问题标题（新建后不可更改）

    private String qtype; //问题类型

    private String replyPoint; //答复要点

    private String qremark; //备注信息

    private String qcreater; //创建人（外键）
    
    private Staff staff;

    private String qcreateTime; //创建时间

    private String qlastTime; //最后操作时间

    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
    }

    public String getQtitle() {
        return qtitle;
    }

    public void setQtitle(String qtitle) {
        this.qtitle = qtitle == null ? null : qtitle.trim();
    }

    public String getQtype() {
        return qtype;
    }

    public void setQtype(String qtype) {
        this.qtype = qtype == null ? null : qtype.trim();
    }

    public String getReplyPoint() {
        return replyPoint;
    }

    public void setReplyPoint(String replyPoint) {
        this.replyPoint = replyPoint == null ? null : replyPoint.trim();
    }

    public String getQremark() {
        return qremark;
    }

    public void setQremark(String qremark) {
        this.qremark = qremark == null ? null : qremark.trim();
    }

    public String getQcreater() {
        return qcreater;
    }

    public void setQcreater(String qcreater) {
        this.qcreater = qcreater;
    }

    public String getQcreateTime() {
    	if(this.qcreateTime.contains(".")){
    		return qcreateTime.substring(0,this.qcreateTime.lastIndexOf("."));
    	}
        return qcreateTime;
    }

    public void setQcreatetime(String qcreateTime) {
        this.qcreateTime = qcreateTime;
    }

    public String getQlastTime() {
    	if(this.qlastTime.contains(".")){
    		return qlastTime.substring(0,this.qlastTime.lastIndexOf("."));
    	}
        return qlastTime;
    }

    public void setQlasttime(String qlastTime) {
        this.qlastTime = qlastTime;
    }
    
	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	@Override
	public String toString() {
		return "Question [qid=" + qid + ", qtitle=" + qtitle + ", qtype=" + qtype + ", replyPoint=" + replyPoint
				+ ", qremark=" + qremark + ", qcreater=" + qcreater + ", staff=" + staff + ", qcreateTime="
				+ qcreateTime + ", qlastTime=" + qlastTime + "]";
	}

}