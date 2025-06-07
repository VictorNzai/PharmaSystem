package com.musembi.pharma;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AddNewStock extends JFrame {
    private JTextField DrugName;
    private JTextField QuantityField;
    private JButton addStockButton;
    private JTextField yyyyMmDdTextField;
    private JPanel AddDrugsPanel;
    private JTextField pricefield;
    private JButton backButton;

    public AddNewStock() {
        setContentPane(AddDrugsPanel);
        setSize(700, 500);
        setVisible(true);

        addStockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStockToDatabase();
                dispose();
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PharmacistPanel pharmacistPanel =new PharmacistPanel();
                dispose();
            }
        });
    }

    public void addStockToDatabase() {
        String drugName = DrugName.getText();
        int quantity = Integer.parseInt(QuantityField.getText());
        String expiryDate = yyyyMmDdTextField.getText();
        int price = Integer.parseInt(pricefield.getText());


        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_musembi_victor_166341", "root", "rehanais2cool")) {
            String sql = "INSERT INTO tbl_drugs(drugName,expiryDate,quantity,price) VALUES(?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, drugName);
            preparedStatement.setString(2, expiryDate);
            preparedStatement.setInt(3, quantity);
            preparedStatement.setInt(4,price);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(AddDrugsPanel, "Stock added successfully");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(AddDrugsPanel, "Error: Failed to add stock to the database");
            ex.printStackTrace();
        }
    }


    public static void main(String[] args) {
        AddNewStock gui = new AddNewStock();
    }
}


