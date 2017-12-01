package Controllers;

import java.awt.*;
import javax.swing.*;

import View.StopWatch;
import View.ViewSelector;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ViewSelectorController extends JFrame {
    private JFrame currFrame;
	private JPanel checkBoxPanel;
    private Container contentPane;
	private JCheckBox checkBoxWatch;
	private JCheckBox checkBoxStep;
	private JCheckBox checkBoxHRM;
	private JCheckBox checkBoxUser;
    private ViewSelector view;

    public ViewSelectorController() {
    	
    	contentPane = getContentPane();
    	setSize(200, 175);
    	setTitle("View Selection");
    	currFrame = new JFrame();
    	checkBoxPanel = new JPanel();
    	checkBoxWatch = new JCheckBox("Stopwatch");
    	checkBoxStep = new JCheckBox("Step Counter");
    	checkBoxHRM = new JCheckBox("Heart Rate Monitor");
    	checkBoxUser = new JCheckBox("User Login");
    
		checkBoxPanel.add(checkBoxWatch);
		checkBoxPanel.add(checkBoxStep);
		checkBoxPanel.add(checkBoxHRM);
		checkBoxPanel.add(checkBoxUser);
		
		view = CreateView();
		
		contentPane.add(view, BorderLayout.SOUTH);
		contentPane.add(checkBoxPanel, BorderLayout.CENTER);
	
		checkBoxWatch.addItemListener(this::itemChecked);
		checkBoxStep.addItemListener(this::itemChecked);
		checkBoxHRM.addItemListener(this::itemChecked);
		checkBoxUser.addItemListener(this::itemChecked);

	}
    
    private ViewSelector CreateView(){
        return new View.ViewSelector();
    }
    
    public void itemChecked(ItemEvent event) {
    	
    	if (checkBoxWatch.isSelected()) {
			StopWatchController stopFrame = new StopWatchController();
			stopFrame.setVisible(true);
			this.dispose();
		}
    	if (checkBoxStep.isSelected()) {
			StepCounterController stepFrame = new StepCounterController();
			stepFrame.setVisible(true);
			this.dispose();
		}
    	if (checkBoxHRM.isSelected()) {
			//HRMController hRMFrame = new HRMController();
			//hRMFrame.setVisible(true);
    		//this.dispose();
		}
		if (checkBoxUser.isSelected()) {
			UserController userFrame = new UserController();
			userFrame.setVisible(true);
			this.dispose();
		}
    	
    }

	public static void main(String[] args) {
		ViewSelectorController controller = new ViewSelectorController();
		controller.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		controller.setVisible(true);
	}
}
