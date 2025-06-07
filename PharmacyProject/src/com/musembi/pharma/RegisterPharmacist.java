package com.musembi.pharma;

import javax.swing.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterPharmacist extends JFrame {
    private JTextField UsernameField1;
    private JPasswordField passwordTextField1;
    private JButton registerButton;
    private JButton backButton;
    private JPanel RegisterPharmacist;

    public RegisterPharmacist() {

        setContentPane(RegisterPharmacist);
        setSize(700, 500);
        setVisible(true);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerPharmacistToDatabase();

            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PharmacistLogin pharmacistLogin = new PharmacistLogin();
                dispose();
            }
        });
    }
    public void registerPharmacistToDatabase() {

        String usernameInput = UsernameField1.getText();
        String passwordField = passwordTextField1.getText();

        if (usernameInput.isEmpty() || passwordField.isEmpty()) {
            JOptionPane.showMessageDialog(RegisterPharmacist, "Please fill in both username and password fields.");
            return;

        }
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_musembi_victor_166341", "root", "rehanais2cool")) {
            String sql = "INSERT INTO tbl_pharmacist(username,password) VALUES(?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, usernameInput);
            preparedStatement.setString(2, passwordField);


            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(RegisterPharmacist, "Pharmacist's details added successfully");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(RegisterPharmacist, "Error: Failed to add doctor to the database");
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        RegisterPharmacist Gui = new RegisterPharmacist();
    }
}
