package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import Model.Sheet;

public class StatusLabel extends ColoredLabel implements Observer {
   
	private Sheet sheet;
	private Controller cont;
	public StatusLabel(Controller cont) {
        super("", Color.WHITE);
		this.cont = cont;
		cont.addObserver(this);
        
    }

	@Override
	public void update(Observable o, Object arg) {
		setText("");
	}
}