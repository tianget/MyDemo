package com.lxit.crm.entities;

public class Client_grade {
	private int id;       
    private String name;    //客户姓名
    private String sex;		//客户性别
    private String type;	//客户类型
    private int number;		//已消费次数
    private String grade;	//信誉等级
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
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Client_grade [id=" + id + ", name=" + name + ", sex=" + sex + ", type=" + type + ", number=" + number
				+ ", grade=" + grade + "]";
	}
    
}
