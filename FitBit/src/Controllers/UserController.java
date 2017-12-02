/* Name: Team BitFit
 * Class: UserController.java
 * 
 * Functions as Controller for UserLogin menu; creates layout, Model and View,
 * dictates behavior of layout objects.
 */

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
    	
    	// create GUI info for user login
        contentPane = getContentPane();
        setSize(600, 600);
        setTitle("Welcome!");

        // create layout objects and add them to JPanel area
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

        // create UserLogin Model and View for display
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

    // behavior of layout objects
    public void ActionHandler(ActionEvent ae)
    {
        String nameIn = name.getText();
        String pwdIN = pwd.getText();
        
        // if "Submit" button is pressed
        if (ae.getActionCommand().equals("submit")) { 

        	// set name and password if correct; repaint and update View
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
        // if "Change View" button is pressed, create ViewSelector window, close UserLogin window
        else if (ae.getActionCommand().equals("Change View")) {
        	ViewSelectorController controller = new ViewSelectorController();
        	controller.setVisible(true);
        	this.dispose();
        }
    }

    // creation of UserController and display
    public static void main(String[] args)
    {
       UserController controller = new UserController();
       controller.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       controller.setVisible(true);
    }

}
