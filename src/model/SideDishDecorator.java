package model;

public abstract class SideDishDecorator extends Meal{
	
	public SideDishDecorator(int id) {
		super(id);
	}
	
	public abstract String getDescription();
}
