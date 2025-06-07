package com.musembi.pharma;

    import javax.swing.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.sql.SQLException;


public class RegisterDoctor extends JFrame {
    private JTextField usernameInput;
    private JPasswordField passwordField;
    private JButton registerButton;
    private JButton backButton;
    private JPanel RegisterDoctor;
    private JLabel UsernameField;

    public RegisterDoctor() {


        setContentPane(RegisterDoctor);
        setSize(700, 500);
        setVisible(true);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerDoctorToDatabase();

            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DoctorLogin doctorLogin= new DoctorLogin();
                dispose();
            }
        });
    }

    public void registerDoctorToDatabase() {

        String username = usernameInput.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(RegisterDoctor, "Please fill in both username and password fields.");
            return;

        }
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_musembi_victor_166341", "root", "rehanais2cool")) {
                String sql = "INSERT INTO tbl_doctor(username,password) VALUES(?, ?)";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);


                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(RegisterDoctor, "Doctor's details added successfully");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(RegisterDoctor, "Error: Failed to add doctor to the database");
                ex.printStackTrace();
            }
        }

    public static void main(String[] args) {
        LoginForm Gui = new LoginForm();
    }
    }


