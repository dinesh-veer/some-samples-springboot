package com.spring.demo.controller;

public class LimitConfiguration {

	private int min;
	private int max;
	
	public LimitConfiguration(int min, int max) {
	
		this.min=min;
		this.max=max;
		
	}

	/**
	 * @return the min
	 */
	public int getMin() {
		return min;
	}

	/**
	 * @return the max
	 */
	public int getMax() {
		return max;
	}

	/**
	 * @param min the min to set
	 */
	public void setMin(int min) {
		this.min = min;
	}

	/**
	 * @param max the max to set
	 */
	public void setMax(int max) {
		this.max = max;
	}
	
	

}
