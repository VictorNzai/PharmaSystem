package com.musembi.pharma;


//Nzai Victor Musembi
//166341
//ICS A


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class Doctor {

        private JFrame frame;
        private JTextField drugNameField;
        private JTextArea resultArea;

        public Doctor() {
            frame = new JFrame("Doctor GUI");
            frame.setSize(300, 200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(2, 2));

            JLabel drugNameLabel = new JLabel("Drug Name:");
            drugNameLabel.setSize(50, 100);
            drugNameField = new JTextField();

            JButton searchButton = new JButton("Search");

            searchButton.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {

                    searchDrug();
                }
            });

            resultArea = new JTextArea();
            resultArea.setEditable(false);
            resultArea.setLineWrap(true);

            panel.add(drugNameLabel);
            panel.add(drugNameField);
            panel.add(searchButton);

            frame.add(panel, BorderLayout.NORTH);
            frame.add(new JScrollPane(resultArea), BorderLayout.CENTER);
            frame.setVisible(true);
        }

        private void searchDrug() {
            String drugName = drugNameField.getText();

            // Add code to handle searching for drugs in the database
            // For example, you can use DatabaseManager class

            // Display results in the resultArea
            resultArea.setText("Search results for " + drugName + ":\n");
            resultArea.append("Drug 1\n");
            resultArea.append("Drug 2\n");
            // Add more results as needed
        }

        public static void main(String[] args) {
            new Doctor();
        }
    }


