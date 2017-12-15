package com.lxit.crm.entities;

import java.util.Date;

public class Notice {
    private Integer noticeId;

    private String noticeCoding;

    private Integer noticeType;

    private String noticeTitle;

    private String noticeTime;

    private String noticeContent;

    private Integer sid;
    
    private String name;
    
    private String departmentName;
    
    private String noticeTypeText;
    
    
    

   

	public String getNoticeTypeText() {
		return noticeTypeText;
	}

	public void setNoticeTypeText(String noticeTypeText) {
		this.noticeTypeText = noticeTypeText;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeCoding() {
        return noticeCoding;
    }

    public void setNoticeCoding(String noticeCoding) {
        this.noticeCoding = noticeCoding == null ? null : noticeCoding.trim();
    }

    public Integer getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(Integer noticeType) {
        this.noticeType = noticeType;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle == null ? null : noticeTitle.trim();
    }

    public String getNoticeTime() {
    	if(this.noticeTime.contains(".")&&this.noticeTime!=null){
    		return noticeTime.substring(0,this.noticeTime.lastIndexOf("."));
    	}
        return noticeTime;
    }

    public void setNoticeTime(String noticeTime) {
        this.noticeTime = noticeTime;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent == null ? null : noticeContent.trim();
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }
    
    @Override
	public String toString() {
		return "Notice [noticeId=" + noticeId + ", noticeCoding=" + noticeCoding + ", noticeType=" + noticeType
				+ ", noticeTitle=" + noticeTitle + ", noticeTime=" + noticeTime + ", noticeContent=" + noticeContent
				+ ", sid=" + sid + ", name=" + name + ", departmentName=" + departmentName + ", noticeTypeText="
				+ noticeTypeText + "]";
	}
}