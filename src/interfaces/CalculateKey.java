package interfaces;

@FunctionalInterface
public interface CalculateKey<T> {
	
	int calculate(T t);
}
