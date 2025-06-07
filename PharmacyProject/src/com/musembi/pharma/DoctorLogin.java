package com.musembi.pharma;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DoctorLogin extends JFrame {
    private JTextField textusername;
    private JPasswordField textpassword;
    private JButton loginButton;
    private JButton backButton;
    private JButton registerButton;
    private JPanel DoctorLogin;

    public DoctorLogin() {

        setContentPane(DoctorLogin);
        setSize(700, 500);
        setVisible(true);

        // Registering listeners
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                confirm_login();
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                LoginForm loginForm = new LoginForm();
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        //backButton.addActionListener(new ActionListener() {
       // });
    }

    public void confirm_login() {
        String username = textusername.getText();
        String password = String.valueOf(textpassword.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(DoctorLogin, "PLEASE FILL ALL FIELDS", "TRY AGAIN", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Connect to the database and check for the doctor's credentials
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_musembi_victor_166341", "root", "rehanais2cool");
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM tbl_doctor WHERE username = ? AND password = ?")) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);


            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Login successful, open the doctor's interface
                JOptionPane.showMessageDialog(DoctorLogin,"LOGIN SUCCESSFULLY");
                DoctorPanel doctorPanel =new DoctorPanel();
                dispose(); // Remove unnecessary dispose call
            } else {
                // Credentials do not match, prompt to register
                int choice = JOptionPane.showConfirmDialog(DoctorLogin, "Doctor does not exist. Do you want to register as a new Doctor?", "Register Doctor", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    RegisterDoctor registerDoctor =new RegisterDoctor();
                    dispose();
                }
            }

            resultSet.close(); // Close ResultSet
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(DoctorLogin, "An error occurred while connecting to the database. Please try again later.", "Database Error", JOptionPane.ERROR_MESSAGE);
        } // Handle SQLException appropriately
    }

    public static void main(String[] args) {

        LoginForm Gui = new LoginForm();
    }


}
