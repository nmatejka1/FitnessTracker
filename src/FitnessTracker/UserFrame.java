package FitnessTracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class UserFrame extends JFrame implements ActionListener {
    Container container = getContentPane();
    private JLabel workoutsCompleted, caloriesProgress, proteinProgress;
    private JButton workoutButton, dietButton, logoutButton;
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
        workoutsCompleted = new JLabel("Exercises completed: ");
        caloriesProgress = new JLabel("Consumed: " + user.getTotalCalories() + "/" + user.getCalorieGoal() + " calories.");
        proteinProgress = new JLabel("Consumed: " + user.getTotalProtein() + "/" + user.getProteinGoal() + " protein.");
        workoutButton = new JButton("Workouts");
        workoutButton.addActionListener(this);
        dietButton = new JButton("Diet");
        dietButton.addActionListener(this);
        logoutButton = new JButton("Logout");
        logoutButton.addActionListener(this);
    }
 
    public void setLocationAndSize() {
        workoutButton.setBounds(10, 20, 250, 25);
        workoutsCompleted.setBounds(10, 50, 250, 25);
        dietButton.setBounds(10, 80, 250, 25);
        caloriesProgress.setBounds(10, 110, 250, 25);
        proteinProgress.setBounds(10, 140, 250, 25);
        logoutButton.setBounds(10, 170, 250, 25);
    }
 
    public void addComponentsToContainer() {
        container.add(workoutButton);
        container.add(workoutsCompleted);
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

        else if (e.getSource() == workoutButton) {

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
