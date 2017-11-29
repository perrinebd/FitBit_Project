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


    public StepCounterController(){
        contentPane = getContentPane();
        setSize(250, 150);
        setTitle("Stop Watch");
        AddButtons("Total", "Log");

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
           model.setDisplaySteps(model.getTotalSteps());
        }
        else if (event.getActionCommand().equals("Log")){
            model.logCurrSteps();
            model.setDisplaySteps(model.getTotalSteps());
        }
        else if (event.getActionCommand().equals("Stop"))
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
        controller.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controller.setVisible(true);
    }
}
