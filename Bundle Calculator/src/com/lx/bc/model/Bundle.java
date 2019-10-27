/**
 *  @ClassName Bundle
 *  @Description Define Bundle entity.
 *  @author Liu Xia
 *  @Date 2019/10/27
 *  @Version 1.0
 */

package com.lx.bc.model;

public class Bundle implements Comparable<Bundle>{
	
	private int amount;
	
	private double price;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Bundle() {

	}
	
	public Bundle(int amount, double price) {
		this.amount = amount;
		this.price = price;
	}

	@Override
	public int compareTo(Bundle target) {
		if(this.amount>target.amount) {
			return 1;
		}else if(this.amount<target.amount) {
			return -1;
		}else {
			return 0;
		}
	}


	
	
}
