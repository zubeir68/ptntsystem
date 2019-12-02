package com.patientsystem.com;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.patientsystem.com.Controller.Doctor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;

public class ManageDoctor extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageDoctor frame = new ManageDoctor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public void openFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageDoctor frame = new ManageDoctor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ManageDoctor() {
		setTitle("Doctor Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 836, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{826, 0};
		gbl_contentPane.rowHeights = new int[]{25, 0, 395, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnNewButton = new JButton("Add Doctor");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreateDoctor createDoc = new CreateDoctor();
				createDoc.openFrame();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		table = new JTable();
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.insets = new Insets(0, 0, 5, 0);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 2;
		contentPane.add(table, gbc_table);
		
		
		// Table data
		String[] columns = {"Id", "Specialty", "Firstname", "Middlename", "Lastname", "Gender", "Residence Number", "Cell Number", "Address", "Email", "Date Employed", "Username"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        
        tableModel.addRow(columns);

        try {
            Doctor doc = new Doctor();
            ResultSet rs = doc.get();
            while(rs.next()) {
                String id = Integer.toString(rs.getInt("Doctor_id"));
                String specialty = Integer.toString(rs.getInt("Specialty_id"));
                String firstname = rs.getString("First_Name");
                String middlename = rs.getString("Middle_Name");
                String lastname = rs.getString("Last_Name");
                String gender = rs.getString("Gender");
                String residence = Integer.toString(rs.getInt("Residence_Number"));
                String cell = Integer.toString(rs.getInt("Cell_Number"));
                String address = rs.getString("Address");
                String email = rs.getString("Email");
                String date = rs.getDate("Date_Employed").toString();
                String username = rs.getString("User_Name");
                String password = rs.getString("Password");

                String[] data = { id, specialty, firstname, middlename, lastname, gender, residence, cell, address, email, date, username, password };

                tableModel.addRow(data);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        table.setModel(tableModel);
	}

}
