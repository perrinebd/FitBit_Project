package Controllers;

import View.StopWatch;
import View.ViewSelector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StopWatchController extends JFrame implements ActionListener{
    private JLabel secondsLabel, minuteLabel;
    private JButton rightButton, leftButton, centerButton;
    private JPanel buttonArea;
    private Container contentPane;
    private View.StopWatch view;
    private View.ViewSelector selectorView;
    private Models.TimerModel model;
    private StopWatchController controller;
    private Timer timer;
    private long startTime;

    public StopWatchController() {

    	//controller = new StopWatchController();
    	
        // create GUI info for stopwatch
        contentPane = getContentPane();
        setSize(250, 150);
        setTitle("Stop Watch");
        AddButtons("Start", "Stop", "Change View");

        // get model and view objects for display
        model = new Models.TimerModel();
        view = CreateView();
        contentPane.add(view, BorderLayout.CENTER);
        

        timer = CreateTimer();
    }

    private StopWatch CreateView(){
        return new View.StopWatch(model);
    }

    private Timer CreateTimer(){
        return new Timer(100, e -> {

            // arithmatic to get timer to count properly
            int seconds = (int) (System.currentTimeMillis() - startTime) / 1000;
            int days = seconds / 86400;
            int hours = (seconds / 3600) - (days * 24);
            int min = (seconds / 60) - (days * 1440) - (hours * 60);
            int sec = seconds % 60;

            // pass new data to model
            model.setMinutes(min);
            model.setSeconds(sec);

            // update view to display new model values
            view.updateUI();
        });
    }

    public void actionPerformed(ActionEvent event)
    {
        if (event.getActionCommand().equals("Start")) {
            this.startTime = System.currentTimeMillis();
            this.timer.start();
            this.leftButton.setText("Reset");
            this.leftButton.setActionCommand("Reset");

        }
        else if (event.getActionCommand().equals("Reset")){
            this.startTime = System.currentTimeMillis();
            this.timer.restart();
        }
        else if (event.getActionCommand().equals("Stop")) {
            this.timer.stop();
        }
        else if (event.getActionCommand().equals("Change View")) {
        	ViewSelectorController controller = new ViewSelectorController();
        	controller.setVisible(true);
        	this.dispose();
        }


      this.view.updateUI();
    }

    public void AddButtons(String lName, String cName, String rName) {

        // group buttons in grid for contentPane
        buttonArea = new JPanel();
        buttonArea.setLayout(new GridLayout(1, 3));
        contentPane.add(buttonArea, BorderLayout.SOUTH);

        // two buttons representing taps on either screen side
        leftButton = new JButton(lName);
        leftButton.addActionListener(this::actionPerformed);

        centerButton = new JButton(cName);
        centerButton.addActionListener(this::actionPerformed);
        
        rightButton = new JButton(rName);
        rightButton.addActionListener(this::actionPerformed);

        // add buttons to the button area
        buttonArea.add(leftButton);
        buttonArea.add(centerButton);
        buttonArea.add(rightButton);

    }

    public void removeView(){
        view.removeComponent();
        this.contentPane.remove(buttonArea);
    }

    public static void main(String[] args) {
        StopWatchController controller = new StopWatchController();
        controller.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controller.setVisible(true);
    }
}
