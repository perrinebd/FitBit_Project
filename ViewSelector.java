package View;

import javax.swing.*;
import java.awt.*;

public class ViewSelector extends JPanel {
    private Graphics2D currPane;

    // pass the view a model to render
    public ViewSelector() {
    }

    public void paintComponent(Graphics g) {

        // create new pane to paint from base Graphic obj g
        super.paintComponent(g);
        currPane = (Graphics2D) g;

        currPane.setFont(new Font("Helvetica", Font.BOLD, 40));
        // render info
        String stepText = String.format("Step Counter");
        String stopText = String.format("Stopwatch");
        String hrmText = String.format("Heart Rate Monitor");
        String userText = String.format("User Login");
        
        currPane.drawString(stepText, 50, 50);
        currPane.drawString(stopText, 100, 50);
        currPane.drawString(hrmText, 50, 100);
        currPane.drawString(userText, 100, 100);
    }

    public void removeComponent(){
        currPane.dispose();
    }
}