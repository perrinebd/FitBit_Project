/* Name: Team BitFit
 * Class: ViewSelectorController.java
 * 
 * Functions as Controller for ViewSelector menu; creates layout and View,
 * dictates behavior of layout objects.
 */

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
    	
    	// create GUI info for view selector
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
		
		//creates UI window
		view = CreateView();
		
		contentPane.add(view, BorderLayout.SOUTH);
		contentPane.add(checkBoxPanel, BorderLayout.CENTER);
		
		//checkbox functionality
		checkBoxWatch.addItemListener(this::itemChecked);
		checkBoxStep.addItemListener(this::itemChecked);
		checkBoxHRM.addItemListener(this::itemChecked);
		checkBoxUser.addItemListener(this::itemChecked);

	}
    
    private ViewSelector CreateView(){
        return new View.ViewSelector();
    }
    
    // changing view windows based on checkbox selected
    public void itemChecked(ItemEvent event) {
    	
    	// change view to StopWatch, close ViewSelector view
    	if (checkBoxWatch.isSelected()) {
			StopWatchController stopFrame = new StopWatchController();
			stopFrame.setVisible(true);
			this.dispose();
		}
    	// change view to StepCounter, close ViewSelector view
    	if (checkBoxStep.isSelected()) {
			StepCounterController stepFrame = new StepCounterController();
			stepFrame.setVisible(true);
			this.dispose();
		}
    	// change view to HRMMonitor, close ViewSelector view
    	if (checkBoxHRM.isSelected()) {
			//HRMController hRMFrame = new HRMController();
			//hRMFrame.setVisible(true);
    		//this.dispose();
		}
    	// change view to UserLogin, close ViewSelector view
		if (checkBoxUser.isSelected()) {
			UserController userFrame = new UserController();
			userFrame.setVisible(true);
			this.dispose();
		}
    	
    }

    // creation of ViewSelectorController and display
	public static void main(String[] args) {
		ViewSelectorController controller = new ViewSelectorController();
		controller.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		controller.setVisible(true);
	}
}
