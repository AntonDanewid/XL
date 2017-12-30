package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;

import Model.Sheet;

public class StatusPanel extends BorderPanel {
    
	protected StatusPanel(StatusLabel statusLabel, Controller cont) {
		add(WEST, new CurrentLabel(cont));
        add(CENTER, statusLabel);
    }
}