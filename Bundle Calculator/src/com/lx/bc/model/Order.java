/**
 *  @ClassName Order
 *  @Description Define Order entity.
 *  @author Liu Xia
 *  @Date 2019/10/27
 *  @Version 1.0
 */
package com.lx.bc.model;

public class Order {
	
	private int amount;
	
	private String formateCode;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getFormateCode() {
		return formateCode;
	}

	public void setFormateCode(String formateCode) {
		this.formateCode = formateCode;
	}
	
	public Order() {
		
	}
	
	public Order(int amount, String formateCode) {
		this.amount = amount;
		this.formateCode = formateCode;
//		System.out.println("amount: " + amount);
//		System.out.println("formateCode: " + formateCode);
	}

}
