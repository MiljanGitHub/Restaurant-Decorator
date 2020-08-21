package model;

public class Pasta extends Meal{
	
	public Pasta(int id, String description) {
		super(id);
		this.description = description;
		//System.out.println("id " + description + " je: " + id);
		main.Main.pastas.put(id, (Identifialble) this);
	}
	
	public double cost() {
		return (Math.random()*((600-300)+1))+300;
	}
	
}
