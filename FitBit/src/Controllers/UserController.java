package Controllers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class UserController extends JFrame {

    private JLabel nameLabel,pwdlabel;
    private JButton submit;
    private JPanel nameArea, pwdArea;
    private Container contentPane;
    private JTextField  name,pwd;
    private View.User view;
    private Models.User model;


    public UserController()
    {
        contentPane = getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        setSize(400, 400);
        setTitle("Welcome!");

        nameArea = new JPanel();
        pwdArea = new JPanel();
        nameLabel = new JLabel("nameLabel");
        nameLabel.setText("Username:");

        name = new JTextField(15);
        name.setAlignmentX(Component.CENTER_ALIGNMENT);

        pwdlabel = new JLabel("pwdlabel");
        pwdlabel.setText("Password:");
        pwd = new JPasswordField(15);
        pwdlabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        submit = new JButton("submit");
        submit.addActionListener(this::ActionHandler);

        nameArea.add(nameLabel);
        nameArea.add(name);
        pwdArea.add(pwdlabel);
        pwdArea.add(pwd);

        contentPane.add(nameArea, BorderLayout.WEST);
        contentPane.add(pwdArea, BorderLayout.WEST);
        contentPane.add(submit, BorderLayout.SOUTH);

        model = new Models.User();
        view = new View.User(model);

        contentPane.add(view, BorderLayout.CENTER);
    }

    public void ActionHandler(ActionEvent ae)
    {
        String nameIn = name.getText();
        String pwdIN = pwd.getText();

        if (nameIn.equals("perrinebd") && pwdIN.equals("ntadmin")) {
          //  NextPage page=new NextPage();
          //  page.setVisible(true);
          //  JLabel label = new JLabel("Welcome:"+ nameIn);
            //view.getContentPane().add(label);
            model.setName(nameIn);
            model.setPassword(pwdIN);
            view.updateUI();

        }
        else {
            JOptionPane.showMessageDialog(this,"Incorrect username or password",
                    "Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args)
    {
       UserController controller = new UserController();
       controller.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       controller.setVisible(true);
    }

}
