package FitnessTracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class UserFrame extends JFrame implements ActionListener {
    Container container = getContentPane();
    private JLabel caloriesProgress, proteinProgress;
    private JButton dietButton, logoutButton;
    private User user;
    private ArrayList<User> userList;

    public UserFrame(User user, ArrayList<User> userList) {
        this.user = user;
        this.userList = userList;
        setLayoutManager();
        setInitialValues();
        setLocationAndSize();
        addComponentsToContainer();
    }
    
    public void setLayoutManager() {
        //Setting layout manager of Container to null
        container.setLayout(null);
    }
 
    public void setInitialValues() {
        caloriesProgress = new JLabel("Consumed: " + user.getTotalCalories() + "/" + user.getCalorieGoal() + " calories.");
        proteinProgress = new JLabel("Consumed: " + user.getTotalProtein() + "/" + user.getProteinGoal() + " protein.");
       
        dietButton = new JButton("Diet");
        logoutButton = new JButton("Logout");

        dietButton.addActionListener(this);
        logoutButton.addActionListener(this);
    }
 
    public void setLocationAndSize() {
        dietButton.setBounds(10, 20, 250, 25);
        caloriesProgress.setBounds(10, 50, 250, 25);
        proteinProgress.setBounds(10, 80, 250, 25);
        logoutButton.setBounds(10, 170, 250, 25);
    }
 
    public void addComponentsToContainer() {;
        container.add(caloriesProgress);
        container.add(proteinProgress);
        container.add(dietButton);
        container.add(logoutButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Logout
        if (e.getSource() == logoutButton) {
            logoutExecute();
        }
        else {
            dietExecute();
        }
    }

    public void logoutExecute() {
        this.setVisible(false);
        LoginFrame frame = new LoginFrame(userList);
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setSize(300,250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

    public void dietExecute() {
        this.dispose();
        DietFrame frame = new DietFrame(user, userList);
        frame.setTitle("Diet");
        frame.setVisible(true);
        frame.setSize(300,250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}
