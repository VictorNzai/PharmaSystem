package com.musembi.pharma;

//Nzai Victor Musembi
//166341
//ICS A

 import   java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pharmacist {

    private JFrame frame;
    private JTextField drugNameField, quantityField, expiryDateField;


    public Pharmacist() {
        frame = new JFrame("Pharmacist GUI");
        frame.setSize(200, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel drugNameLabel = new JLabel("Drug Name:");
        drugNameField = new JTextField();

        JLabel quantityLabel = new JLabel("Quantity:");
        quantityField = new JTextField();

        JLabel expiryDateLabel = new JLabel("Expiry Date:");
        expiryDateField = new JTextField();

        JButton addButton = new JButton("Add Stock");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addStock();
            }
        });



        panel.add(drugNameLabel);
        panel.add(drugNameField);
        panel.add(quantityLabel);
        panel.add(quantityField);
        panel.add(expiryDateLabel);
        panel.add(expiryDateField);
        panel.add(addButton);


        frame.add(panel);
        frame.setVisible(true);
    }

    private void addStock() {
        String drugName = drugNameField.getText();
        int quantity = Integer.parseInt(quantityField.getText());
        String expiryDate = expiryDateField.getText();




    }

    public static void main(String[] args) {
        new Pharmacist();
    }
}