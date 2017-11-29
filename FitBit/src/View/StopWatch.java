package View;

import javax.swing.*;
import java.awt.*;

public class StopWatch extends JPanel {
    private Models.Timer model;

    // pass the view a model to render
    public StopWatch(Models.Timer timer) {
        this.model = timer;
    }

    public void paintComponent(Graphics g) {
        // use override
        super.paintComponent(g);
        Graphics2D currPane = (Graphics2D) g;

        // model info to display
        int minutes = (int) model.getMinutes();
        int seconds = (int) model.getSeconds();

        currPane.setFont(new Font("Helvetica", Font.BOLD, 40));
        // render info
        String displayText = String.format("%d m : %d s", minutes, seconds);
        currPane.drawString(displayText, 50, 50);

    }
}

