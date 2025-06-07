//package com.lastname.pharma;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//public class PharmacistGui  {
//
//
//    public static class PharmacistGUI extends JFrame {
//        public PharmacistGUI() {
//            setTitle("Pharmacist Panel");
//            setSize(400, 300);
//            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//            // Create components
//            JLabel titleLabel = new JLabel("Pharmacist Panel");
//            JButton addStockButton = new JButton("Add Stock");
//            JButton removeExpiredButton = new JButton("Remove Expired");
//
//            // Layout
//            setLayout(new BorderLayout());
//
//            JPanel panel = new JPanel();
//            panel.setLayout(new FlowLayout());
//            panel.add(titleLabel);
//            panel.add(addStockButton);
//            panel.add(removeExpiredButton);
//
//            add(panel, BorderLayout.CENTER);
//
//            // Action listeners
//            addStockButton.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    // Implement the logic to add stock here
//                    JOptionPane.showMessageDialog(null, "Stock added.");
//                }
//            });
//
//            removeExpiredButton.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    // Implement the logic to remove expired stock here
//                    JOptionPane.showMessageDialog(null, "Expired stock removed.");
//                }
//            });
//        }
//
//        private static void run() {
//            PharmacistGUI pharmacistGUI = new PharmacistGUI();
//            pharmacistGUI.setVisible(true);
//        }
//
//        public void main(String[] args) {
//            SwingUtilities.invokeLater(PharmacistGUI::run);
//        }
//    }
//
//}
