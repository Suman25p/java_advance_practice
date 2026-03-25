package com.kodewala.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Payment {

	@Value("Suman")
	private String name;
	@Value("Gpay")
	private String paymentMode;
	@Value("5000")
	private int amount;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public void printInfo()
	{
		System.out.println("Payment Details: " + "Name " + name + ", PaymentMode " + paymentMode + ", Amount " + amount );
	}
}
