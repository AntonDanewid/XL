package gui.menu;

import gui.StatusLabel;
import gui.XL;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;

import Model.Sheet;
import Model.XLException;

class LoadMenuItem extends OpenMenuItem {
 
	private Sheet sheet;
	private StatusLabel statusLabel;
	
    public LoadMenuItem(XL xl, StatusLabel statusLabel, Sheet sheet) {
        super(xl, statusLabel, "Load");
		this.statusLabel = statusLabel;
        this.sheet = sheet;
    }

    protected void action(String path) throws FileNotFoundException {
    	try {
    		sheet.loadSheet(path);
    		statusLabel.setText("");
    	} catch (XLException e) {
    		statusLabel.setText(e.getMessage());
    	}
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showOpenDialog(xl);
    }
}