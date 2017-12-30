package gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;

public class Controller extends Observable implements MouseListener {

	private String address = "A1";

	public Controller() {
		super();

	}

	public void mouseClicked(MouseEvent e) {
		try {
			SlotLabel label = (SlotLabel) e.getComponent().getComponentAt(e.getPoint());
			address = label.getName();
			setChanged();
			notifyObservers();
		} catch (ClassCastException ex) {
		}

	}

	public String getAddress() {
		return address;
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
