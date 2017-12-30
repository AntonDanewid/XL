package gui;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import Model.*;

import javax.swing.JTextField;

public class Editor extends JTextField implements Observer {

	private Sheet sheet;
	private String address = "A1";
	private Controller cont;
	private StatusLabel statusLabel;

	public Editor(Sheet sheet, Controller cont, StatusLabel statusLabel) {
		this.statusLabel = statusLabel;
		setBackground(Color.WHITE);
		this.sheet = sheet;
		this.cont = cont;
		cont.addObserver(this);
		addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						String s = getText();
						sheet.addSlot(address, s);
					} catch (XLException ex) {
						statusLabel.setText(ex.getMessage());
					}
				}

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyTyped(KeyEvent e) {

			}

		});
	}

	public void clear() {
		try {
			sheet.addSlot(address, "");
			setText("");
		} catch (XLException ex) {
			statusLabel.setText(ex.getMessage());
		}
	
	
	}
	
	public void update(Observable arg0, Object arg1) {
		address = cont.getAddress();
		setText(sheet.getExprString(address));
	}
	public void clearAll() {
		setText("");
		statusLabel.setText("");
		
	}

}
