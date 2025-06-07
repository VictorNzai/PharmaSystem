package com.musembi.pharma;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class PharmacistLogin extends JFrame{
    private JTextField textUsername;
    private JPasswordField passwordText;
    private JButton loginButton;
    private JButton backButton;
    private JPanel PharmaLogin;

    public PharmacistLogin() {


        setContentPane(PharmaLogin);
        setSize(700, 500);
        setVisible(true);

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
                dispose();
            }
        });
    }

    public void confirm_login() {
        String username = textUsername.getText();
        String password = String.valueOf(passwordText.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(PharmaLogin, "PLEASE FILL ALL FIELDS", "TRY AGAIN", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Connect to the database and check for the doctor's credentials
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_musembi_victor_166341", "root", "rehanais2cool");
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM tbl_pharmacist WHERE username = ? AND password = ?")) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Login successful, open the pharmacist's interface
                JOptionPane.showMessageDialog(PharmaLogin,"LOGIN SUCCESSFULLY");
                PharmacistPanel pharmacistPanel = new PharmacistPanel();
                dispose(); // Remove unnecessary dispose call
            } else {
                // Credentials do not match, prompt to register
                int choice = JOptionPane.showConfirmDialog(PharmaLogin, "Pharmacist does not exist. Do you want to register as a new Pharmacist?", "Register Pharmacist", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    RegisterPharmacist registerPharmacist =new RegisterPharmacist();
                    dispose();
                }
            }

            resultSet.close(); // Close ResultSet
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(PharmaLogin, "An error occurred while connecting to the database. Please try again later.", "Database Error", JOptionPane.ERROR_MESSAGE);
        } // Handle SQLException appropriately
    }

    public static void main(String[] args) {

        LoginForm loginForm = new LoginForm();
    }

}
