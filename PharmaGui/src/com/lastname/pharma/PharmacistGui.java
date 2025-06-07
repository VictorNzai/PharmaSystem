package com.lastname.pharma;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JFrame.*;


    public class PharmacistGui {
        public PharmacistGui() {
            // Create the main frame
            JFrame frame = new JFrame("My Pharma Company");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            // Create a panel to add components
            JPanel panel = new JPanel();
            frame.add(panel);

            // Create components
            JLabel titleLabel = new JLabel("Pharmacy Management");
            JButton pharmacistButton = new JButton("Pharmacist Panel");
            JButton doctorButton = new JButton("Doctor Panel");
            JButton patientButton = new JButton("Patient Panel");


            // Add components to the panel
            panel.setLayout(new BorderLayout());
            panel.add(titleLabel, BorderLayout.NORTH);

            // Create a subpanel for buttons
            JPanel buttonPanel = new JPanel();
            buttonPanel.add(pharmacistButton);
            buttonPanel.add(doctorButton);
            buttonPanel.add(patientButton);

            panel.add(buttonPanel, BorderLayout.CENTER);

            // Action listeners for buttons
            pharmacistButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Implement the logic to add stock here
                    JOptionPane.showMessageDialog(frame, "Pharmacist Panel");
                }
            });

            doctorButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Implement Doctor GUI functionality
                    // Create a new Doctor panel
                    createDoctorPanel();
                }
            });
            patientButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Implement Patient GUI functionality
                    JOptionPane.showMessageDialog(frame, "Patient Panel");
                }
            });

            // Display the frame
            frame.setVisible(true);
        }

        private void createDoctorPanel() {
            // Create a new panel for the Doctor
            JFrame doctorFrame = new JFrame("Doctor Panel");
            doctorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close the doctor panel without closing the entire app
            doctorFrame.setSize(400, 300);

            // Create components for the Doctor panel
            JLabel doctorLabel = new JLabel("Doctor Panel");
            JTextField searchField = new JTextField(20);
            JButton searchButton = new JButton("Search for Drugs");

            // Create a panel for Doctor components
            JPanel doctorPanel = new JPanel();
            doctorPanel.setLayout(new FlowLayout());
            doctorPanel.add(doctorLabel);
            doctorPanel.add(searchField);
            doctorPanel.add(searchButton);

            doctorFrame.add(doctorPanel);
            doctorFrame.setVisible(true);

            // Action listener for the Doctor's search button
            searchButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String searchTerm = searchField.getText();
                    // Implement logic to search for drugs and prescribe here
                    JOptionPane.showMessageDialog(doctorFrame, "Searching for drugs: " + searchTerm);
                }
            });
        }

        private void createPatientPanel() {
            // Create a new panel for the Patient
            JFrame patientFrame = new JFrame("Patient Panel");
            patientFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close the patient panel without closing the entire app
            patientFrame.setSize(400, 300);

            // Create components for the Patient panel
            JLabel patientLabel = new JLabel("Patient Panel");
            JButton buyDrugsButton = new JButton("Buy Prescribed Drugs");

            // Create a panel for Patient components
            JPanel patientPanel = new JPanel();
            patientPanel.setLayout(new FlowLayout());
            patientPanel.add(patientLabel);
            patientPanel.add(buyDrugsButton);
            patientFrame.add(patientPanel);
            patientFrame.setVisible(true);

            // Action listener for the Patient's buy drugs button
            buyDrugsButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Implement logic to buy prescribed drugs
                    JOptionPane.showMessageDialog(patientFrame, "Buying prescribed drugs...");
                }
            });
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                PharmacistGui pharmacistGui = new PharmacistGui();
            });
        }
    }








