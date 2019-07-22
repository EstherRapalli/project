package com.hibernate.model;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="hib_emp")
public class Employee {

	@Id	
	@Column(name="eid")
	private Long employeeId;
	
	@Column(name="fname",length=15)
	private String firstname;
	
	@Column(name="lname",length=15)
	private String lastname;
	
	@Column(name="bdate")
	private Date birthDate;
	
	@Column(name="cellphone",length=20)
	private String cellphone;

	@OneToOne(mappedBy="employee", cascade=CascadeType.ALL)
	private EmployeeDetail employeeDetail;
	
	public Employee() {
		
	}
	
	public Employee(long eid,String firstname, String lastname, Date birthdate, String phone) {
		this.employeeId= eid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthDate = birthdate;
		this.cellphone = phone;
		
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstname="
				+ firstname + ", lastname=" + lastname + ", birthDate="
				+ birthDate + ", cellphone=" + cellphone + ", employeeDetail="
				+ employeeDetail + "]";
	}
	
	
	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public EmployeeDetail getEmployeeDetail() {
		return employeeDetail;
	}

	public void setEmployeeDetail(EmployeeDetail employeeDetail) {
		this.employeeDetail = employeeDetail;
	}




}
