package Controllers;

import View.UserLogin;
import View.ViewSelector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class UserController extends JFrame {

    private JLabel nameLabel,pwdlabel;
    private JButton submit, changeView;
    private JPanel nameArea, pwdArea, buttonArea;
    private Container contentPane;
    private JTextField  name,pwd;
    private UserLogin view;
    private ViewSelector selectorView;
    private UserController controller;
    private Models.User model;


    public UserController() {

    	//controller = new UserController();
    	
        contentPane = getContentPane();
        setSize(600, 600);
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

        contentPane.add(area, BorderLayout.WEST);
        
        AddButtons("submit", "Change View");

       // contentPane.add(pwdArea, BorderLayout.WEST);
        model = new Models.User();
        view = new UserLogin(model);

        contentPane.add(view, BorderLayout.CENTER);

        view.updateUI();
        pack();
    }
    
    public void AddButtons(String lName, String rName) {

        // group buttons in grid for contentPane
        buttonArea = new JPanel();
        buttonArea.setLayout(new GridLayout(1, 2));
        contentPane.add(buttonArea, BorderLayout.SOUTH);
        
        submit = new JButton(lName);
        submit.addActionListener(this::ActionHandler);
        changeView = new JButton(rName);
        changeView.addActionListener(this::ActionHandler);
        
        buttonArea.add(submit);
        buttonArea.add(changeView);
    }

    public void ActionHandler(ActionEvent ae)
    {
        String nameIn = name.getText();
        String pwdIN = pwd.getText();
        
        if (ae.getActionCommand().equals("submit")) { 

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
        else if (ae.getActionCommand().equals("Change View")) {
        	ViewSelectorController controller = new ViewSelectorController();
        	controller.setVisible(true);
        	this.dispose();
        }
    }

    public static void main(String[] args)
    {
       UserController controller = new UserController();
       controller.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       controller.setVisible(true);
    }

}
