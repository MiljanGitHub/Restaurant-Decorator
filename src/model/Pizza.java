package model;

public class Pizza extends Meal{

	public Pizza(int id, String description) {
		super(id);
		this.description = description;
		main.Main.pizzas.put(id, (Identifialble) this);
	}
	
	public double cost() {
		return (Math.random()*((600-300)+1))+300;
	}
	
}
