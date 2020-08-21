package model;

import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Restaurant extends Identifialble{
	
	
	private HashSet<Table> tables;
	
	private static Restaurant uniqueRestaurant;
	
	
	
	public static Restaurant getInstance(int id, int numberOfTable) {
		if (uniqueRestaurant == null) {
			uniqueRestaurant = new Restaurant(id, numberOfTable);
		}
		return uniqueRestaurant;
	}

	private Restaurant(int id, int numberOfTable) {
		super(id);
	
		this.tables = IntStream.rangeClosed(1, numberOfTable).boxed()
				.map(idTable ->new Table(idTable))
				.collect(Collectors.toCollection(HashSet::new));
		
		tables.forEach(t -> main.Main.tables.put(t.getId(), t));
		
	}
	
	public Table getTableById(int id) {
		return this.tables.stream().filter(t -> id == t.getId()).findFirst().orElseThrow();
	}
}
