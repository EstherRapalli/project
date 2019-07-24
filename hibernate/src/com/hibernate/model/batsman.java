package com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="pbats")
public class batsman extends player{
@Column(name="runs")
private int numruns;

public batsman(int numruns) {
	super();
	this.numruns = numruns;
}

public batsman() {
	super();
	// TODO Auto-generated constructor stub
}

public int getNumruns() {
	return numruns;
}

public void setNumruns(int numruns) {
	this.numruns = numruns;
}

@Override
public String toString() {
	return "batsman [numruns=" + numruns + "]";
}


}
