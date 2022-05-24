package FitnessTracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GoalFrame extends JFrame implements ActionListener {
    Container container = getContentPane();
    private JButton calorieButton, proteinButton, backButton;
    private JLabel calorieLabel, proteinLabel, error;
    private JTextField calorieText, proteinText;
    private User user;
    private ArrayList<User> userList;

    public GoalFrame(User user, ArrayList<User> userList) {
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
        calorieLabel = new JLabel("Calorie goal");
        proteinLabel = new JLabel("Protein goal");
        error = new JLabel("");

        calorieText = new JTextField(20);
        proteinText = new JTextField(20);

        calorieButton = new JButton("Submit new calorie goal");
        proteinButton = new JButton("Submit new protein goal");
        backButton = new JButton("Back");
        
        calorieButton.addActionListener(this);
        proteinButton.addActionListener(this);
        backButton.addActionListener(this);
    }

    public void setLocationAndSize() {
        calorieLabel.setBounds(10, 20, 80, 25);
        calorieText.setBounds(100, 20, 165, 25);

        calorieButton.setBounds(10, 50, 250, 25);

        proteinLabel.setBounds(10, 80, 80, 25);
        proteinText.setBounds(100, 80, 165, 25);

        proteinButton.setBounds(10, 110, 250, 25);

        error.setBounds(10, 140, 250, 25);

        backButton.setBounds(10, 170, 250, 25);
    }

    public void addComponentsToContainer() {
        container.add(calorieLabel);
        container.add(proteinLabel);
        container.add(error);
        container.add(calorieText);
        container.add(proteinText);
        container.add(calorieButton);
        container.add(proteinButton);
        container.add(backButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calorieButton) {
            if (calorieText.getText().matches("[0-9]+")) {
                user.setCalorieGoal(Integer.parseInt(calorieText.getText()));
            }
            else {
                error.setText("Calorie goal can only contain integers");
            }
        }
        else if (e.getSource() == proteinButton) {
            if (proteinText.getText().matches("[0-9]+")) {
                user.setProteinGoal(Integer.parseInt(proteinText.getText()));
            }
            else {
                error.setText("Protein goal can only contain integers");
            }
        }
        else {
            this.dispose();
            DietFrame frame = new DietFrame(user, userList);
            frame.setTitle("Diet");
            frame.setVisible(true);
            frame.setSize(300,250);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
        }
    }
}
