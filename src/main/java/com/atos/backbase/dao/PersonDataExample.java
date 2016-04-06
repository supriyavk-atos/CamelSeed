package com.atos.backbase.dao;

public class PersonDataExample {

	private int id;
	private String name;
	private double amount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "PersonData [id=" + id + ", name=" + name + ", amount=" + amount
				+ "]";
	}
	
	
}
