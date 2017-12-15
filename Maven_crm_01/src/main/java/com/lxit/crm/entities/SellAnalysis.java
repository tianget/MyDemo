package com.lxit.crm.entities;

/**
 * 
 * 销售分析类
 * @author Administrator
 *
 */
public class SellAnalysis {

	private String thisMonth; //当前月份
	private Double sumMoney; //这个月销售总额
	private Double lastMoney;//上个月销售总额
	private Double lastYearMoney;//去年这个 月的销售总额
	private String withThan;//同比
	private String loopThan;//环比
	private String deptName;//部门姓名
	private String empName; //员工
	
	
	
	
	public String getThisMonth() {
		return thisMonth;
	}
	public void setThisMonth(String thisMonth) {
		this.thisMonth = thisMonth;
	}
	public Double getSumMoney() {
		return sumMoney;
	}
	public void setSumMoney(Double sumMoney) {
		this.sumMoney = sumMoney;
	}
	public Double getLastMoney() {
		return lastMoney;
	}
	public void setLastMoney(Double lastMoney) {
		this.lastMoney = lastMoney;
	}
	public Double getLastYearMoney() {
		return lastYearMoney;
	}
	public void setLastYearMoney(Double lastYearMoney) {
		this.lastYearMoney = lastYearMoney;
	}
	public String getWithThan() {
		return withThan;
	}
	public void setWithThan(String withThan) {
		this.withThan = withThan;
	}
	public String getLoopThan() {
		return loopThan;
	}
	public void setLoopThan(String loopThan) {
		this.loopThan = loopThan;
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
