package model;

public class SideDish extends SideDishDecorator{
	
	private Meal meal;
	
	
	public SideDish(int id, Meal meal, String description) {
		super(id);
		this.meal = meal;
		this.description = description;
		main.Main.sideDishes.put(id,(Identifialble) this);
	}
	
	public String getDescription() {
		return meal.getDescription() + " " + description;
	}
	
	public double cost() {
		return meal.cost() + (Math.random()*((100-20)+1))+20;
	}
	
}
