package FitnessTracker;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class LoginFrame extends JFrame implements ActionListener {
    Container container = getContentPane();
    private JLabel usernameLabel, passwordLabel;
    private JTextField usernameText;
    private JPasswordField passwordText;
    private JButton loginButton, createButton;
    private JLabel error;
    private ArrayList<User> userList;

    LoginFrame(ArrayList<User> userList) {
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
        usernameLabel = new JLabel("Username");
        passwordLabel = new JLabel("Password");
        error = new JLabel("");

        usernameText = new JTextField(20);
        passwordText = new JPasswordField(20);

        loginButton = new JButton("Login");
        createButton = new JButton("Create Account");

        loginButton.addActionListener(this);
        createButton.addActionListener(this);
    }

    public void setLocationAndSize() {
        usernameLabel.setBounds(10, 20, 80, 25);
        passwordLabel.setBounds(10, 50, 80, 25);
        usernameText.setBounds(100, 20, 165, 25);
        passwordText.setBounds(100, 50, 165, 25);
        loginButton.setBounds(10, 80, 250, 25);
        createButton.setBounds(10, 110, 250, 25);
        error.setBounds(10,140,300,25);
    }

    public void addComponentsToContainer() {
        container.add(usernameLabel);
        container.add(passwordLabel);
        container.add(usernameText);
        container.add(passwordText);
        container.add(loginButton);
        container.add(createButton);
        container.add(error);
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usernameText.getText();
        String password = passwordText.getText();
        User user = checkUserExists(username);
        // USER EXISTS IN NETWORK
        if (user != null) {
            // LOGGING IN; CHECK PASSWORD
            if(e.getSource() == loginButton) {
                // CHECK PASSWORD
                if (user.getPassword().equals(password)) {
                    // SUCCESS
                    changeScreens(user);
                }
                else {
                    // FAILURE
                    error.setText("Incorrect password");
                }
            }
            // CREATING ACCOUNT; THROW ERROR, ACCOUNT ALREADY EXISTS
            else {
                error.setText("User: " + username + " already exists");
            }
        }
        else {
            // LOGGING IN; THROW ERROR, ACCOUNT DOESN'T EXIST
            if(e.getSource() == loginButton) {
                error.setText("No account exists with that username");
            }
            // CREATING ACCOUNT
            else {
                userList.add(new User(username, password));
                error.setText("Account created, please login to continue.");
                usernameText.setText("");
                passwordText.setText("");
            }
        }
    }

    // CHECKS IF USER EXISTS IN ARRAY LIST
    public User checkUserExists(String name) {
        if (userList.size() == 0) {
            return null;
        }
    
        for (User user : userList) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public void changeScreens(User user) {
        this.dispose();
        UserFrame frame = new UserFrame(user, userList);
        frame.setTitle(user.getName());
        frame.setVisible(true);
        frame.setSize(300,250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}
