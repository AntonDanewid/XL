package Model;

import expr.Environment;

public class CircularSlot implements Slot {

	@Override
	public double getValue(Environment env) {
		throw new XLException("Circular dependency. Enter a valid expression.");
	} 
	
	public String toString() {
		throw new XLException("Circular dependency. Enter a valid expression.");
	}

	
	

}
