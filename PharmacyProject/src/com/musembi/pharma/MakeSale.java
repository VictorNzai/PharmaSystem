//package com.musembi.pharma;
//
//    import java.sql.*;
//    import javax.swing.*;
//    import java.awt.event.ActionEvent;
//    import java.awt.event.ActionListener;
//
//public class MakeSale extends JFrame {
//
//
//    private JTextField PatientIdTextField;
//    private JButton executeButton;
//    private JButton backButton;
//    private JPanel MakeSale;
//    private JTable patientTable;
//
//    public MakeSale() {
//
//        setContentPane(MakeSale);
//        setSize(700, 500);
//        setVisible(true);
//
//        executeButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e){
//                sellDrugs();
//            }
//
//        });
//        backButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                PharmacistPanel pharmacistPanel = new PharmacistPanel();
//                dispose();
//            }
//        });
//    }
//    private void sellDrugs() {
//        int selectedRowIndex = MakeSale.getSelectedRow();
//
//        // Check if any row is selected
//        if (selectedRowIndex == -1) {
//            JOptionPane.showMessageDialog(null, "Please select a patient");
//            return;
//        }
//
//        // Retrieve data from the selected row
//        int patientNumber = (int) MakeSale.getValueAt(selectedRowIndex, 0);
//        String patientFirstName = (String) patientTable.getValueAt(selectedRowIndex, 1);
//        String patientLastName = (String) patientTable.getValueAt(selectedRowIndex, 2);
//        String drugName = (String) patientTable.getValueAt(selectedRowIndex, 3);
//        int prescription = (int) patientTable.getValueAt(selectedRowIndex, 4);
//
//        try {
//            // Your existing code continues from here...
//            final String DB_URL = "jdbc:mysql://localhost:3306/db_musembi_victor_166341";
//            final String user = "root";
//            final String password = "rehanais2cool";
//
//            Connection connection = DriverManager.getConnection(DB_URL, user, password);
//
//            // No need to retrieve patient details again since you already have them from the selected row
//            // Step 2: Update drug quantities in tbl_drugs
//            String updateDrugQuantityQuery = "UPDATE tbl_drugs SET quantity = quantity - ? WHERE drugName = ?";
//            PreparedStatement updateDrugQuantityStatement = connection.prepareStatement(updateDrugQuantityQuery);
//            updateDrugQuantityStatement.setInt(1, prescription);
//            updateDrugQuantityStatement.setString(2, drugName);
//
//            int rowsUpdated = updateDrugQuantityStatement.executeUpdate();
//
//            if (rowsUpdated <= 0) {
//                JOptionPane.showMessageDialog(null, "Failed to update drug quantity");
//                return;
//            }
//
//            // Retrieve unit price from tbl_drugs
//            String retrieveUnitPriceQuery = "SELECT unitPrice FROM tbl_drugs WHERE drugName = ?";
//            PreparedStatement retrieveUnitPriceStatement = connection.prepareStatement(retrieveUnitPriceQuery);
//            retrieveUnitPriceStatement.setString(1, drugName);
//
//            ResultSet unitPriceResultSet = retrieveUnitPriceStatement.executeQuery();
//            if (!unitPriceResultSet.next()) {
//                JOptionPane.showMessageDialog(null, "Unit price not found for the drug");
//                return;
//            }
//
//            int unitPrice = unitPriceResultSet.getInt("unitPrice");
//            int totalPrice = prescription * unitPrice;
//
//            // Step 4: Insert purchase details into tbl_purchases
//            String insertPurchaseQuery = "INSERT INTO tbl_purchases (patientNumber, Fname, drugName, totalPrice) VALUES (?, ?, ?, ?)";
//            PreparedStatement insertPurchaseStatement = connection.prepareStatement(insertPurchaseQuery);
//            insertPurchaseStatement.setInt(1, patientNumber);
//            insertPurchaseStatement.setString(2, patientFirstName);
//            insertPurchaseStatement.setString(3, drugName);
//            insertPurchaseStatement.setInt(4, totalPrice);
//
//            int rowsInserted = insertPurchaseStatement.executeUpdate();
//
//            if (rowsInserted <= 0) {
//                JOptionPane.showMessageDialog(null, "Failed to insert purchase details");
//                return;
//            }
//
//            // Step 5: Delete patient details from tbl_patient
//            String deletePatientQuery = "DELETE FROM tbl_patient WHERE patientNumber = ?";
//            PreparedStatement deletePatientStatement = connection.prepareStatement(deletePatientQuery);
//            deletePatientStatement.setInt(1, patientNumber);
//
//            int rowsDeleted = deletePatientStatement.executeUpdate();
//            if (rowsDeleted <= 0) {
//                JOptionPane.showMessageDialog(null, "Failed to delete patient details");
//                return;
//            }
//
//            String msg = "Patient id: " + patientNumber + " ,patient name: " + patientFirstName + " ,total price: " + totalPrice;
//            JOptionPane.showMessageDialog(null, "Sale completed successfully!");
//            populatePatientTable();  // Update the patient table after the sale
//            displayPatientTable(); // Display the purchases table
//
//            unitPriceResultSet.close();
//            retrieveUnitPriceStatement.close();
//            connection.close();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//}
//}
//        }
