package model;


public class Drink extends Meal{
	
	private double volume; 
	
	public Drink(int id, String description, double volume) {
		super(id);
		this.description = description + " " + volume;
		main.Main.drinks.put(id,(Identifialble) this);
		
	}
	
	public double cost() {
		return (Math.random()*((500-150)+1))+150;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}
	
	

	
}
