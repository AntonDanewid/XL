package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;

import Model.Sheet;

public class SheetPanel extends BorderPanel {
    public SheetPanel(int rows, int columns, Editor editor, Sheet sheet, Controller cont) {
        add(WEST, new RowLabels(rows));
        add(CENTER, new SlotLabels(rows, columns, sheet, cont));
    }
}