package model;

import java.util.HashSet;
import java.util.stream.Collectors;

public class Order extends Identifialble{
	
	private HashSet<Meal> meals;
	private Receipt receipt;
	private boolean paid;
	
	
	
	public Order(int id) {
		super(id);
		main.Main.orders.put(id, this);
	}
	
	public Order(int id, HashSet<Meal> meals) {
		super(id);
		this.meals = meals;
		this.paid = false;
	}

	public HashSet<Meal> getMeals() {
		return meals;
	}

	public void setMeals(HashSet<Meal> meals) {
		this.meals = meals;
	}


	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	
	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public void payReceipt(Receipt receipt) {
		setPaid(true);
		setReceipt(receipt);
		
	}
	
	public String getFullDescription() {
		return meals.stream().map( meal -> meal.getDescription() )
		        .collect( Collectors.joining(" "));
	}
	
	public double getFullCost() {
		return meals.stream().mapToDouble( meal -> meal.cost() )
		        .sum();
	}
	
	
	
	
	
	
	
	

}
