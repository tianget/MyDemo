package com.lxit.crm.entities;


public class SellForecast {
    private Integer id;  //标识

    private String subject; //预测标题

    private String month; //预测月份

    private String type; //预测类型

    private String generateDate; //生成时间
    
    private int did;//目标预测部门
    
    private String deptName; //目标预测部门名称
    
    private String empName;//目标预测员工名称
    
    private int empId;//目标预测员工
    
    private int sid;//预测人

    private Integer operationManId; //操作人Id
    
    private String operationManName; //操作人姓名

    private String forecastResult; //预测结果

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month == null ? null : month.trim();
    }

   

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGenerateDate() {
		return generateDate;
	}

	public void setGenerateDate(String generateDate) {
		this.generateDate = generateDate;
	}

	public Integer getOperationManId() {
		return operationManId;
	}

	public void setOperationManId(Integer operationManId) {
		this.operationManId = operationManId;
	}

	public String getForecastResult() {
		return forecastResult;
	}

	public void setForecastResult(String forecastResult) {
		this.forecastResult = forecastResult;
	}

	public String getOperationManName() {
		return operationManName;
	}

	public void setOperationManName(String operationManName) {
		this.operationManName = operationManName;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
    
	
    
}