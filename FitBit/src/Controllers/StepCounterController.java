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
    private Models.StepCounter model;
    private View.StepCounter view;
    private View.ViewSelector selectorView;
    private StepCounterController controller;


    public StepCounterController(){
    	
    	controller = new StepCounterController();
    	
        contentPane = getContentPane();
        setSize(250, 150);
        setTitle("Stop Watch");
        AddButtons("Total", "Log");

        model = new Models.StepCounter();
        view = CreateView();
        selectorView = new View.ViewSelector(controller);
        contentPane.add(view, BorderLayout.CENTER);
        contentPane.add(selectorView, BorderLayout.EAST);
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
        else if (event.getActionCommand().equals(""))
            System.out.print("f");

        this.view.updateUI();

    }

    public void AddButtons(String lName, String rName) {

        // group buttons in grid for contentPane
        buttonArea = new JPanel();
        buttonArea.setLayout(new GridLayout(1, 2));
        contentPane.add(buttonArea, BorderLayout.SOUTH);

        // two buttons representing taps on either screen side
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
        for (int i = 0; i < 100; i++) {
            Timer timer = new Timer(20, event -> {
                controller.model.addSteps();
                int currSteps = controller.model.getCurrSteps();
                controller.model.setDisplaySteps(currSteps);
;                controller.view.updateUI();
            });
            timer.setDelay(100);
        }

        controller.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controller.setVisible(true);
    }
}
