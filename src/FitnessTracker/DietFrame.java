package FitnessTracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class DietFrame extends JFrame implements ActionListener {
    Container container = getContentPane();
    private JComboBox<String> foodChoices; 
    private JButton submitButton, addButton, backButton, changeGoals;
    private User user;
    private ArrayList<User> userList;

    public DietFrame(User user, ArrayList<User> userList) {
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
        foodChoices = new JComboBox<String>(user.getFoodNames().toArray(new String[0]));
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        addButton = new JButton("Add new food");
        addButton.addActionListener(this);
        backButton = new JButton("Back");
        backButton.addActionListener(this);
        changeGoals = new JButton("Change Calories/Protein Goals");
        changeGoals.addActionListener(this);
    }
 
    public void setLocationAndSize() {
        foodChoices.setBounds(10, 20, 250, 25);
        submitButton.setBounds(10, 50, 250, 25);
        addButton.setBounds(10, 80, 250, 25);
        changeGoals.setBounds(10, 110, 250, 25);
        backButton.setBounds(10, 170, 250, 25);
    }
 
    public void addComponentsToContainer() {
        container.add(foodChoices);
        container.add(submitButton);
        container.add(addButton);
        container.add(backButton);  
        container.add(changeGoals);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            addNewFood();
        }
        else if (e.getSource() == submitButton) {
            addConsumedFood();
        }
        else if (e.getSource() == changeGoals) {
            changeGoalsExecute();
        }
        else {
            backExecute();
        }
    }

    public void addNewFood() {
        this.dispose();
        FoodFrame frame = new FoodFrame(user, userList);
        frame.setTitle("Add new food");
        frame.setVisible(true);
        frame.setSize(300,250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

    public void addConsumedFood() {
        if (foodChoices.getSelectedItem() != null)
            user.consumedFood(foodChoices.getSelectedItem().toString());
    }

    public void changeGoalsExecute() {
        this.dispose();
        GoalFrame frame = new GoalFrame(user, userList);
        frame.setTitle("Goals");
        frame.setVisible(true);
        frame.setSize(300,250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

    public void backExecute() {
        this.dispose();
        UserFrame frame = new UserFrame(user, userList);
        frame.setTitle(user.getName());
        frame.setVisible(true);
        frame.setSize(300,250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}