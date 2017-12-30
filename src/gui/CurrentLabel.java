package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

public class CurrentLabel extends ColoredLabel implements Observer {
   
	private Controller cont;
	
	public CurrentLabel(Controller cont) {
        super("A1", Color.WHITE);
        this.cont = cont;
        cont.addObserver(this);
    }
	
	@Override
	public void update(Observable o, Object arg) {
		setText(cont.getAddress());
		
	}
    
    
}