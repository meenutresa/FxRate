package com.selfproject.fxratesapp.fxratesfetchservice.model;

import java.io.Serializable;

public class FxRate implements Serializable{
	
	private double rate;
	private double timestamp;
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public double getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(double timestamp) {
		this.timestamp = timestamp;
	}
	public FxRate(double rate, double timestamp) {
		super();
		this.rate = rate;
		this.timestamp = timestamp;
	}
	

}
