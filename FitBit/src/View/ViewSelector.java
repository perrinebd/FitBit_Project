package View;

import javax.swing.*;

import Controllers.StepCounterController;
import Controllers.StopWatchController;
import Controllers.UserController;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ViewSelector extends JPanel {
    private Graphics2D currPane;
    private JFrame currFrame = new JFrame();
	private JPanel checkBoxPanel = new JPanel();
	private JCheckBox checkBoxWatch = new JCheckBox();
	private JCheckBox checkBoxStep = new JCheckBox();
	private JCheckBox checkBoxHRM = new JCheckBox();
	private JCheckBox checkBoxUser = new JCheckBox();

    public ViewSelector(JFrame currFrame) {
    	
		this.currFrame = currFrame;
		checkBoxPanel.setLayout(new GridLayout(2, 2));
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
					currFrame.dispose();
				}
			}
		});
		checkBoxStep.addItemListener(new ItemListener() {
		
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (checkBoxStep.isSelected()) {
					StepCounterController stepFrame = new StepCounterController();
					stepFrame.setVisible(true);
					currFrame.dispose();
				}
			}
		});
		checkBoxHRM.addItemListener(new ItemListener() {
	    	
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (checkBoxHRM.isSelected()) {
					//HRMController hRMFrame = new HRMController();
					//hRMFrame.setVisible(true);
					//currFrame.dispose();
				}
			}
		});
		checkBoxUser.addItemListener(new ItemListener() {
	    	
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (checkBoxUser.isSelected()) {
					UserController userFrame = new UserController();
					userFrame.setVisible(true);
					currFrame.dispose();
				}
			}
		});
	}

    public void paintComponent(Graphics g) {

        // create new pane to paint from base Graphic obj g
        super.paintComponent(g);
        currPane = (Graphics2D) g;

        currPane.setFont(new Font("Helvetica", Font.BOLD, 10));
        String stepText = String.format("Step Counter");
        String stopText = String.format("Stopwatch");
        String hrmText = String.format("Heart Rate Monitor");
        String userText = String.format("User Login");
        
        currPane.drawString(stepText, 50, 50);
        currPane.drawString(stopText, 100, 50);
        currPane.drawString(hrmText, 50, 100);
        currPane.drawString(userText, 100, 100);
    }

    public void removeComponent(){
        currPane.dispose();
    }
}