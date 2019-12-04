package com.patientsystem.com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMain {
    public static void main(String[] args) {

    }

    public void openFrame() {
        JMenu menu;
        JMenuItem i1, i2, i3;
        JFrame frame = new JFrame("Admin Main Page");
        JMenuBar menuBar = new JMenuBar();
        menu=new JMenu("Menu");
        i1=new JMenuItem("Patient");
        i2=new JMenuItem("Receptionist");
        i3=new JMenuItem("Doctor");
        menu.add(i1); menu.add(i2); menu.add(i3);
        menuBar.add(menu);
        
        i1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
                new ManagePatient().setVisible(true);
            }
        });

        //Events
        i3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
                new ManageDoctor().setVisible(true);
            }
        });
        
        i2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
                new ManageReceptionist().setVisible(true);
            }
        });

        // Finishing
        frame.setJMenuBar(menuBar);
        frame.setSize(500,500);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);

    }
}
