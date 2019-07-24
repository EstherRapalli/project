package com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class address {
	@Column(name="street",length=20,nullable=false)
private String street;
	@Column(name="city",length=20,nullable=false)
private String city;
	@Column(name="state",length=20,nullable=false)

private String state;
	@Column(name="country",length=20,nullable=false)

private String country;
	public address(String street, String city, String state, String country) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	public address() {
		super();
		// TODO Auto-generated constructor stub
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
	@Override
	public String toString() {
		return "address [street=" + street + ", city=" + city + ", state="
				+ state + ", country=" + country + "]";
	}
	

}
