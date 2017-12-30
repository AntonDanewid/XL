package Model;

import expr.Environment;
import expr.Expr;

public class ExprSlot extends ContainerSlot {

	private Expr e;

	public ExprSlot(Expr e) {
		this.e = e;
	}
	
	public String toString() {
		return e.toString();
	}

	@Override
	public double getValue(Environment env) {
		return e.value(env);
	}



	@Override
	public String getContent(Environment env) {
		return String.valueOf(e.value(env));
	}

	
	

}
