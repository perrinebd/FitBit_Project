package View;

import javax.swing.*;
import java.awt.*;

public class StepCounter extends JFrame {
    JFrame frame;
    JPanel converterPanel;
    JPanel buttonPanel;

    public StepCounter(JFrame frame){
        frame = new JFrame("Convert Celsius to Fahrenheit");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(120, 40));

        //Create and set up the panel.
        buttonPanel = new JPanel(new GridLayout(2, 2));

        this.frame = frame;

    }
}
