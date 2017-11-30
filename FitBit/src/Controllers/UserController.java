package Controllers;

import View.UserLogin;
import View.ViewSelector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class UserController extends JFrame {

    private JLabel nameLabel,pwdlabel;
    private JButton submit;
    private JPanel nameArea, pwdArea;
    private Container contentPane;
    private JTextField  name,pwd;
    private UserLogin view;
    private ViewSelector selectorView;
    private UserController controller;
    private Models.User model;


    public UserController() {

    	controller = new UserController();
    	
        contentPane = getContentPane();
        setSize(400, 400);
        setTitle("Welcome!");

        JPanel area = new JPanel();

        nameLabel = new JLabel("Username: ");

        area.add(nameLabel);

        name = new JTextField(20);

        area.add(name);

        pwdlabel = new JLabel("Password: ");

        area.add(pwdlabel);

        pwd = new JPasswordField(20);

        area.add(pwd);

        submit = new JButton("submit");
        submit.addActionListener(this::ActionHandler);

        contentPane.add(area, BorderLayout.WEST);

       // contentPane.add(pwdArea, BorderLayout.WEST);
        contentPane.add(submit, BorderLayout.SOUTH);
        model = new Models.User();
        view = new UserLogin(model);
        selectorView = new ViewSelector(controller);

        contentPane.add(view, BorderLayout.CENTER);
        contentPane.add(selectorView, BorderLayout.EAST);

        view.updateUI();
        pack();
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
            view.repaint();
            view.updateUI();
        }
        else {
            view.errorPopUp();
        }
    }

    public static void main(String[] args)
    {
       UserController controller = new UserController();
       controller.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       controller.setVisible(true);
    }

}
