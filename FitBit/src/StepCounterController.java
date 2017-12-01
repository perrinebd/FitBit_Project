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

        contentPane = getContentPane();
        setSize(400, 150);
        setTitle("Stop Watch");
        timer = new Timer(1500, null);
        timer.addActionListener((event) -> {
            model.addSteps();
           	currSteps = model.getCurrSteps();
           	model.setDisplaySteps(currSteps);
           	view.updateUI();
        });
        timer.setRepeats(true);
        timer.start();
        AddButtons("Log Steps", "Change View");

        model = new Models.StepCounter();
        view = CreateView();
        contentPane.add(view, BorderLayout.CENTER);
    }

    private StepCounter CreateView(){
        return new View.StepCounter(model);
    }

    public void actionPerformed(ActionEvent event)
    {
        if (event.getActionCommand().equals("Log Steps")){
            model.logCurrSteps();
            int total = model.getTotalSteps();
            model.setDisplaySteps(1);
        }
        else if (event.getActionCommand().equals("Change View")) {
        	ViewSelectorController controller = new ViewSelectorController();
        	controller.setVisible(true);
        	this.dispose();
        }
        else if (event.getActionCommand().equals(""))
            System.out.print("f");

        this.view.updateUI();

    }

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

    public static void main(String[] args) {
        StepCounterController controller = new StepCounterController();
        controller.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controller.setVisible(true);
    }
}
