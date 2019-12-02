package com.patientsystem.com;

import com.patientsystem.com.Controller.Doctor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateDoctor {

    public static void main(String[] args) {
        CreateDoctor doc = new CreateDoctor();
        doc.openFrame();
    }

    public void openFrame() {
        JFrame frame = new JFrame("Add New Doctor");
        JLabel lSpeciality = new JLabel("Enter Speciality");
        JLabel lSpecialityDescription = new JLabel("Enter Speciality Description");
        JLabel lFirstname = new JLabel("Enter Firstname");
        JLabel lMiddlename = new JLabel("Enter Middlename");
        JLabel lLastname = new JLabel("Enter Lastname");
        JLabel lGender = new JLabel("Select Gender");
        JLabel lResNum = new JLabel("Enter Residence Number");
        JLabel lCellNum = new JLabel("Enter Cell Number");
        JLabel lAddress = new JLabel("Enter Address");
        JLabel lEmail = new JLabel("Enter Email");
        JLabel lUsername = new JLabel("Enter Username");
        JLabel lPassword = new JLabel("Enter password");

        JTextField speciality = new JTextField();
        speciality.setColumns(15);
        JTextField specialityDesc = new JTextField();
        specialityDesc.setColumns(20);
        JTextField firstname = new JTextField();
        firstname.setColumns(15);
        JTextField middlename = new JTextField();
        middlename.setColumns(15);
        JTextField lastname = new JTextField();
        lastname.setColumns(15);
        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");

        ButtonGroup bg = new ButtonGroup();

        JTextField resNum = new JTextField();
        resNum.setColumns(15);
        JTextField cellNum = new JTextField();
        cellNum.setColumns(15);
        JTextField address = new JTextField();
        address.setColumns(15);
        JTextField email = new JTextField();
        email.setColumns(15);
        JTextField username = new JTextField();
        username.setColumns(15);
        JPasswordField password = new JPasswordField();
        password.setColumns(15);

        JButton save = new JButton("Save Doctor");

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Doctor doc = new Doctor();
                String gender;
                if(male.isSelected()) {
                    gender = "MALE";
                }
                if(female.isSelected()) {
                    gender = "FEMALE";
                }


            }
        });

        bg.add(male);
        bg.add(female);

        frame.add(lSpeciality);
        frame.add(speciality);
        frame.add(lSpecialityDescription);
        frame.add(specialityDesc);
        frame.add(lFirstname);
        frame.add(firstname);
        frame.add(lLastname);
        frame.add(lastname);
        frame.add(lMiddlename);
        frame.add(middlename);
        frame.add(lGender);
        frame.add(male);
        frame.add(female);
        frame.add(lResNum);
        frame.add(resNum);
        frame.add(lCellNum);
        frame.add(cellNum);
        frame.add(lAddress);
        frame.add(address);
        frame.add(lEmail);
        frame.add(email);
        frame.add(lUsername);
        frame.add(username);
        frame.add(lPassword);
        frame.add(password);
        frame.add(save);

        frame.setSize(250, 600);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
    }
}
