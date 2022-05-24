package FitnessTracker;

import java.util.ArrayList;
import javax.swing.*;

public class Login {
    public static void main(String[] args) {
        ArrayList<User> userList = new ArrayList<User>();
        LoginFrame frame = new LoginFrame(userList);
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setSize(300,250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}
