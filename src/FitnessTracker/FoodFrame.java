package FitnessTracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class FoodFrame extends JFrame implements ActionListener {
    Container container = getContentPane();
    private JButton submitButton, cancelButton;
    private JLabel nameLabel, calorieLabel, proteinLabel, error;
    private JTextField nameText, calorieText, proteinText;
    private User user;
    private ArrayList<User> userList;

    public FoodFrame(User user, ArrayList<User> userList) {
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
        nameLabel = new JLabel("Food name");
        calorieLabel = new JLabel("Calories");
        proteinLabel = new JLabel("Protien");
        error = new JLabel("");
        nameText = new JTextField(20);
        calorieText = new JTextField(20);
        proteinText = new JTextField(20);
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(this);
    }
 
    public void setLocationAndSize() {
        nameLabel.setBounds(10, 20, 80, 25);
        nameText.setBounds(100, 20, 165, 25);
        calorieLabel.setBounds(10, 50, 80, 25);
        calorieText.setBounds(100, 50, 165, 25);
        proteinLabel.setBounds(10, 80, 80, 25);
        proteinText.setBounds(100, 80, 165, 25);
        error.setBounds(10,110,300,25);
        submitButton.setBounds(10, 140, 250, 25);
        cancelButton.setBounds(10, 170, 250, 25);
    }
 
    public void addComponentsToContainer() {
        container.add(nameLabel);
        container.add(nameText);
        container.add(calorieLabel);
        container.add(calorieText);
        container.add(proteinLabel);
        container.add(proteinText);
        container.add(error);
        container.add(submitButton);
        container.add(cancelButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            submitExecute();
        }
        else {
            cancelExecute();
        }
    }

    public void submitExecute() {
        String name = nameText.getText();
        if (calorieText.getText().matches("[0-9]+") && proteinText.getText().matches("[0-9]+")) {
            int calories = Integer.parseInt(calorieText.getText());
            int protein = Integer.parseInt(proteinText.getText());
            if (user.foodExists(name)) {
                error.setText("Food with given name already exists");
            }
            else {
                user.addFood(new Food(name, calories, protein));
                this.dispose();
                DietFrame frame = new DietFrame(user, userList);
                frame.setTitle("Diet");
                frame.setVisible(true);
                frame.setSize(300,250);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
            }
        }
        else {
            error.setText("Calories and protein can only contain integers");
        }
    }

    public void cancelExecute() {
        this.dispose();
        DietFrame frame = new DietFrame(user, userList);
        frame.setTitle("Diet");
        frame.setVisible(true);
        frame.setSize(300,250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}