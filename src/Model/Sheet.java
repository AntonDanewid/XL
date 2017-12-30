package Model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

import expr.*;

public class Sheet extends Observable implements Environment {

	private Map<String, Slot> map = new HashMap<String, Slot>();
	private ExprParser parser = new ExprParser();
	private Environment env;
	private XLPrintStream ps;
	private XLBufferedReader br;

	public Sheet() {
		env = new Environment() {
			public double value(String name) {
				if (map.containsKey(name)) {
					return map.get(name).getValue(env);
				} else {
					throw new XLException("Invalid action");
				}

			}

		};
	}

	public void addSlot(String address, String expr) {
		Slot a = map.get(address);
		if (expr.length() == 0) {
			Slot temp = map.get(address);
			if (temp != null) {
				map.remove(address);
				String tempAddress = "";
				try {
					for (Entry<String, Slot> entry : map.entrySet()) {
						tempAddress = entry.getKey();

						entry.getValue().getValue(env);
					}
				} catch (XLException e) {
					map.put(address, temp);
					throw new XLException(e.getMessage() + ". Dependency issue in slot " + tempAddress + ".");
				}

				setChanged();
				notifyObservers();
			}
		} else if (expr.charAt(0) == '#') {
			CommentSlot comment = new CommentSlot(expr);
			map.put(address, comment);
			setChanged();
			notifyObservers();
		} else {

			Expr e;
			try {
				e = parser.build(expr);
				CircularSlot cs = new CircularSlot();
				map.put(address, cs);

				e.value(env);
				map.put(address, new ExprSlot(e));

				setChanged();
				notifyObservers();
			} catch (XLException | IOException io) {
				map.remove(address);
				if (a != null) {
					map.put(address, a);
				}
				setChanged();
				notifyObservers();
				throw new XLException(io.getMessage());
			}

		}

	}

	public String getSlot(String address) {
		if (!map.containsKey(address)) {
			return "";
		}
		String css = ((ContainerSlot) map.get(address)).getContent(env);
		return css;

	}

	public String getExprString(String address) {
		if (!map.containsKey(address)) {
			return "";
		}

		return ((ContainerSlot) map.get(address)).toString();

	}

	public double value(String variables) {

		Expr e;
		try {
			e = parser.build(variables);
			return e.value(env);
		} catch (IOException e1) {

		}
		return 0;
	}

	public void saveSheet(String filename) {
		try {
			ps = new XLPrintStream(filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Set saveSet = new HashSet<Entry<String, Slot>>();
		for (Entry<String, Slot> entry : map.entrySet()) {
			saveSet.add(entry);
		}
		ps.save(saveSet);
	}

	public void loadSheet(String filename) {
		map.clear();
		try {
			br = new XLBufferedReader(filename);
			br.load(map, this);
		} catch (FileNotFoundException | XLException e) {
			clearSheet();
			throw new XLException(e.getMessage());
		}
		setChanged();
		notifyObservers();
	}

	public void clearSheet() {
		map.clear();
		setChanged();
		notifyObservers();
	}
}
