//package com.lastname.pharma;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//public class DoctorGui {
//
//
//    public class DoctorGUI extends JFrame {
//        public DoctorGUI() {
//            setTitle("Doctor Panel");
//            setSize(400, 300);
//            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//            // Create components
//            JLabel titleLabel = new JLabel("Doctor Panel");
//            JTextField searchField = new JTextField(20);
//            JButton searchButton = new JButton("Search");
//
//            // Layout
//            setLayout(new BorderLayout());
//
//            JPanel panel = new JPanel();
//            panel.setLayout(new FlowLayout());
//            panel.add(titleLabel);
//            panel.add(searchField);
//            panel.add(searchButton);
//
//            add(panel, BorderLayout.CENTER);
//
//            // Action listeners
//            searchButton.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    String searchTerm = searchField.getText();
//                    // Implement the logic to search for drugs here
//                    JOptionPane.showMessageDialog(null, "Searching for: " + searchTerm);
//                }
//            });
//        }
//
//        public static void main(String[] args) {
//            SwingUtilities.invokeLater(() -> {
//                DoctorGUI doctorGUI = new DoctorGUI();
//                doctorGUI.setVisible(true);
//            });
//        }
//    }
//
//}
