package com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="hib_player_in1")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="player",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue(value="play")


public class player {
	
@Id
@Column(name="playid")
private int playerid;

@Column(name="playname" ,length=20)
private String playername;



@Column(name="playmatches")
private int nummatches;
@Embedded
address resaddr;
public player(int playerid, String playername, int nummatches, address resaddr) {
	super();
	this.playerid = playerid;
	this.playername = playername;
	this.nummatches = nummatches;
	this.resaddr = resaddr;
}
public player() {
	super();
	// TODO Auto-generated constructor stub
}
public int getPlayerid() {
	return playerid;
}
public void setPlayerid(int playerid) {
	this.playerid = playerid;
}
public String getPlayername() {
	return playername;
}
public void setPlayername(String playername) {
	this.playername = playername;
}
public int getNummatches() {
	return nummatches;
}
public void setNummatches(int nummatches) {
	this.nummatches = nummatches;
}
public address getResaddr() {
	return resaddr;
}
public void setResaddr(address resaddr) {
	this.resaddr = resaddr;
}
@Override
public String toString() {
	return "player [playerid=" + playerid + ", playername=" + playername
			+ ", nummatches=" + nummatches + ", resaddr=" + resaddr + "]";
}

}
