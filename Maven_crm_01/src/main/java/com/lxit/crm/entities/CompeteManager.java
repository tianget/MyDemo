package com.lxit.crm.entities;

/**
 * 
 * 竞争管理
 * @author dahao
 *
 */
public class CompeteManager {
    
	private Integer id;//标识

    private String subject;//竞争标题

    private String type;//类型

    private String generateDate; //分析结果生成时间

    private Integer operationManId;//操作人
    
    private String operationManName;//操作人姓名

    private String analysisDate; //分析时间

    private String outData; //倒入的数据

    private String analysisResult;//分析结果 
    
    private String state;

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

	public String getAnalysisDate() {
		return analysisDate;
	}

	public void setAnalysisDate(String analysisDate) {
		this.analysisDate = analysisDate;
	}

	public String getOutData() {
		return outData;
	}

	public void setOutData(String outData) {
		this.outData = outData;
	}

	public String getAnalysisResult() {
		return analysisResult;
	}

	public void setAnalysisResult(String analysisResult) {
		this.analysisResult = analysisResult;
	}

	public String getOperationManName() {
		return operationManName;
	}

	public void setOperationManName(String operationManName) {
		this.operationManName = operationManName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
  
	
	
  
}