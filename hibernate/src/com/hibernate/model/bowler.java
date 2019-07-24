package com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="tbow")
public class bowler extends player{
	@Column(name="wickets")
private int numwickets;

	public bowler(int numwickets) {
		super();
		this.numwickets = numwickets;
	}

	public bowler() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getNumwickets() {
		return numwickets;
	}

	public void setNumwickets(int numwickets) {
		this.numwickets = numwickets;
	}

	@Override
	public String toString() {
		return "bowler [numwickets=" + numwickets + "]";
	}

}
