package Controllers;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ViewSelectorController extends JFrame {
	private JPanel checkBoxPanel = new JPanel();
    private JCheckBox checkBoxWatch = new JCheckBox();
    private JCheckBox checkBoxStep = new JCheckBox();
    private JCheckBox checkBoxHRM = new JCheckBox();
    private JCheckBox checkBoxUser = new JCheckBox();
	
	public ViewSelectorController() {
    
		checkBoxPanel.add(checkBoxWatch);
		checkBoxPanel.add(checkBoxStep);
		checkBoxPanel.add(checkBoxHRM);
		checkBoxPanel.add(checkBoxUser);
	
		checkBoxWatch.addItemListener(new ItemListener() {
		
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (checkBoxWatch.isSelected()) {
					
					StopWatchController stopFrame = new StopWatchController();
					stopFrame.setVisible(true);
				}
			}
		});
		checkBoxStep.addItemListener(new ItemListener() {
		
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (checkBoxStep.isSelected()) {
					
					StepCounterController stepFrame = new StepCounterController();
					stepFrame.setVisible(true);
				}
			}
		});
		checkBoxHRM.addItemListener(new ItemListener() {
	    	
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (checkBoxHRM.isSelected()) {
					
					//HRMController hRMFrame = new HRMController();
					//hRMFrame.setVisible(true);
				}
			}
		});
		checkBoxUser.addItemListener(new ItemListener() {
	    	
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (checkBoxUser.isSelected()) {
					
					UserController userFrame = new UserController();
					userFrame.setVisible(true);
				}
			}
		});
	}

	public static void main(String[] args) {
		ViewSelectorController controller = new ViewSelectorController();
		controller.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		controller.setVisible(true);
	}
}
