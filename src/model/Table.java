package model;

import java.util.HashSet;
import java.util.Optional;

public class Table extends Identifialble{
	
	private HashSet<Order> orders = new HashSet<Order>();
	
	public Table(int id) {
		// TODO Auto-generated constructor stub
		super(id);
	}

	public HashSet<Order> getOrders() {
		return orders;
	}

	public void setOrders(HashSet<Order> orders) {
		this.orders = orders;
	}
	
	public void addOrder(Order o) {
		this.orders.add(o);
	}
	
	

	public void makeAnOrder(Order o)  {
		if (orders.size() == 0) {
			addOrder(o);
			return;
		}
		Optional<Order> unpaidOrder = orders.stream().filter(ord -> ord.isPaid() == false).findFirst();
		try {
			
			if (unpaidOrder.isPresent()) {
				
				throw new Exception("This table " + id + " has unpaid orders");
			} else {
				addOrder(o);
			}

		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	
	
	
	

}
