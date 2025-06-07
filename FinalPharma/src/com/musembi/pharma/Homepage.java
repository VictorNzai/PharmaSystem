package com.musembi.pharma;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Homepage extends JFrame {

    public Homepage() {
        JLabel title = new JLabel("Welcome to our Healthcare Platform");
        JLabel rolePrompt = new JLabel("Please choose your role:");

        JRadioButton doctorRadioButton = new JRadioButton("Login as a Doctor");
        JRadioButton pharmacistRadioButton = new JRadioButton("Login as a Pharmacist");
        ButtonGroup buttonGroup = new ButtonGroup();

        buttonGroup.add(doctorRadioButton);
        buttonGroup.add(pharmacistRadioButton);
        JButton loginButton = new JButton("Login");



        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check which radio button is selected
                if (doctorRadioButton.isSelected()) {
                    // Show a message dialog indicating that the user has chosen to login as a doctor
                    JOptionPane.showMessageDialog(null, "You have chosen to login as a doctor.");
                } else if (pharmacistRadioButton.isSelected()) {
                    // Show a message dialog indicating that the user has chosen to login as a pharmacist
                    JOptionPane.showMessageDialog(null, "You have chosen to login as a pharmacist.");
                } else {
                    // Show a message dialog indicating that the user must choose a role
                    JOptionPane.showMessageDialog(null, "Please choose a role before logging in.");
                }
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (doctorRadioButton.isSelected()) {
                    showDetailsDialog("Doctor");
                } else if (pharmacistRadioButton.isSelected()) {
                    showDetailsDialog("Pharmacist");
                } else {
                    JOptionPane.showMessageDialog(null, "Please choose a role before logging in.");
                }
            }
        });
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));
        panel.add(title);
        panel.add(rolePrompt);
        panel.add(doctorRadioButton);
        panel.add(pharmacistRadioButton);
        panel.add(loginButton);
        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setResizable(true);
    }

    private void showDetailsDialog(String role) {
        JPanel detailsPanel = new JPanel();
        detailsPanel.add(new JLabel("Username:"));
        detailsPanel.add(new JTextField());
        detailsPanel.add(new JLabel("Password:"));
        detailsPanel.add(new JPasswordField());

        int result = JOptionPane.showConfirmDialog(null, detailsPanel, "Enter " + role + " Details", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Successfully logged in as a " + role + ".");
        } else {
            JOptionPane.showMessageDialog(null, "Login cancelled.");
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Homepage().setVisible(true);
            }
        });
    }
}

class DoctorDashboard extends JFrame {

    public DoctorDashboard() {
        JLabel welcomeLabel = new JLabel("Welcome, Doctor!");
        JLabel searchPrompt = new JLabel("Enter the name of the drug you want to search for:");
        JTextField searchTextField = new JTextField();
        JButton searchButton = new JButton("Search");

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String drugName = searchTextField.getText();
                JOptionPane.showMessageDialog(null, "Searching for " + drugName + " ...");
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));
        panel.add(welcomeLabel);
        panel.add(searchPrompt);
        panel.add(searchTextField);
        panel.add(searchButton);
        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setResizable(true);
    }
    private void showDetailsDialog(String role) {
        JPanel detailsPanel = new JPanel(new GridLayout(2, 2));

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(200, 30)); // Set the preferred width

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(200, 30)); // Set the preferred width

        detailsPanel.add(usernameLabel);
        detailsPanel.add(usernameField);
        detailsPanel.add(passwordLabel);
        detailsPanel.add(passwordField);

        int result = JOptionPane.showConfirmDialog(null, detailsPanel, "Enter " + role + " Details", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Successfully logged in as a " + role + ".");
        } else {
            JOptionPane.showMessageDialog(null, "Login cancelled.");
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DoctorDashboard().setVisible(true);
            }
        });
    }
}

