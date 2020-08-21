package model;

public abstract class Meal extends Identifialble{

	protected String description;
	protected double cost;
	
	
	public Meal(int id) {
		super(id);
		
		
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public abstract double cost();
	
	
	
	
	
	
	
	
	
	
	
}	
