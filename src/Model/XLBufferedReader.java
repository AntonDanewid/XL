package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import expr.Expr;
import expr.ExprParser;

//TODO move to another package
public class XLBufferedReader extends BufferedReader {

	private ExprParser parser;

	public XLBufferedReader(String name) throws FileNotFoundException {
		super(new FileReader(name));
		this.parser = new ExprParser();
	}

	// TODO Change Object to something appropriate
	public void load(Map<String, Slot> map, Sheet s) {
		
			try {
				while (ready()) {

					String string = readLine();
					int i = string.indexOf('=');
					String address = string.substring(0, i);
					s.addSlot(address, string.substring(i + 1));

}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}}
