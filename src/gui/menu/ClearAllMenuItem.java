package gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

import Model.Sheet;
import gui.Editor;

class ClearAllMenuItem extends JMenuItem implements ActionListener {
   
	private Sheet sheet;
	private Editor editor;
	public ClearAllMenuItem(Sheet sheet, Editor editor) {
        super("Clear all");
		this.editor = editor;
        addActionListener(this);
        this.sheet = sheet;
    }

    public void actionPerformed(ActionEvent e) {
        sheet.clearSheet();
        editor.clearAll();
    }
}