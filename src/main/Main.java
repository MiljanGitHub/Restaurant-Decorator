package main;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import interfaces.CalculateKey;
import model.Drink;
import model.Identifialble;
import model.Meal;
import model.Order;
import model.Pasta;
import model.Pizza;
import model.Receipt;
import model.Restaurant;
import model.SideDish;
import model.Table;;

public class Main {
	

		static Logger logger = Logger.getLogger(Main.class); 
		
		
		public static HashMap<Integer, Identifialble> restaurnats = new HashMap<Integer, Identifialble>();
		public static HashMap<Integer, Identifialble> tables = new HashMap<Integer, Identifialble>();
		public static HashMap<Integer, Identifialble> orders = new HashMap<Integer, Identifialble>();
		public static HashMap<Integer, Identifialble> pastas = new HashMap<Integer, Identifialble>();
		public static HashMap<Integer, Identifialble> pizzas = new HashMap<Integer, Identifialble>();
		public static HashMap<Integer, Identifialble> drinks = new HashMap<Integer, Identifialble>();
		public static HashMap<Integer, Identifialble> sideDishes = new HashMap<Integer, Identifialble>();
		public static HashMap<Integer, Identifialble> receipts = new HashMap<Integer, Identifialble>();
		
		static Restaurant vivifyRestaurnt = Restaurant.getInstance(1, 4);
		
		static final CalculateKey<HashMap<Integer, Identifialble>> caluclate = (mapaa) -> {
			
			return mapaa.entrySet().stream()
					.max((entry1, entry2) -> entry1.getKey() > entry2.getKey() ? 1 : -1)
					.get().getKey() + 1;
		};
		
	
	public static void main(String[] args) throws FileNotFoundException, IOException  {
		
		Properties props = new Properties();
        props.load(new BufferedInputStream(
        				new FileInputStream(
        					new File("src" +  System.getProperty("file.separator") + "log4j.properties"))));
        PropertyConfigurator.configure(props);
        
		createOrderForTables();
		
		
		
	
		//naplati prvu i trecu;
		orders.entrySet().forEach(e -> {
			if (e.getKey() == 1 || e.getKey() == 3){
				Order o = (Order) orders.get(e.getKey());
				o.payReceipt(generateReceipt(o, e.getKey()));
			}
		});
		
		//make an order for table 2 (even though previous Order for table 2 is not paid) should get Exception
		Table table2 = (Table) tables.get(2);
		Meal pizzaCapricciosa = new Pizza(generateId2(pizzas), "Pizza capricciosa");
		
		HashSet<Meal> mealsForOrder = new HashSet<Meal>();
		mealsForOrder.add(pizzaCapricciosa); 
		Order orderForTable2 = new Order(generateId2(orders));
		orderForTable2.setMeals(mealsForOrder);
		table2.makeAnOrder(orderForTable2);
		

		
	
		//charge unpaid Order for table number 2
		
		Order o2 = (Order) orders.get(2); //ona koja je neplacena za sto br 2
		o2.setPaid(true);
		Receipt r1 = generateReceipt(o2, 2);
		o2.setReceipt(r1);
		//Receipt r = new Receipt(generateId2(receipts), o2.getFullDescription(), o2.getFullCost(), 2);
		//o2.setReceipt(r);

		

		
		
		
		//make a new order for table 2, now it should go through with no Exception
		Table table2Again = (Table) tables.get(2);
		Meal pizzaCapricciosa2 = new Pizza(generateId2(pizzas), "Pizza capricciosa");
		
		HashSet<Meal> mealsForOrderAgain = new HashSet<Meal>();
		mealsForOrderAgain.add(pizzaCapricciosa2); 
		Order orderForTable2Again = new Order(generateId2(orders));
		table2Again.makeAnOrder(orderForTable2Again);
		
		
		



		

		
	}
	
	
	
	
	private static void createOrderForTables() {
		//table 1
		
		Meal capricciosa = new Pizza(generateId2(pizzas), "Capricciosa");
		capricciosa = new SideDish(generateId2(sideDishes), capricciosa, "Ketchup");
		
		Meal pastaItaliana = new Pasta(generateId2(pastas), "Pasta italiana");
		pastaItaliana = new SideDish(generateId2(sideDishes), pastaItaliana, "Extra cheese");
		
		Meal coke1 = new Drink(generateId2(drinks), "Coca-Cola", 0.44);
		Meal coke2 = new Drink(generateId2(drinks), "Coca-Cola", 0.44);
		
		
		
		//adding meals to order
		HashSet<Meal> mealsForOrder1 = new HashSet<Meal>();
		mealsForOrder1.add(capricciosa); mealsForOrder1.add(pastaItaliana); 
		mealsForOrder1.add(coke1); mealsForOrder1.add(coke2);
		
		Order orderForTable1 = new Order(generateId2(orders));
		orderForTable1.setMeals(mealsForOrder1);
		
	
		Table table1 = vivifyRestaurnt.getTableById(1);
	
		table1.makeAnOrder(orderForTable1);
		
		
		
		logger.info("Order id: " + orderForTable1.getId() + " " + "Table id: " + table1.getId());
		
		//table 2
		
		Meal sicilliana = new Pizza(generateId2(pizzas), "Sicilliana");
		
		Meal carbonara = new Pizza(generateId2(pizzas), "Carbonara");
		
		Meal juice = new Drink(generateId2(drinks), "Juice", 0.25);
		
		HashSet<Meal> mealsForOrder2 = new HashSet<Meal>();
		mealsForOrder2.add(sicilliana); mealsForOrder2.add(carbonara); mealsForOrder2.add(juice);
		
		Order orderForTable2 = new Order(generateId2(orders));
		orderForTable2.setMeals(mealsForOrder2);

		
		
		Table table2 = vivifyRestaurnt.getTableById(2);
		table2.makeAnOrder(orderForTable2);
		
		logger.info("Order id: " + orderForTable2.getId() + " " + "Table id: " + table2.getId());
		
		//table 3
		Meal pizzaCapricciosaA = new Pizza(generateId2(pizzas), "Pizza capricciosa");
		Meal pizzaCapricciosaB = new Pizza(generateId2(pizzas), "Pizza Capricciosa");
		Meal pizzaCapricciosaC = new Pizza(generateId2(pizzas), "Pizza Capricciosa");
		pizzaCapricciosaB = new SideDish(generateId2(sideDishes), pizzaCapricciosaB, "Ketchup");
		pizzaCapricciosaA = new SideDish(generateId2(sideDishes), pizzaCapricciosaA, "Ketchup");
		
		HashSet<Meal> mealsForOrder3 = new HashSet<Meal>();
		mealsForOrder3.add(pizzaCapricciosaA); mealsForOrder3.add(pizzaCapricciosaB); 
		mealsForOrder3.add(pizzaCapricciosaC);	
		Order orderForTable3 = new Order(generateId2(orders));
		orderForTable3.setMeals(mealsForOrder3);
		
		Table table3 = vivifyRestaurnt.getTableById(3);
		table3.makeAnOrder(orderForTable3);
		
		logger.info("Order id: " + orderForTable3.getId() + " " + "Table id: " + table3.getId());

		
		
	}
	
	private static Receipt generateReceipt(Order o, int tableId) {
		logger.info("Naplata: " + o.getFullCost() +"; Sto: " + tableId);
		return new Receipt(generateId2(receipts), o.getFullDescription(), o.getFullCost(), tableId);
	}
	
	
	
	private static int generateId2(HashMap<Integer, Identifialble> mapa) {
		
		if (mapa.isEmpty()) return 1;
		
		return caluclate.calculate(mapa);
	}
	

	

}
