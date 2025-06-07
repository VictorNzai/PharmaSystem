package com.musembi.pharma;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PharmacistPanel extends JFrame {
    private JButton addNewStockButton;
    private JButton removeExpiredStockButton;
    private JPanel PharmaPanel;
    private JButton SellBtn;

    public PharmacistPanel() {
        setContentPane(PharmaPanel);
        setSize(700, 500);
        setVisible(true);

        addNewStockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddNewStock addNewStock= new AddNewStock ();


            }
        });
        removeExpiredStockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveExpiredStock removeExpiredStock=new RemoveExpiredStock();
                dispose();

            }
        });

        SellBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
            }
        });
    }
    public static void main(String[] args) {
        PharmacistLogin pharmacistLogin = new PharmacistLogin();


    }
}
