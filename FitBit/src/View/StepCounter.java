package View;
import javax.swing.*;
import java.awt.*;

public class StepCounter extends JPanel {
    private Models.StepCounter model;
    private Graphics2D currPane;
    private boolean firstTime;

    // pass the view a model to render
    public StepCounter(Models.StepCounter count) {
        this.model = count;
        firstTime = true;
    }

    public void paintComponent(Graphics g) {

        // create new pane to paint from base Graphic obj g
        super.paintComponent(g);
        currPane = (Graphics2D) g;

        // model info to display
        int steps = model.getDisplaySteps();
        if (firstTime) {
        	System.out.println("Hi");
        	model.setDisplaySteps(0);
        	firstTime = false;
        }

        currPane.setFont(new Font("Helvetica", Font.BOLD, 40));
        // render info
        String displayText = String.format("%d", steps);
        currPane.drawString(displayText, 180, 50);
    }

    public void removeComponent(){
        currPane.dispose();
    }
}