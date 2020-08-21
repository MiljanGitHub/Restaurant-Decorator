package model;


public abstract class Identifialble  {
	protected int id;
	
	

	public Identifialble(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Identifialble) {
			return ((Identifialble)obj).id == this.id;
		} return false;
	
	}
	

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.id;
	}
	
	
}
