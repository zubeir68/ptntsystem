package com.patientsystem.com;

import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login {

    public static void main(String[] args) {
    }

    public void openFrame(String subject) {
        JFrame fLogin = new JFrame(String.format("Login To %s Page ", subject));
        JPanel panel = new JPanel();
        JLabel label = new JLabel(String.format("Login to %s Page", subject));
        JTextField textField1 = new JTextField("");
        JPasswordField passwordField1 = new JPasswordField("");
        JButton button1 = new JButton("Login");
        JLabel error = new JLabel();
        JLabel usernameLabel = new JLabel("Username");
        JLabel passwordLabel = new JLabel("Password");
        JButton backbutton = new JButton("Home");

        //Settings

        button1.setBounds(50,50, 150,20);
        textField1.setBounds(50,100, 200,30);
        passwordField1.setBounds(50,100, 200,30);
        textField1.setColumns(15);
        passwordField1.setColumns(15);
        error.setForeground(Color.red);

        // Login Event

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Login lAction = new Login();
                String password = String.valueOf(passwordField1.getPassword());
                Boolean res = lAction.login(password, textField1.getText(), subject.toLowerCase());
                if(res) {
                    if(subject == "Admin") {
                        fLogin.dispose();
                        new AdminMain(textField1.getText()).setVisible(true);
                    }

                    if(subject == "Receptionist") {
                        fLogin.dispose();
                        new ReceptionistMain(textField1.getText()).setVisible(true);
                    }

                    if(subject == "Doctor") {
                        fLogin.dispose();
                        new DoctorMain(textField1.getText()).setVisible(true);
                    }
                } else {
                   JOptionPane.showMessageDialog(null, "Username or Password is wrong");
                   passwordField1.setText("");
                }
            }
        });
        
        backbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fLogin.dispose();
                new Main().openFrame();
            }
        });


        //Finishing
        panel.add(backbutton);
        panel.add(usernameLabel);
        panel.add(textField1);
        panel.add(passwordLabel);
        panel.add(passwordField1);
        panel.add(button1);
        panel.add(error);
        fLogin.add(panel);
        fLogin.setLayout(new FlowLayout());
        fLogin.setSize(900,500);
        fLogin.setVisible(true);
    }

    public Boolean login(String password, String username, String  subject) {
        try {
            DbConnection db = new DbConnection();
            Connection connection = db.get_connection();

            String query = String.format("SELECT * FROM %s WHERE User_Name = '%s' AND Password = '%s'", subject, username, password);

            Statement st = connection.createStatement();

            ResultSet rs = st.executeQuery(query);

            if (!rs.next()) {
                return false;
            }

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

        return true;
    }
}
