package Controllers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class StopWatchController extends JFrame {
    private JLabel secondsLabel, minuteLabel;
    private JButton startButton, stopButton, resetButton;
    private JPanel buttonArea;
    private Container contentPane;
    private View.StopWatch view;
    private Models.Timer model;
    private Timer timer;
    private long startTime;

    public StopWatchController() {

        // create GUI info for stopwatch
        contentPane = getContentPane();
        setSize(400, 400);
        setTitle("Stop Watch");

        // group buttons together
        buttonArea = new JPanel();
        buttonArea.setLayout(new GridLayout(1, 3));
        contentPane.add(buttonArea, BorderLayout.SOUTH);

        // three buttons, each with a listener to trigger start
        startButton = new JButton("Start");
        startButton.addActionListener(this::ActionHandler);

        stopButton = new JButton("Stop");
        stopButton.addActionListener(this::ActionHandler);

        resetButton = new JButton("Reset");
        resetButton.addActionListener(this::ActionHandler);

        // add buttons to the button area
        buttonArea.add(startButton);
        buttonArea.add(stopButton);
        buttonArea.add(resetButton);

        // get model and view objects for display
        model = new Models.Timer();
        view = new View.StopWatch(model);

        contentPane.add(view, BorderLayout.CENTER);

        // create a timer using the swing.util
        timer =
                new Timer(100, e -> {

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

    public void ActionHandler(ActionEvent event)
    {
        if (event.getActionCommand().equals("Start")) {
            startTime = System.currentTimeMillis();
            timer.start();
        }
        else if (event.getActionCommand().equals("Reset")) {
            startTime = System.currentTimeMillis();
            timer.restart();
        }

        else if (event.getActionCommand().equals("Stop"))
            timer.stop();

        view.updateUI();
    }

    public static void main(String[] args) {
        StopWatchController controller = new StopWatchController();
        controller.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controller.setVisible(true);
    }
}