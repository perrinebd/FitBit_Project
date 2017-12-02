/* Name: Team BitFit
 * Class: StopWatchController.java
 * 
 * Functions as Controller for StopWatch menu; creates layout, Model and View,
 * dictates behavior of layout objects.
 */

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
    private Models.TimerModel model;
    private Timer timer;
    private long startTime;

    public StopWatchController() {
    	
        // create GUI info for stop watch
        contentPane = getContentPane();
        setSize(250, 150);
        setTitle("Stop Watch");
        AddButtons("Start", "Stop", "Change View");

        // get model and view objects for display
        model = new Models.TimerModel();
        view = CreateView();
        contentPane.add(view, BorderLayout.CENTER);
        
        // get Timer to update stop watch display
        timer = CreateTimer();
    }

    private StopWatch CreateView(){
        return new View.StopWatch(model);
    }

    // update stop watch display every second
    private Timer CreateTimer(){
        return new Timer(100, e -> {

            // Arithmetic to get timer to count properly
            int seconds = (int) (System.currentTimeMillis() - startTime) / 1000;
            System.out.println(seconds);
            int days = seconds / 86400;
            int hours = (seconds / 3600) - (days * 24);
            int min = (seconds / 60) - (days * 1440) - (hours * 60);
            int sec = seconds % 60;

            // pass new data to model
            model.setHour(hours);
            model.setMinutes(min);
            model.setSeconds(sec);
            
            // update view to display new model values
            view.updateUI();
        });
    }

    // behavior for layout buttons
    public void actionPerformed(ActionEvent event)
    {
    	// if user selects "Start" button, startTime resets to 0, timer starts, and
    	// "Start" button is changed to "Reset" button
        if (event.getActionCommand().equals("Start")) {
            this.startTime = System.currentTimeMillis();
            this.timer.start();
            this.leftButton.setText("Reset");
            this.leftButton.setActionCommand("Reset");

        }
        // if user selects "Reset" button, startTime resets to 0 and timer restarts
        else if (event.getActionCommand().equals("Reset")){
            this.startTime = System.currentTimeMillis();
            this.timer.restart();
        }
        // if user selects "Stop" button, timer stops
        else if (event.getActionCommand().equals("Stop")) {
            this.timer.stop();
        }
        // if "Change View" button is pressed, create ViewSelector window and close StopWatch window
        else if (event.getActionCommand().equals("Change View")) {
        	ViewSelectorController controller = new ViewSelectorController();
        	controller.setVisible(true);
        	this.dispose();
        }

      // update view with new data values
      this.view.updateUI();
    }

    // adding buttons to JPanel, and JPanel to overall layout
    public void AddButtons(String lName, String cName, String rName) {

        // group buttons in grid for contentPane
        buttonArea = new JPanel();
        buttonArea.setLayout(new GridLayout(1, 3));
        contentPane.add(buttonArea, BorderLayout.SOUTH);

        // three buttons representing taps on screen
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

    // create StopWatchController and display it
    public static void main(String[] args) {
        StopWatchController controller = new StopWatchController();
        controller.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controller.setVisible(true);
    }
}
