package gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.SwingConstants;

import Model.Sheet;

public class SlotLabels extends GridPanel implements Observer {
	private List<SlotLabel> labelList;
	private int rows;
	private int cols;
	private Sheet sheet;
	private Controller cont;
	private String currentAddress = "A1";

	public SlotLabels(int rows, int cols, Sheet sheet, Controller cont) {
		super(rows + 1, cols);
		this.sheet = sheet;
		this.cols =  cols;
		this.rows = rows;
		this.cont = cont;
		sheet.addObserver(this);
		cont.addObserver(this);
		addMouseListener(cont);
		labelList = new ArrayList<SlotLabel>(rows * cols);
		for (char ch = 'A'; ch < 'A' + cols; ch++) {
			add(new ColoredLabel(Character.toString(ch), Color.LIGHT_GRAY, SwingConstants.CENTER));
		}
		for (int row = 1; row <= rows; row++) {
			for (char ch = 'A'; ch < 'A' + cols; ch++) {
				SlotLabel label = new SlotLabel();
				label.setName(String.valueOf(ch) + row);
				add(label);
				labelList.add(label);

			}
		}
		SlotLabel firstLabel = labelList.get(0);
		firstLabel.setBackground(Color.YELLOW);
	}

	public void update(Observable obs, Object arg1) {

		int counter = 0;
		for (int row = 1; row <= rows; row++) {
			for (char ch = 'A'; ch < 'A' + cols; ch++) {
				SlotLabel a = labelList.get(counter);
				a.setText(sheet.getSlot(String.valueOf(ch) + row));
				counter++;
			}

		}
		for(SlotLabel label: labelList) {
			label.setBackground(Color.WHITE);
		}
		
		currentAddress= cont.getAddress();
		for (SlotLabel label : labelList) {
			if (label.getName().equals(currentAddress)) {
				label.setBackground(Color.YELLOW);
			}
		}
	}
}
