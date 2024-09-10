package com.prospecta.Entity;

public class Rating {

	
	private double rate;
    private int count;
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Rating(double rate, int count) {
		super();
		this.rate = rate;
		this.count = count;
	}
	public Rating() {
		super();
	}
    
    
}