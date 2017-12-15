package com.lxit.crm.entities;

/**
 * 联系人
 * @author dahao
 *
 */
public class Linkman {
    private Integer id; //标识

    private String name; //联系人姓名

    private String sex; //性别

    private String birthday; //生日

    private String phone;  //电话

    private String workPhone; //工作电话

    private String email; //电子邮箱

    private String address;//详细地址

    private String remark;//备注
    
    private int enteringManId; //录入人Id
    
    private String enteringDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
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

    public String getWorkPhone() {
		return workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	


    public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

   

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	public int getEnteringManId() {
		return enteringManId;
	}

	public void setEnteringManId(int enteringManId) {
		this.enteringManId = enteringManId;
	}
	

	public String getEnteringDate() {
		return enteringDate;
	}

	public void setEnteringDate(String enteringDate) {
		this.enteringDate = enteringDate;
	}

	@Override
	public String toString() {
		return "Linkman [id=" + id + ", name=" + name + ", sex=" + sex + ", birthday=" + birthday + ", phone=" + phone
				+ ", workPhone=" + workPhone + ", email=" + email + ", address=" + address + ", remark=" + remark
				+ ", enteringManId=" + enteringManId + "]";
	}
    
	
	
}