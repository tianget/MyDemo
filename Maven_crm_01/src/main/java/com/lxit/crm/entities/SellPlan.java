package com.lxit.crm.entities;


public class SellPlan {
    private Integer planId;//标识

    private String coding; //编码
    
    private String planName; //计划人姓名
    
    private int planManId;//计划人id

    private String planContent;//计划内容

    private String planMonth;//计划月份

    private String state;//状态

    private String lastOperationDate; //最后操作时间

    private int operationManId;//操作人
    
    private String operationName; //操作人姓名

    private int handlerManId;//待处理人
    
    private String handlerName; //处理人姓名

    private String  planSaleroom;//计划销售额
    
    

    
    
	

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public Integer getPlanId() {
		return planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	public String getCoding() {
		return coding;
	}

	public void setCoding(String coding) {
		this.coding = coding;
	}

	

	public String getPlanContent() {
		return planContent;
	}

	public void setPlanContent(String planContent) {
		this.planContent = planContent;
	}

	public String getPlanMonth() {
		return planMonth;
	}

	public void setPlanMonth(String planMonth) {
		this.planMonth = planMonth;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLastOperationDate() {
		return lastOperationDate;
	}

	public void setLastOperationDate(String lastOperationDate) {
		this.lastOperationDate = lastOperationDate;
	}

	 

	

	

	public int getOperationManId() {
		return operationManId;
	}

	public void setOperationManId(int operationManId) {
		this.operationManId = operationManId;
	}

	public int getHandlerManId() {
		return handlerManId;
	}

	public void setHandlerManId(int handlerManId) {
		this.handlerManId = handlerManId;
	}

	public String getPlanSaleroom() {
		return planSaleroom;
	}

	public void setPlanSaleroom(String planSaleroom) {
		this.planSaleroom = planSaleroom;
	}
	

	
	
	

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	public String getHandlerName() {
		return handlerName;
	}

	public void setHandlerName(String handlerName) {
		this.handlerName = handlerName;
	}

	
	public int getPlanManId() {
		return planManId;
	}

	public void setPlanManId(int planManId) {
		this.planManId = planManId;
	}

	@Override
	public String toString() {
		return "SellPlan [planId=" + planId + ", coding=" + coding + ", planContent=" + planContent + ", planMonth="
				+ planMonth + ", state=" + state + ", lastOperationDate=" + lastOperationDate + ", operationMan="
				+ operationManId + ", operationName=" + operationName + ", handlerMan=" + handlerManId + ", handlerName="
				+ handlerName + ", planSaleroom=" + planSaleroom + "]";
	}

	

	

	
    
    
    
}