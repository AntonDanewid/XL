package Model;

import java.io.IOException;

import expr.Environment;

public class CommentSlot extends ContainerSlot {

	private String s;
	
	public CommentSlot(String s) {
		this.s = s;
	}
	
	public String toString() { 
		return s;
	}


	@Override
	public double getValue(Environment env) {
		return 0;
	}

	@Override
	public String getContent(Environment env) {
		return s.substring(1);
	}

	


}
