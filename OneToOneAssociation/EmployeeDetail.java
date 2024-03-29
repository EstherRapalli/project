package com.hibernate.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="hib_empdetail")
public class EmployeeDetail {
	
	

	@Id
	@Column(name="eid", unique=true, nullable=false)	
	private Long employeeId;
	
	@Column(name="street",length=20)
	private String street;

	@Column(name="city",length=20)
	private String city;

	@Column(name="state",length=20)
	private String state;

	@Column(name="country",length=20)
	private String country;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Employee employee;

	public EmployeeDetail() {

	}

	public EmployeeDetail(long eid,String street, String city, String state, String country) {
		this.employeeId=eid;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	@Override
	public String toString() {
		return "EmployeeDetail [employeeId=" + employeeId + ", street="
				+ street + ", city=" + city + ", state=" + state + ", country="
				+ country + "]";
	}
	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	
	

}
