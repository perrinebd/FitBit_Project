/* Name: Team BitFit
 * Class: StepCounterController.java
 * 
 * Functions as Controller for StepCounter menu; creates layout, Model and View,
 * dictates behavior of layout objects.
 */

package Controllers;

import View.StepCounter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StepCounterController extends JFrame implements ActionListener{
    private Container contentPane;
    private JPanel buttonArea;
    private JButton rightButton, leftButton;
    private static Models.StepCounter model;
    private static View.StepCounter view;
    private View.ViewSelector selectorView;
    private StepCounterController controller;
    private static int currSteps;
    private Timer timer;

    public StepCounterController(){

    	// create GUI info for Step Counter
        contentPane = getContentPane();
        setSize(400, 150);
        setTitle("Step Counter");
        
        // create Timer that updates current step count by 1 every 1.5 seconds
        timer = new Timer(1500, null);
        timer.addActionListener((event) -> {
        	// increase model.currSteps by 1, assign that to this.currSteps, set
        	// this.currSteps to model.displaySteps, and then update the UI with
        	// the new display
            model.addSteps();
           	currSteps = model.getCurrSteps();
           	model.setDisplaySteps(currSteps);
           	view.updateUI();
        });
        // timer runs continuously
        timer.setRepeats(true);
        timer.start();
        
        AddButtons("Log Steps", "Change View");

        // create Model and View objects for displaying data
        model = new Models.StepCounter();
        view = CreateView();
        contentPane.add(view, BorderLayout.CENTER);
    }

    private StepCounter CreateView(){
        return new View.StepCounter(model);
    }

    // behavior for layout buttons
    public void actionPerformed(ActionEvent event)
    {
    	// if user selects "Log Steps" button, current steps are added to total steps,
    	// current steps are reset to 1, and total step display is updated with total steps
        if (event.getActionCommand().equals("Log Steps")){
            model.logCurrSteps();
            int total = model.getTotalSteps();
            model.setDisplaySteps(1);
        }
        // if user selects "Change View" button, create ViewSelector window and close StepCounter window
        else if (event.getActionCommand().equals("Change View")) {
        	ViewSelectorController controller = new ViewSelectorController();
        	controller.setVisible(true);
        	this.dispose();
        }
        // error message
        else if (event.getActionCommand().equals(""))
            System.out.print("f");

        // update view with new data values
        this.view.updateUI();

    }

    // adding buttons to JPanel, and JPanel to overall layout
    public void AddButtons(String lName, String rName) {

        buttonArea = new JPanel();
        buttonArea.setLayout(new GridLayout(1, 4));
        contentPane.add(buttonArea, BorderLayout.SOUTH);

        leftButton = new JButton(lName);
        leftButton.addActionListener(this::actionPerformed);
        
        rightButton = new JButton(rName);
        rightButton.addActionListener(this::actionPerformed);

        // add buttons to the button area
        buttonArea.add(leftButton);
        buttonArea.add(rightButton);
        
    }

    // create StepCounterController and display it
    public static void main(String[] args) {
        StepCounterController controller = new StepCounterController();
        controller.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controller.setVisible(true);
    }
}
