package com.patientsystem.com;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.openFrame();
    }

    public void openFrame() {
        JFrame f = new JFrame("Patient System");
        JPanel panel = new JPanel();
        JLabel header = new JLabel("Welcome to Patient System");
        header.setBounds(0,0,0, 0);
        JButton admin_button = new JButton("Admin Page");
        JButton rec_button = new JButton("Receptionist Page");
        JButton doctor_button = new JButton("Doctor Page");
        admin_button.setBounds(50,50, 150,20);
        rec_button.setBounds(50,50, 150,20);
        doctor_button.setBounds(50,50, 150,20);

        //Events

        admin_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                f.dispose();
                Login login = new Login();
                login.openFrame("Admin");
            }
        });

        rec_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                f.dispose();
                Login login = new Login();
                login.openFrame("Receptionist");
            }
        });

        doctor_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                f.dispose();
                Login login = new Login();
                login.openFrame("Doctor");
            }
        });


        f.setLayout(new FlowLayout());
        panel.setLayout(new FlowLayout());
        f.add(header);
        panel.add(admin_button);
        panel.add(rec_button);
        panel.add(doctor_button);
        f.add(panel);
        f.setSize(500,500);
        f.setVisible(true);
        
    }
}
