package gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

import Model.Sheet;
import gui.Editor;
import gui.StatusLabel;

class ClearMenuItem extends JMenuItem implements ActionListener {
    private Editor editor;

	public ClearMenuItem(StatusLabel statuslabel, Editor editor) {
        super("Clear");
		this.editor = editor;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        editor.clear();
    }
}