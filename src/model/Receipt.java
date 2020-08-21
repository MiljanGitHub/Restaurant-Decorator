package model;

public class Receipt extends Identifialble{
	
	private String allItems;
	private double total;
	private int tableId;
	
	
	public Receipt(int id, String allItems, double total, int tableId) {
		super(id);
		this.allItems = allItems;
		this.total = total;
		this.tableId = tableId;
		main.Main.receipts.put(id, (Identifialble) this);
	}


	public String getAllItems() {
		return allItems;
	}


	public void setAllItems(String allItems) {
		this.allItems = allItems;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	public int getTableId() {
		return tableId;
	}


	public void setTableId(int tableId) {
		this.tableId = tableId;
	}
	
	
	
	
	
	
	
	
	

}
