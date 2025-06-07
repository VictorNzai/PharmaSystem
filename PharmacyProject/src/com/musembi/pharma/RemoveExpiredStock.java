package com.musembi.pharma;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class RemoveExpiredStock extends JFrame {

    private JPanel Expired;
    private JButton showExpiredDrugsButton;
    private JButton removeExpiredDrugsButton;

    public RemoveExpiredStock () {

        setContentPane(Expired);
        setSize(700, 500);
        setVisible(true);



        removeExpiredDrugsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeExpiredDrugsFromDatabase();
            }
        });
        showExpiredDrugsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showExpiredDrugs();
            }
        });
    }

    public void showExpiredDrugs() {
        // SQLite database URL
        boolean hasExpiredDrugs = false;

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_musembi_victor_166341","root","rehanais2cool")) {
            String sql = "SELECT * FROM tbl_drugs WHERE expiryDate < CURDATE()";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            StringBuilder expiredDrugs = new StringBuilder();
            while (resultSet.next()) {
                hasExpiredDrugs = true;
                expiredDrugs.append("drugName: ").append(resultSet.getString("drugName")).append(" expiryDate: ").append(resultSet.getString("expiryDate")).append("price: ").append(resultSet.getString("price")).append("quantity: ").append(resultSet.getString("quantity"));
            }

            if (hasExpiredDrugs) {
                JOptionPane.showMessageDialog(Expired, expiredDrugs.toString(), "Expired Drugs", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(Expired, "No expired drugs found.", "Expired Drugs", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(Expired, "Error: Failed to retrieve expired drugs from the database");
            ex.printStackTrace();
        }
    }
//    private void removeExpiredStockFromDatabase() {
//        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_eugene_mogeni_15342", "root", "Connection123")) {
//            String sql = "DELETE FROM tbl_drug WHERE Date_of_expiry < CURDATE()";
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//
//            int rowsAffected = preparedStatement.executeUpdate();
//
//            if (rowsAffected > 0) {
//                JOptionPane.showMessageDialog(PharmaPanel, "Expired stock removed successfully");
//            } else {
//                JOptionPane.showMessageDialog(PharmaPanel, "No expired stock to remove");
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(PharmaPanel, "Error: Failed to remove expired stock from the database");
//            ex.printStackTrace();
//}
//
    public void removeExpiredDrugsFromDatabase() {
                try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_musembi_victor_166341", "root", "rehanais2cool")) {
//            String sql = "SELECT * FROM tbl_drugs WHERE DATE(expiryDate) <= ?";
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement
//            ResultSet resultSet = preparedStatement.executeQuery();
//           String expiryDate = resultSet.yyyyMmDdText("Expiry Date");


                String removeExpiredDrugSql = "DELETE FROM tbl_drugs WHERE expiryDate  < CURDATE()";
                PreparedStatement removeExpiredDrugPreparedStatement = connection.prepareStatement(removeExpiredDrugSql);


                int rowsAffected = removeExpiredDrugPreparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(Expired, "Expired stock removed successfully");
                }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(Expired, "Error: Failed to remove expired stock from the database");
            ex.printStackTrace();
        }
    }
}


