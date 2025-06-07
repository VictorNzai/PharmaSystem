package com.musembi.pharma;

    import javax.swing.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;

public class LoginForm extends JFrame {

    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton loginAsDoctorButton;

    private JButton loginAsPharmacistButton;

    private JPanel LoginFormPanel;

    public LoginForm() {
        setContentPane(LoginFormPanel);
        setSize(700, 500);
        setVisible(true);


        // registering listeners


        loginAsDoctorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DoctorLogin doctorLogin = new DoctorLogin();
                setVisible(true);
                dispose();

            }
        });
        loginAsPharmacistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PharmacistLogin pharmacistLogin = new PharmacistLogin();
                dispose();

            }
        });

    }
    public static void main(String[] args) {
        LoginForm gui = new LoginForm();

    }
}