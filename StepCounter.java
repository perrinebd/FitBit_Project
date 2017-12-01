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
        int totalSteps = model.getTotalSteps();
        if (firstTime) {
        	model.setDisplaySteps(0);
        	firstTime = false;
        }

        currPane.setFont(new Font("Helvetica", Font.BOLD, 40));
        // render info
        String currStepNum = String.format("%d", steps);
        String totalStepNum = String.format("%d", totalSteps);
        
        String currStepText = "Current:";
        String totalStepText = "Total:";
        
        currPane.drawString(currStepNum, 150, 50);
        currPane.drawString(totalStepNum, 300, 50);
        
        currPane.setFont(new Font("Helvetica", Font.BOLD, 20));
        currPane.drawString(currStepText, 65, 45);
        currPane.drawString(totalStepText, 235, 45);
    }

    public void removeComponent(){
        currPane.dispose();
    }
}