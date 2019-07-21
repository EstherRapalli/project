package com.springmvc.model;

public class CityInfo {
	private String cityname;
	private String state;
	private String information;
	public CityInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CityInfo(String cityname, String state, String information) {
		super();
		this.cityname = cityname;
		this.state = state;
		this.information = information;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	@Override
	public String toString() {
		return "CityInfo [cityname=" + cityname + ", state=" + state
				+ ", information=" + information + "]";
	}
	
	
	

}
