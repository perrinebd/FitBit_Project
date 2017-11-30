package View;

import javax.swing.*;
import java.awt.*;

public class StopWatch extends JPanel {
    private Models.TimerModel model;
    private boolean display = true;
    Graphics2D currPane;

    // pass the view a model to render
    public StopWatch(Models.TimerModel timer) {
        this.model = timer;
    }

    public void paintComponent(Graphics g) {
        // use override
        super.paintComponent(g);
        if(display) {
            currPane = (Graphics2D) g;

            // model info to display
            int minutes = (int) model.getMinutes();
            int seconds = (int) model.getSeconds();

            currPane.setFont(new Font("Helvetica", Font.BOLD, 40));
            // render info
            String displayText = String.format("%d m : %d s", minutes, seconds);
            currPane.drawString(displayText, 50, 50);
        }
    }

    public void removeComponent(){
        display = false;
    }
}

