package Controllers;

import View.StepCounter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StepCounterController extends JFrame implements ActionListener{
    private Container contentPane;
    private JPanel buttonArea;
    private JButton rightButton, leftButton, centerButton, stepButton;
    private Models.StepCounter model;
    private View.StepCounter view;
    private View.ViewSelector selectorView;
    private StepCounterController controller;
    private int currSteps;

    public StepCounterController(){

        contentPane = getContentPane();
        setSize(400, 150);
        setTitle("Stop Watch");
        AddButtons("Total", "Log", "Change View", "Step");

        model = new Models.StepCounter();
        view = CreateView();
        contentPane.add(view, BorderLayout.CENTER);
    }

    private StepCounter CreateView(){
        return new View.StepCounter(model);
    }

    public void actionPerformed(ActionEvent event)
    {
    	
        if (event.getActionCommand().equals("Total")) {
           int total = model.getTotalSteps();
           model.setDisplaySteps(total);
        }
        else if (event.getActionCommand().equals("Log")){
            model.logCurrSteps();
        }
        else if (event.getActionCommand().equals("Change View")) {
        	ViewSelectorController controller = new ViewSelectorController();
        	controller.setVisible(true);
        	this.dispose();
        }
        else if (event.getActionCommand().equals("Step")) {
        	model.addSteps();
        	currSteps = model.getCurrSteps();
        	model.setDisplaySteps(currSteps);
        	view.updateUI();
        }
        else if (event.getActionCommand().equals(""))
            System.out.print("f");

        this.view.updateUI();

    }

    public void AddButtons(String lName, String cName, String rName, String sName) {

        buttonArea = new JPanel();
        buttonArea.setLayout(new GridLayout(1, 4));
        contentPane.add(buttonArea, BorderLayout.SOUTH);

        leftButton = new JButton(lName);
        leftButton.addActionListener(this::actionPerformed);

        centerButton = new JButton(cName);
        centerButton.addActionListener(this::actionPerformed);
        
        rightButton = new JButton(rName);
        rightButton.addActionListener(this::actionPerformed);
        
        stepButton = new JButton(sName);
        stepButton.addActionListener(this::actionPerformed);

        // add buttons to the button area
        buttonArea.add(stepButton);
        buttonArea.add(leftButton);
        buttonArea.add(centerButton);
        buttonArea.add(rightButton);
        
    }

    public static void main(String[] args) {
        StepCounterController controller = new StepCounterController();
        controller.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controller.setVisible(true);
    }
}
