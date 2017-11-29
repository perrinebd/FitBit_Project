package View;

import javax.swing.*;
import java.awt.*;

public class UserLogin extends JPanel{
    private Models.User model;

    // pass the view a model to render
    public UserLogin(Models.User user) {
        this.model = user;


    }

    @Override
    public void paintComponent(Graphics g) {
        // use override
        super.paintComponent(g);

        // cast graphics obj to 2D
        Graphics2D currPane = (Graphics2D) g;
        currPane.drawRect(20,20,20,20);

        // model info to display
        String name = model.getName();
        String pwd = model.getPassword();
        String displayText;

        // render info
        if (name == null || pwd == null)
            displayText = "Username : N/A || Password : N/A";
        displayText = String.format("Username : %s || Password : %s", name, pwd);
        System.out.println(String.format("Username : %s || Password : %s", name, pwd));
        currPane.drawString(displayText, 25, 25);
    }

    public void errorPopUp() {
        JOptionPane.showMessageDialog(this,"Incorrect username or password",
                "Error", JOptionPane.ERROR_MESSAGE);
    }
}
