package com.lxit.crm.entities;

import java.util.Date;
/**
 * 销售机会
 * @author dahao
 *
 */
public class SellChance {
    private Integer id; //ID

    private String chanceName; //机会名称

    private String chanceType;//类型

    private String chanceOrigin; //机会来源

    private String chanceContent;//机会内容 

    private String enteringDate; //录入时间

    private Integer enteringManId;//录入人ID
    
    private String enteringManName;//录入人姓名

    private Integer lastUpdateManId;//最后更新人ID
    
    private String lastUpdateManName; //最后更新人姓名

    private String lastUpdateDate; //最后更新时间
    
    private int sid;  //负责跟进的销售代表
    
    private int state; //机会状态   0表示未分配  1表示已分配
    
    private String remark; //备注信息
    

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getChanceName() {
		return chanceName;
	}
	

	public String getEnteringManName() {
		return enteringManName;
	}

	public void setEnteringManName(String enteringManName) {
		this.enteringManName = enteringManName;
	}

	public void setChanceName(String chanceName) {
		this.chanceName = chanceName;
	}

	public String getChanceType() {
		return chanceType;
	}

	public void setChanceType(String chanceType) {
		this.chanceType = chanceType;
	}

	public String getChanceOrigin() {
		return chanceOrigin;
	}

	public void setChanceOrigin(String chanceOrigin) {
		this.chanceOrigin = chanceOrigin;
	}

	public String getChanceContent() {
		return chanceContent;
	}

	public void setChanceContent(String chanceContent) {
		this.chanceContent = chanceContent;
	}

	public String getEnteringDate() {
		return enteringDate;
	}

	public void setEnteringDate(String enteringDate) {
		this.enteringDate = enteringDate;
	}

	public Integer getEnteringManId() {
		return enteringManId;
	}

	public void setEnteringManId(Integer enteringManId) {
		this.enteringManId = enteringManId;
	}

	public Integer getLastUpdateManId() {
		return lastUpdateManId;
	}

	public void setLastUpdateManId(Integer lastUpdateManId) {
		this.lastUpdateManId = lastUpdateManId;
	}

	public String getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getLastUpdateManName() {
		return lastUpdateManName;
	}

	public void setLastUpdateManName(String lastUpdateManName) {
		this.lastUpdateManName = lastUpdateManName;
	}

	
	

	

   
    
}