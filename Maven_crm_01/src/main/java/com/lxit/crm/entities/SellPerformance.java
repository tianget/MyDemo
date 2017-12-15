package com.lxit.crm.entities;


public class SellPerformance {
    private Integer id; //标识

    private int empId; //员工ID
    
    private String empName; //员工姓名
    
    private String deptName; //部门名

    private String grade;//绩效等级

    private String lastUpdateDate; //最后更新时间

    private Integer operationManId;//操作人ID
    
    private String  operationManName;//操作人姓名

    private String remark; //备注
    
    private Double sumMoney; //个人销售总额

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public Integer getOperationManId() {
		return operationManId;
	}

	public void setOperationManId(Integer operationManId) {
		this.operationManId = operationManId;
	}

	public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getOperationManName() {
		return operationManName;
	}

	public void setOperationManName(String operationManName) {
		this.operationManName = operationManName;
	}

	public Double getSumMoney() {
		return sumMoney;
	}

	public void setSumMoney(Double sumMoney) {
		this.sumMoney = sumMoney;
	}

	
    
	
	
    
}