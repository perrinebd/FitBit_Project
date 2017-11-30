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
    private JFrame currFrame;
	private JPanel checkBoxPanel;
	private JCheckBox checkBoxWatch;
	private JCheckBox checkBoxStep;
	private JCheckBox checkBoxHRM;
	private JCheckBox checkBoxUser;

    public ViewSelector() {
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