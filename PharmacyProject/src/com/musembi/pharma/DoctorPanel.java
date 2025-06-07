package com.musembi.pharma;

    import java.sql.*;
    import javax.swing.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.sql.SQLException;

public class DoctorPanel extends JFrame {

    private JPanel DoctorPanel;
    private JTextField DrugNameTextField;
    private JTextField QuantitytextField2;
    private JTextField PrescriptiontextField;
    private JTextField PatientIdtextField;
    private JTextField PatientNametextField;
    private JButton executeButton;
    private JButton backButton;
    private JComboBox drugComboBox;


    public DoctorPanel() {
        setContentPane(DoctorPanel);
        setSize(700, 500);
        fetchDrugs();
        setVisible(true);


        executeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPatientPrescriptionToDatabase();

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

    public void addPatientPrescriptionToDatabase() {

        String PatientId =PatientIdtextField.getText();
        String FullPatientName = PatientNametextField.getText();
        String DrugName =(String) drugComboBox.getSelectedItem();
        String Quantity = QuantitytextField2.getText();
        String prescription = PrescriptiontextField.getText();


        if ( PatientId.isEmpty() || FullPatientName.isEmpty()|| DrugName.isEmpty() || Quantity.isEmpty() || prescription.isEmpty() ) {
            JOptionPane.showMessageDialog(DoctorPanel, "Please fill in all fields before submitting.");
            return;

        }
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_musembi_victor_166341", "root", "rehanais2cool")) {
            String sql = "INSERT INTO tbl_patient(PatientId, FullPatientName,DrugName ,Quantity,prescription) VALUES( ? , ? , ? , ? , ? )";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {



            preparedStatement.setInt(1, Integer.parseInt(PatientId));
            preparedStatement.setString(2,FullPatientName);
            preparedStatement.setString(3, DrugName);
            preparedStatement.setInt(4, Integer.parseInt(Quantity));
            preparedStatement.setInt(5, Integer.parseInt(prescription));


            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(DoctorPanel, "Patient prescription added successfully");
            }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(DoctorPanel, "Error: Failed to add patient prescription to the database");
            ex.printStackTrace();
        }}
        private void fetchDrugs() {
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;

            try {
                // Establish a database connection
                final String DB_URL = "jdbc:mysql://localhost:3306/db_musembi_victor_166341";
                final String dbuser = "root";
                final String dbpassword = "rehanais2cool";

                connection = DriverManager.getConnection(DB_URL, dbuser, dbpassword);

                // Create a SQL query to retrieve drugs from the tbl_drugs table
                String sqlQuery = "SELECT drugName FROM tbl_drugs";
                preparedStatement = connection.prepareStatement(sqlQuery);
                resultSet = preparedStatement.executeQuery();

                // Populate the drugComboBox with the retrieved drugs
                DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
                while (resultSet.next()) {
                    model.addElement(resultSet.getString("drugName"));
                }
                drugComboBox.setModel(model);


            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // Close the resources
                try {
                    if (resultSet != null) resultSet.close();
                    if (preparedStatement != null) preparedStatement.close();
                    if (connection != null) connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }



    public static void main(String[] args) {
        DoctorPanel doctorPanel = new DoctorPanel();
    }
    }

